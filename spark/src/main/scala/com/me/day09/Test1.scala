package com.me.day09

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{DataFrame, Row, SparkSession}
import org.apache.spark.sql.expressions.{MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types.{DataType, LongType, StructField, StructType}

/**
 * @author maow
 * @create 2020-06-12 11:21
 */
object Test1 {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSql")

    val spark: SparkSession = SparkSession.builder().config(conf).getOrCreate()

    spark.read.load()
    import spark.implicits._

    val sc: SparkContext = spark.sparkContext
    val rdd: RDD[(Int, String, Int)] = sc.makeRDD(List((1,"zhangsan",30),(2,"lisi",28),(3,"wangwu",20)))

    val frame: DataFrame = rdd.toDF("id","name","age")
    frame.createOrReplaceTempView("user")
    val uDAFAge = new UDAFAge
    spark.udf.register("avgAge",uDAFAge)
    spark.sql("select avgAge(age) from user").show()

    spark.stop()
  }
}

class UDAFAge extends UserDefinedAggregateFunction{
  override def inputSchema: StructType = {
    StructType(Array(StructField("age",LongType)))
  }

  override def bufferSchema: StructType = {
    StructType(Array(
      StructField("total",LongType),
      StructField("count",LongType)
    ))
  }

  override def dataType: DataType = LongType

  override def deterministic: Boolean = true

  override def initialize(buffer: MutableAggregationBuffer): Unit = {
    // 总和
//    buffer.update(0,0L)
    buffer(0) = 0L
    // 个数
    buffer(1) = 0L
  }


  override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
    buffer(0) = buffer.getLong(0) + input.getLong(0)
    buffer(1) = buffer.getLong(1) + 1
  }

  override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
    buffer1(0) = buffer1.getLong(0) + buffer2.getLong(0)
    buffer1(1) = buffer1.getLong(1) + buffer2.getLong(1)
  }

  override def evaluate(buffer: Row): Any = {
    buffer.getLong(0) / buffer.getLong(1)
  }
}

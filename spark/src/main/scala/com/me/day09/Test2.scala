package com.me.day09

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.expressions.Aggregator
import org.apache.spark.sql.{Dataset, Encoder, Encoders, SparkSession, TypedColumn}

/**
 * @author maow
 * @create 2020-06-12 19:33
 */
object Test2 {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSql2")
    val spark: SparkSession = SparkSession.builder().config(conf).getOrCreate()
    import spark.implicits._

    val sc: SparkContext = spark.sparkContext
    val rdd: RDD[(Int, String, Int)] = sc.makeRDD(List((1,"zhangsan",32),(2,"lisi",30),(3,"wangwu",22)))
    val value: Dataset[User1] = rdd.map(t => {
      User1(t._1, t._2, t._3)
    }).toDS()

    val uDAF2Age = new UDAF2Age
    val column: TypedColumn[User1, Long] = uDAF2Age.toColumn
    value.select(column).show()


    spark.stop()
  }
}

class UDAF2Age extends Aggregator[User1,AgeBuffer,Long]{
  override def zero: AgeBuffer = {
    AgeBuffer(0L,0L)
  }

  override def reduce(b: AgeBuffer, a: User1): AgeBuffer = {
    b.sum += a.age
    b.count += 1
    b
  }

  override def merge(b1: AgeBuffer, b2: AgeBuffer): AgeBuffer = {
    b1.sum += b2.sum
    b1.count += b2.count
    b1
  }

  override def finish(reduction: AgeBuffer): Long = {
    reduction.sum / reduction.count
  }

  override def bufferEncoder: Encoder[AgeBuffer] = {
    Encoders.product
  }

  override def outputEncoder: Encoder[Long] = {
    Encoders.scalaLong
  }
}

case class AgeBuffer(var sum:Long,var count:Long)
case class User1(id:Long,name:String,age: Long)

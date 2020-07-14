package com.me.day01

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author maow
 * @create 2020-06-01 21:40
 */
object WordCount2 {
  def main(args: Array[String]): Unit = {
    //TODO 1. 准备Spark环境
    val sparkConf: SparkConf = new SparkConf().setMaster("local").setAppName("wordCount")

    //TODO 2.建立和Spark的连接
    val context: SparkContext = new SparkContext(sparkConf)
    // TODO 3. 实现业务操作
    val value: RDD[String] = context.textFile("input")
    val array1: Array[String] = value.collect()
    println(array1.mkString(","))
    val value1: RDD[(String, Int)] = value.flatMap(_.split(" ")).map((_,1))
    val value2: RDD[(String, Int)] = value1.reduceByKey(_+_ )
    val array: Array[(String, Int)] = value2.collect()
    println(array.mkString(","))
    // TODO 4. 释放连接
    context.stop()
  }
}

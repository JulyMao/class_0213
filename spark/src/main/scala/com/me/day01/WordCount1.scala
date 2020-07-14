package com.me.day01

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author maow
 * @create 2020-06-01 21:01
 */
object WordCount1 {
  def main(args: Array[String]): Unit = {
    //TODO 1. 准备Spark环境
    val sparkConf: SparkConf = new SparkConf().setMaster("local").setAppName("wordCount")

    //TODO 2.建立和Spark的连接
    val context: SparkContext = new SparkContext(sparkConf)
    // TODO 3. 实现业务操作
    val value: RDD[String] = context.textFile("input")
    val value1: RDD[String] = value.flatMap(_.split(" "))
    val array1: Array[String] = value1.collect()
    println(array1.mkString(","))
    val value2: RDD[(String, Iterable[String])] = value1.groupBy(word=>word)
    val value3: RDD[(String, Int)] = value2.map{case (str,iter) => (str,iter.size)}
    val array: Array[(String, Int)] = value3.collect()
    println(array.mkString(","))
    // TODO 4. 释放连接
    context.stop()
  }
}

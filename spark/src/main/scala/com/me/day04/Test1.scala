package com.me.day04

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author maow
 * @create 2020-06-05 10:48
 */
object Test1 {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("spark1")
    val sparkContext = new SparkContext(sparkConf)
    val dataRDD = sparkContext.makeRDD(List(
      1,2,3,4,5,6
    ),3)
    val dataRDD1 = sparkContext.makeRDD(List(
      1,2,3,4
    ),2)
//    val dataRDD2 = dataRDD.sample(false, 0.5)
//    println(dataRDD2.collect().mkString(","))

    println(dataRDD.zip(dataRDD1).collect().mkString(","))

  }
}

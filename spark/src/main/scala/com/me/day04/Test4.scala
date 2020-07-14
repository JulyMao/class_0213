package com.me.day04

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author maow
 * @create 2020-06-05 19:51
 */
object Test4 {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("spark4")
    val sc = new SparkContext(sparkConf)

    val value: RDD[Int] = sc.makeRDD(List(1,2,3,4),2)
    val value1: RDD[Int] = sc.makeRDD(List(3,4,5,6),2)

    // TODO intersection

//    println(value.intersection(value1).collect().mkString(","))

    // TODO union

//    println(value.union(value1).collect().mkString(","))

    // TODO subtract

//    println(value.subtract(value1).collect().mkString(","))

    // TODO zip

//    println(value.zip(value1).collect().mkString(","))



    sc.stop()
  }
}

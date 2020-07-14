package com.me.day04

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author maow
 * @create 2020-06-05 19:29
 */
object Test3 {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("spark3")
    val sc = new SparkContext(sparkConf)

    val value: RDD[Int] = sc.makeRDD(List(1,2,1,3,4),2)

    // TODO sample
//    val value1: RDD[Int] = value.sample(false,0.5,1)
//    println(value1.collect().mkString(","))

    // TODO distinct
//    val value1: RDD[Int] = value.distinct()
//    println(value1.collect().mkString(","))

    // TODO coalesce

//    println(value.coalesce(1).collect().mkString(","))

    // TODO repartition

//    println(value.repartition(4).collect().mkString(","))

    // TODO sortBy
//    println(value.sortBy(i => i,false,4).collect().mkString(","))

    // TODO pipe



    sc.stop()
  }
}

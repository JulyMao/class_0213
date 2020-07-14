package com.me.day03

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author maow
 * @create 2020-06-03 16:25
 */
object Test1 {
  def main(args: Array[String]): Unit = {


    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("spark")
    val sparkContext = new SparkContext(sparkConf)

    val value: RDD[Int] = sparkContext.makeRDD(List(1,2,3,4,5),2)
    val value1: RDD[Int] = value.mapPartitions(data => {
      data
    })
    value1.saveAsTextFile("output7")
    value.groupBy(_%2,2)
//    println(value1.collect().mkString(","))


    sparkContext.stop()
  }
}

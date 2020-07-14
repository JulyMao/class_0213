package com.me.day05

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author maow
 * @create 2020-06-06 8:37
 */
object Test2 {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("spark2")
    val sc = new SparkContext(sparkConf)

    val value: RDD[(String, Int)] = sc.makeRDD(List(
//      ("a", 2), ("a", 1),
//      ("b", 1), ("b", 3)
//      (1,"a"),(2,"b"),
//      (1,"b"),(2,"a")
    ))

    val value1: RDD[(Int, String)] = sc.makeRDD(List(
      (1, "a"), (2, "b"),
      (1, "b"), (2, "a")
    ))

    val intToLong: collection.Map[Int, Long] = value1.countByKey()
    println(intToLong)





    sc.stop()
  }
}

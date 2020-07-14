package com.me.day02

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author maow
 * @create 2020-06-02 21:18
 */
object Test2 {
  def main(args: Array[String]): Unit = {
    val spark: SparkConf = new SparkConf().setMaster("local[*]").setAppName("spark1")
    val context = new SparkContext(spark)

    val value: RDD[String] = context.textFile("input",3)
    value.saveAsTextFile("output6 ")

    context.stop()
  }
}

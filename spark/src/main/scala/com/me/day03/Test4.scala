package com.me.day03

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author maow
 * @create 2020-06-02 21:18
 */
object Test4 {
  def main(args: Array[String]): Unit = {
    val spark: SparkConf = new SparkConf().setMaster("local[*]").setAppName("spark4")
    val context = new SparkContext(spark)

    val value: RDD[String] = context.textFile("input",4)
    value.saveAsTextFile("output9")

    context.stop()
  }
}

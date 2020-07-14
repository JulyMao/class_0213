package com.me.day02

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author maow
 * @create 2020-06-02 21:10
 */
object Test1 {
  def main(args: Array[String]): Unit = {
    val sparkConf =
      new SparkConf().setMaster("local[*]").setAppName("spark")
    val sparkContext = new SparkContext(sparkConf)
    val rdd1 = sparkContext.parallelize(
      List(1,2,3,4)
    )
    val rdd2 = sparkContext.makeRDD(
      List(1,2,3,4),
    )
    rdd1.collect().foreach(println)
//    rdd2.collect().foreach(println)
    rdd2.saveAsObjectFile("output4")
    sparkContext.stop()

  }
}

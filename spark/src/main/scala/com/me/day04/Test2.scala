package com.me.day04

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author maow
 * @create 2020-06-05 16:12
 */
object Test2 {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("spark2")
    val sc = new SparkContext(sparkConf)

    val value1: RDD[(String, Int)] = sc.makeRDD(List(("a",1),("a",2),("c",3),("b",4),("c",5),("c",6)),2)
    val value2: RDD[(String, Int)] = sc.makeRDD(List(("b",4),("c",6)))

    val value3: RDD[(String, Int)] = value1.aggregateByKey(10)(
      Math.max(_, _),
      (_ + _)
    )
    value3.saveAsTextFile("output10")


    sc.stop()
  }
}

package com.me.day04

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author maow
 * @create 2020-06-05 21:13
 */
object Test6 {
  def main(args: Array[String]): Unit = {
    //3. 小练习：不使用distinct实现数据去重

    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("spark6")
    val sc = new SparkContext(sparkConf)

    val value = sc.makeRDD(List(
      1,2,3,4,2,4,5,1
    ),2)

    // groupBy
//    println(value.groupBy(i => i).map(_._1).collect().toList)

    // set
//    println(value.collect().toSet)



    sc.stop()

  }
}

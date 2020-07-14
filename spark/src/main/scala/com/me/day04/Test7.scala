package com.me.day04

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author maow
 * @create 2020-06-05 21:21
 */
object Test7 {
  def main(args: Array[String]): Unit = {
    //4. 小练习：独立写出6种不同算子的WordCount

    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("spark7")
    val sc = new SparkContext(sparkConf)

    val value: RDD[String] = sc.makeRDD(List("hello spark","hello scala", "hello kafka", "kafka flume"),2)

//    //1 groupBy
//    println(value.flatMap(_.split(" ")).groupBy(word => word).map(t => (t._1, t._2.size)).collect().toList)

//    //2 reduceByKey
//    println(value.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _).collect().toList)

//    //3 groupByKey
//    println(value.flatMap(_.split(" ")).map((_, 1)).groupByKey().map(t => (t._1, t._2.sum)).collect().toList)

//    //4 aggregateByKey
//    println(value.flatMap(_.split(" ")).map((_, 1)).aggregateByKey(0)(_ + _, _ + _).collect().toList)

//    //5 foldByKey
//    println(value.flatMap(_.split(" ")).map((_, 1)).foldByKey(0)(_ + _).collect().toList)

//    //6 combineByKey
//    val value1: RDD[(String, Int)] = value.flatMap(_.split(" ")).map((_, 1)).combineByKey(
//      v => {
//        v
//      },
//      (v1: Int, v2) => {
//        v1 + v2
//      },
//      (v1: Int, v2: Int) => {
//        v1 + v2
//      }
//    )
//    println(value1.collect().toList)
    sc.stop()

  }
}

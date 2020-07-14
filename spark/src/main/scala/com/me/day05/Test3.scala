package com.me.day05

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author maow
 * @create 2020-06-05 21:21
 */
object Test3 {
  def main(args: Array[String]): Unit = {
    //4. 小练习：独立写出10种不同算子的WordCount

    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkWordCount")
    val sc = new SparkContext(sparkConf)

    val value: RDD[String] = sc.makeRDD(List("hello spark", "hello scala", "hello kafka", "kafka flume"), 2)
    val value1: RDD[String] = sc.makeRDD(List("hello mao", "hello wei", "hello wei", "mao wei"), 2)

//    //TODO 1 groupBy
//    println(value.flatMap(_.split(" ")).groupBy(word => word).map(t => (t._1, t._2.size)).collect().toList)
//
//    //TODO 2 reduceByKey
//    println(value.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _).collect().toList)
//
//    //TODO 3 groupByKey
//    println(value.flatMap(_.split(" ")).map((_, 1)).groupByKey().map(t => (t._1, t._2.sum)).collect().toList)
//
//    //TODO 4 aggregateByKey
//    println(value.flatMap(_.split(" ")).map((_, 1)).aggregateByKey(0)(_ + _, _ + _).collect().toList)
//
//    //TODO 5 foldByKey
//    println(value.flatMap(_.split(" ")).map((_, 1)).foldByKey(0)(_ + _).collect().toList)
//
//    //TODO 6 combineByKey
//    val value6: RDD[(String, Int)] = value.flatMap(_.split(" ")).map((_, 1)).combineByKey(
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
//    println(value6.collect().toList)
//
//    //TODO 7 countByKey
//    println(value.flatMap(_.split(" ")).map((_, 1)).countByKey())
//
//    //TODO 8 cogroup
//    val value8_1: RDD[(String, Int)] = value.flatMap(_.split(" ")).map((_, 1))
//    val value8_2: RDD[(String, Int)] = value1.flatMap(_.split(" ")).map((_, 1))
//    println(value8_1.cogroup(value8_2).mapValues(t => {
//      t._1.size + t._2.size
//    }).collect().toList)
//
//    //TODO 9 countByValue  Map[String, Long]
    println(value.flatMap(_.split(" ")).countByValue())
//
//    //TODO 10 combineByKeyWithClassTag
//    val value10: RDD[(String, Int)] = value.flatMap(_.split(" ")).map((_, 1)).combineByKeyWithClassTag(
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
//    println(value10.collect().toList)

    //11
//    value.flatMap(_.split(" ")).map((_,1))
//    value.cache()


    sc.stop()





  }
}

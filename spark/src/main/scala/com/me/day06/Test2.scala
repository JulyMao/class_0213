package com.me.day06

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author maow
 * @create 2020-06-08 20:19
 */
object Test2 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.makeRDD(List(1,2,3,4),2)
    val rdd4 = sc.makeRDD(List(3,4,5,6),2)
    val rdd3 = sc.makeRDD(List("a","b","b","d"))
    val rdd1 = sc.makeRDD(List(("a",1),("b",2),("a",2)),2)
    val rdd2 = sc.makeRDD(List(("a",1),("b",2)),1)
    val value: RDD[(String, (Iterable[Int], Iterable[Int]))] = rdd1.cogroup(rdd2)
    val value1: RDD[Int] = rdd.union(rdd4)

//    rdd1.reduceByKey(_+_)
//    rdd3.reduce(_+_)

////
//    val mapRDD: RDD[(Int, Int)] = rdd.map( num=>{
//      println("map......")
//      (num,1)
//    } )
//    println(mapRDD.toDebugString)
//
//    val cacheRDD: RDD[(Int, Int)] = mapRDD.cache()
//    println(cacheRDD.collect().mkString(","))
//    println(cacheRDD.toDebugString)
//    println("****************************")
//    println(cacheRDD.collect().mkString("&"))
//        println(value.dependencies)
        println(value1.getNumPartitions)
//        println(value.saveAsTextFile("output11"))
    rdd1.saveAsTextFile("output12")



    sc.stop()
  }
}

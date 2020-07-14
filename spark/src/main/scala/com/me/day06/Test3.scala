package com.me.day06

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author maow
 * @create 2020-06-08 20:41
 */
object Test3 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
    val sc = new SparkContext(sparkConf)
    sc.setCheckpointDir("cp")

    val rdd = sc.makeRDD(List(1,2,3,4))

    val mapRDD: RDD[(Int, Int)] = rdd.map( num=>{
      (num,1)
    } )
    val value: RDD[((Int, Int), Int)] = mapRDD.map((_,1))

    value.checkpoint()
    println(value.toDebugString)
    println(value.collect().mkString(","))
    println(value.toDebugString)


    sc.stop()

  }
}

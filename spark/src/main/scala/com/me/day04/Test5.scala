package com.me.day04

import org.apache.spark.rdd.RDD
import org.apache.spark.{HashPartitioner, Partitioner, SparkConf, SparkContext}

/**
 * @author maow
 * @create 2020-06-05 20:16
 */
object Test5 {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("spark5")
    val sc = new SparkContext(sparkConf)

    val value: RDD[(String, Int)] = sc.makeRDD(List(("a",1),("b",2),("a",3),("d",4),("c",3),("c",2)),2)

    // TODO partitionBy
//    val value1: RDD[(String, Int)] = value.partitionBy(new HashPartitioner(4))
    ////    println(value1.collect().toList)

    // TODO reduceByKey

//    println(value.reduceByKey(_ + _, 4).collect().toList)

    // TODO groupByKey

//    println(value.groupByKey(4).collect().toList)

    // TODO	aggregateByKey

//    println(value.aggregateByKey(0)(Math.max(_, _), _ + _).collect().toList)

    // TODO	foldByKey

//    println(value.foldByKey(0)(_ + _).collect().toList)

    // TODO	combineByKey

    val value1: RDD[(String, (Int, Int))] = value.combineByKey(
      (_, 1),
      (t: (Int, Int), v) => {
        (t._1 + v, t._2 + 1)
      },
      (t1: (Int, Int), t2: (Int, Int)) => {
        (t1._1 + t2._1, t2._2 + t2._2)
      }
    )
    val value2: RDD[(String, Int)] = value1.map(t => {
      (t._1, t._2._1 / t._2._2)
    })
    println(value2.collect().toList)


    sc.stop()
  }
}

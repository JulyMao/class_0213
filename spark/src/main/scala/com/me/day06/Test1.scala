package com.me.day06

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.util.AccumulatorV2

import scala.collection.mutable

/**
 * @author maow
 * @create 2020-06-08 15:08
 */
object Test1 {
  def main(args: Array[String]): Unit = {

    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("spark1")
    val sc = new SparkContext(sparkConf)
    val value: RDD[String] = sc.makeRDD(List("a","b","b","a","a"))
    val acc = new WordCountAccumulator()
    sc.register(acc,"wordCount")
//    val name: Option[String] = acc.name
//    println(name)


    value.foreach(
      str=>{
          acc.add(str)

      }
    )
    println(acc.value)

    sc.stop()

  }

}


class WordCountAccumulator extends AccumulatorV2[String,mutable.Map[String,Int]]{

  var wordCountMap : mutable.Map[String,Int] = mutable.Map()

  override def isZero: Boolean = {
    wordCountMap.isEmpty
  }

  override def copy(): AccumulatorV2[String, mutable.Map[String, Int]] = {
    val accumulator = new WordCountAccumulator
    accumulator.wordCountMap = this.wordCountMap
    accumulator
  }

  override def reset(): Unit = {
    wordCountMap.clear()
  }

  override def add(word: String): Unit = {
    wordCountMap(word) = wordCountMap.getOrElse(word,0) + 1
  }

  override def merge(other: AccumulatorV2[String, mutable.Map[String, Int]]): Unit = {
    val map1 = wordCountMap
    val map2 = other.value

    wordCountMap = map1.foldLeft(map2)((map,kv)=>{
      map(kv._1) = map.getOrElse(kv._1,0) + kv._2
      map
    })

  }

  override def value: mutable.Map[String, Int] = {
    wordCountMap
  }
}

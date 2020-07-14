package com.me.day05

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author maow
 * @create 2020-06-06 8:37
 */
object Test1 {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("spark1")
    val sc = new SparkContext(sparkConf)

    // todo 统计出每一个省份每个广告被点击数量排行的Top3
    //      agent.log：时间戳，省份，城市，用户，广告，中间字段使用空格分隔
    val value: RDD[String] = sc.textFile("input/agent.log")

    val value1: RDD[(String, Int)] = value.map(
      s => {
        val strings: Array[String] = s.split(" ")
        (strings(1) + "-" + strings(4), 1)
      }
    )
    val value2: RDD[(String, Iterable[Int])] = value1.groupByKey()

    val value3: RDD[(String, Int)] = value2.mapValues(_.sum)

    val value4: RDD[(String, (String, Int))] = value3.map(t => {
      val strings: Array[String] = t._1.split("-")
      (strings(0), (strings(1), t._2))
    })

    val value5: RDD[(String, Iterable[(String, Int)])] = value4.groupByKey()

    val value6: RDD[(String, List[(String, Int)])] = value5.mapValues(iter => {
      iter.toList.sortWith(_._2 > _._2).take(3)
    })
    value6.collect().toList.foreach(println)





    sc.stop()
  }
}

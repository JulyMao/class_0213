package com.me.day11

import java.text.SimpleDateFormat

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.collection.mutable

/**
 * @author maow
 * @create 2020-06-15 9:35
 */
object Test1 {
  def main(args: Array[String]): Unit = {
//    //1.初始化Spark配置信息
//    val conf = new SparkConf().setMaster("local[*]").setAppName("RDDStream")
//
//    //2.初始化SparkStreamingContext
//    val ssc = new StreamingContext(conf, Seconds(3))
//    ssc.sparkContext.setCheckpointDir("cp")
//    val ds: ReceiverInputDStream[String] = ssc.socketTextStream("localhost",9999)
//
//
//    val value: DStream[(String, Int)] = ds.map((_,1))
//    val ipCountDStream = value.reduceByKeyAndWindow(
//      {(x, y) => x + y},
//      {(x, y) => x - y},
//      Seconds(9),
//      Seconds(3))
//
//    ipCountDStream.print()
//
//    //7.启动任务
//    ssc.start()
//
//    ssc.awaitTermination()

    val format = new SimpleDateFormat("yyyy-MM-dd")
    val l: Long = format.parse("2020-06-22").getTime - format.parse("2020-06-21").getTime
    println(l / (3600 * 24 * 1000))
//    println(format.parse("2020-06-22"))
  }
}

package com.me.day10

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * @author maow
 * @create 2020-06-14 14:18
 */
object Test3 {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkStream")

    val ssc = new StreamingContext(conf,Seconds(3))

    val ds: ReceiverInputDStream[String] = ssc.socketTextStream("localhost",9999)
    val newDS: DStream[String] = ds.transform(rdd => {
      println("11111")
      rdd.map(t=>{
        println("22222")
        t*2
      })
    })
    newDS.print()

    ssc.start()

    ssc.awaitTermination()

  }
}

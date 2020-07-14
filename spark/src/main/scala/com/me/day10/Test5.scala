package com.me.day10

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * @author maow
 * @create 2020-06-14 18:59
 */
object Test5 {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("ss")

    val ssc: StreamingContext = new StreamingContext(conf,Seconds(3))

    ssc.sparkContext.setCheckpointDir("cp")
    val value: ReceiverInputDStream[String] = ssc.socketTextStream("localhost",9999)

    val value1: DStream[(String, Int)] = value.map((_,1))

    val value2: DStream[(String, Int)] = value1.reduceByKeyAndWindow(
      (i1, i2) => i1 + i2,
      Seconds(6)
//      Seconds(3)
    )


//    val value1: DStream[String] = value.window(Seconds(6))

//    val value2: DStream[(String, Int)] = value1.map((_,1))
//    val value3: DStream[(String, Int)] = value2.reduceByKey(_+_)

    value2.print()

    ssc.start()
    ssc.awaitTermination()
  }
}

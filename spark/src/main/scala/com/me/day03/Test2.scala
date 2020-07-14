package com.me.day03

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author maow
 * @create 2020-06-04 10:09
 */
object Test2 {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("spark2")
    val sc = new SparkContext(sparkConf)

    val value: RDD[Int] = sc.makeRDD(
      List(1, 2, 3, 4),3
    )

   val value0: RDD[List[Int]] = sc.makeRDD(
     List(List(1,2),List(3,4)),2
   )

    // TODO map
//    val value1: RDD[Int] = value.map(_*2)
//    println(value1.collect().mkString(","))

    //TODO mapPartitions
//    val value1: RDD[Int] = value.mapPartitions(iter => {
////      iter.foreach(println)
//      List(iter.max).iterator
//    })
//    println(value1.collect().mkString(","))

    // TODO mapPartitionsWithIndex
//    println(value.mapPartitionsWithIndex((index, iter) => {
//      List((index, iter.max)).iterator
//    }).collect().mkString(","))
//        println(value.mapPartitionsWithIndex((index, iter) => {
//          iter.map((index,_))
//        }).collect().mkString(","))

    // TODO flatMap

//    println(value0.flatMap(list => {
//      list
//    }).collect().mkString(","))

    // TODO 	小功能：将List(List(1,2),3,List(4,5))进行扁平化操作

//    val value1: RDD[Any] = sc.makeRDD(List(List(1,2),3,List(4,5)),4)
//
//    println(value1.flatMap(any => {
//      any match {
//        case i: Int => Map("a"->1)
//        case list: List[_] => list
//        case _ => List()
//      }
//    }).collect().mkString(","))

    // TODO glom
//    value.glom().collect()foreach(_.foreach(println))
    // TODO 	小功能：计算所有分区最大值求和（分区内取最大值，分区间最大值求和）
//    val value1: RDD[Array[Int]] = value.glom()
//    val value2: RDD[Int] = value1.map(arr => {
//      arr.max
//    })
//    println(value2.collect().sum)

    // TODO 	groupBy

//    val value1: RDD[(Int, Iterable[Int])] = value.groupBy(_%2,2)
//    value1.collect().foreach{
////        t._2.foreach(println)
//        case (i,iter) => println(i)
//    }

    // TODO 	小功能：将List("Hello", "hive", "hbase", "Hadoop")根据单词首写字母进行分组。

//    val value1: RDD[String] = sc.makeRDD(List("Hello", "hive", "hbase", "Hadoop"),2)
//    val value2: RDD[(String, Iterable[String])] = value1.groupBy(_.substring(0,1))
//    println(value2.collect().toList)


    // TODO 	小功能：从服务器日志数据apache.log中获取每个时间段访问量。
//    val value1: RDD[String] = sc.textFile("input/apache.log")
//
//    val value2: RDD[(String, Iterable[String])] = value1.groupBy(_.split(" ")(3).split(":")(0))
//    val value3: RDD[(String, Int)] = value2.map {
//      case (str, iter) => {
//        (str, iter.size)
//      }
//    }
//    println(value3.collect().toList)

    // TODO filter

//    println(value.filter(_ % 2 == 0).collect().mkString(","))
    // TODO 	小功能：从服务器日志数据apache.log中获取2015年5月17日的请求路径
//
//    val value1: RDD[String] = sc.textFile("input/apache.log")
//    val value2: RDD[String] = value1.filter(_.split(" ")(3).split(":")(0).equals("17/05/2015"))
//    val value3: RDD[String] = value2.map(_.split(" ")(6))
//    value3.collect().foreach(println)



    sc.stop()
  }
}

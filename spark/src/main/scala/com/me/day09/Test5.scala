package com.me.day09

import org.apache.spark.sql.SparkSession

/**
 * @author maow
 * @create 2020-06-12 20:51
 */
object Test5 {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession
      .builder()
      .enableHiveSupport()
      .master("local[*]")
      .appName("sql")
      .getOrCreate()

//    spark.sql("create database atguigu200213")
    spark.sql("show databases").show()
    spark.stop()

  }
}

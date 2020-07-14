package com.me.day09

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{Dataset, SaveMode, SparkSession}

/**
 * @author maow
 * @create 2020-06-12 20:13
 */
object Test3 {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSql2")
    val spark: SparkSession = SparkSession.builder().config(conf).getOrCreate()
    import spark.implicits._
    val sc: SparkContext = spark.sparkContext
    val rdd: RDD[(Int, String, Int)] = sc.makeRDD(List((1,"zhangsan",32),(2,"lisi",30),(3,"wangwu",22)))
    val value: RDD[User2] = rdd.map(t => {
      User2(t._1, t._2, t._3)
    })
    val ds: Dataset[User2] = value.toDS()

//    spark.read.format("jdbc")
//      .option("url", "jdbc:mysql://localhost:3306/spark-sql")
//      .option("driver", "com.mysql.jdbc.Driver")
//      .option("user", "root")
//      .option("password", "root")
//      .option("dbtable", "user")
//      .load().show

    ds.write
      .format("jdbc")
      .option("url", "jdbc:mysql://localhost:3306/spark-sql")
      .option("user", "root")
      .option("password", "root")
      .option("dbtable", "user1")
      .mode(SaveMode.Append)
      .save()


    spark.stop()
  }
}
case class User2(id:Long,name:String,age:Long)

package com.me.day09

import org.apache.spark.SparkConf
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.expressions.{MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types.{DataType, LongType, StructField, StructType}

/**
 * @author maow
 * @create 2020-06-12 21:02
 */
object Test7 {
  def main(args: Array[String]): Unit = {
    System.setProperty("HADOOP_USER_NAME", "atguigu")
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("sqlExer")
    val spark: SparkSession = SparkSession.builder().enableHiveSupport().config(conf).getOrCreate()
    import spark.implicits._
    spark.sql("use atguigu200213")

    spark.sql(
      """
        |select t4.area,t4.product_name,t4.click_time,ci1.city_name,
        |count(*) over(partition by ci1.city_name) as ct
        |from user_visit_action as ac1
        |join (
        |select *
        |from (
        |  select *,
        |  rank() over(partition by t2.area order by t2.click_time desc) as rk
        |  from (
        |    select *,count(*) as click_time
        |    from (
        |      select ci.area,pi.product_name,ac.click_product_id
        |      from user_visit_action as ac
        |      join product_info as pi on ac.click_product_id=pi.product_id
        |      join city_info as ci on ac.city_id=ci.city_id
        |      where ac.click_product_id>-1
        |    )t1
        |    group by t1.area,t1.product_name,t1.click_product_id
        |  )t2
        |)t3
        |where rk<3
        |)t4 on ac1.click_product_id=t4.click_product_id
        |join city_info ci1 on ac1.city_id=ci1.city_id
        |""".stripMargin).show()

    spark.stop()

  }
}
class HotProductCityRatio extends UserDefinedAggregateFunction{
  override def inputSchema: StructType ={
    StructType(Array(StructField("age",LongType)))
  }

  override def bufferSchema: StructType = ???

  override def dataType: DataType = ???

  override def deterministic: Boolean = ???

  override def initialize(buffer: MutableAggregationBuffer): Unit = ???

  override def update(buffer: MutableAggregationBuffer, input: Row): Unit = ???

  override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = ???

  override def evaluate(buffer: Row): Any = ???
}
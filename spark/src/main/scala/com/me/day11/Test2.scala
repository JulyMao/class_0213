package com.me.day11

import java.text.SimpleDateFormat
import java.util.Date

import org.apache.spark.sql.Row
import org.apache.spark.sql.expressions.{MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types.{DataType, LongType, StringType, StructField, StructType}

/**
 * @author maow
 * @create 2020-06-22 20:54
 */
object Test2 {

}
class UDAFdate extends UserDefinedAggregateFunction{
  val format = new SimpleDateFormat()
  override def inputSchema: StructType = {
    StructType(Array(StructField("startdate",StringType),StructField("enddate",StringType)))
  }

  override def bufferSchema: StructType = {
    StructType(Array(StructField("days",LongType),
      StructField("startdateBuff",StringType),StructField("enddateBuff",StringType)))
  }

  override def dataType: DataType = {
    LongType
  }

  override def deterministic: Boolean = {
    true
  }

  override def initialize(buffer: MutableAggregationBuffer): Unit = {
    buffer(0) = 0L
    buffer(1) = null
    buffer(2) = null
  }

  override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {

    val time0: Long = format.parse(input.getString(0)).getTime
    val time1: Long = format.parse(input.getString(1)).getTime
    buffer(0) = (time1-time0)/(3600 * 24 * 1000) + 1
    buffer(1) = input.getString(0)
    buffer(2) = input.getString(1)
  }

  override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
    if (buffer2.getString(0) < buffer1.getString(2)){
      val l: Long = (format.parse(buffer2.getString(1)).getTime - format.parse(buffer1.getString(2)).getTime) / (3600 * 24 * 1000)
      buffer1(0) = buffer1.getLong(0) + l
    }else if(buffer2.getString(0) >= buffer1.getString(2)){
      val l: Long = (format.parse(buffer2.getString(1)).getTime - format.parse(buffer2.getString(0)).getTime) / (3600 * 24 * 1000)
      buffer1(0) = buffer1.getLong(0) + l + 1
    }
    buffer1(1) = buffer2.getString(0)
    buffer1(2) = buffer2.getString(1)
  }

  override def evaluate(buffer: Row): Any = {
    buffer.getLong(0)
  }
}

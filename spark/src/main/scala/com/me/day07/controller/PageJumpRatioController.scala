package com.me.day07.controller

import com.atguigu.summer.framework.core.TController
import com.me.day07.service.PageJumpRatioService
import org.apache.spark.rdd.RDD

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
 * @author maow
 * @create 2020-06-09 21:17
 */
class PageJumpRatioController extends TController{

  private val service = new PageJumpRatioService

  override def execute(): Unit = {
    val resultMap: mutable.Map[String, (Int,Int,Double)] = service.analysis()
    resultMap.foreach(println)
//    result.collect().toList.foreach(println)
  }
}

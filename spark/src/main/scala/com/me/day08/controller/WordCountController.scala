package com.me.day08.controller

import com.atguigu.summer.framework.core.TController
import com.me.day08.service.WordCountService

/**
  * WordCount控制器
  */
class WordCountController extends TController{

    private val wordCountService = new WordCountService

    override def execute(): Unit = {
        val wordCountArray: Array[(String, Int)] = wordCountService.analysis()
        println(wordCountArray.mkString(","))
    }
}

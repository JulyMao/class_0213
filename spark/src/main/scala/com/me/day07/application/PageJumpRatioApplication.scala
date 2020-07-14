package com.me.day07.application

import com.atguigu.summer.framework.core.TApplication
import com.me.day07.controller.PageJumpRatioController

/**
 * @author maow
 * @create 2020-06-09 21:17
 */
object PageJumpRatioApplication extends App with TApplication{
    start("spark"){
      val controller = new PageJumpRatioController
      controller.execute()
    }
}

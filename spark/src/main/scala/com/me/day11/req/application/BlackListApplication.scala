package com.me.day11.req.application

import com.atguigu.summer.framework.core.TApplication
import com.me.day11.req.controller.BlackListController

object BlackListApplication extends App with TApplication{

    start("sparkStreaming") {
        val controller = new BlackListController
        controller.execute()
    }
}

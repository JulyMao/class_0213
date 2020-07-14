package com.me.day11.req.application

import com.atguigu.summer.framework.core.TApplication
import com.me.day11.req.controller.MockDataController

object MockDataApplication extends App with TApplication{

    start("sparkStreaming") {
        val controller = new MockDataController
        controller.execute()
    }
}

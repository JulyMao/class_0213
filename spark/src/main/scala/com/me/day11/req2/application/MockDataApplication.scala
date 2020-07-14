package com.me.day11.req2.application

import com.atguigu.summer.framework.core.TApplication
import com.me.day11.req2.controller.MockDataController

object MockDataApplication extends App with TApplication{

    start("sparkStreaming") {
        val controller = new MockDataController
        controller.execute()
    }
}

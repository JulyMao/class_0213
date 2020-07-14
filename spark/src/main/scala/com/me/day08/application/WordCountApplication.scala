package com.me.day08.application

import com.atguigu.summer.framework.core.TApplication
import com.me.day08.controller.WordCountController

object WordCountApplication extends App with TApplication{

    start( "spark" ) {

        val controller = new WordCountController
        controller.execute()

    }

}

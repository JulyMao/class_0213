package com.me.day08.application

import com.atguigu.summer.framework.core.TApplication
import com.me.day08.controller.HotCategoryAnalysisTop10Controller

object HotCategoryAnalysisTop10Application extends App with TApplication{

    // TODO 热门品类前10应用程序
    start("spark") {
        val controller = new HotCategoryAnalysisTop10Controller
        controller.execute()
    }
}

package com.me.day07.controller

import com.atguigu.summer.framework.core.TController
import com.me.day07.service.HotCategoryAnalysisTop10Service

class HotCategoryAnalysisTop10Controller extends TController {

    private val hotCategoryAnalysisTop10Service = new HotCategoryAnalysisTop10Service

    override def execute(): Unit = {
        val result = hotCategoryAnalysisTop10Service.analysis()

        result.foreach(println)
    }
}

package com.me.day08.controller

import com.atguigu.summer.framework.core.TController
import com.me.day08.bean
import com.me.day08.service.{HotCategoryAnalysisTop10Service, HotCategorySessionAnalysisTop10Service}

class HotCategorySessionAnalysisTop10Controller extends TController {

    private val hotCategoryAnalysisTop10Service = new HotCategoryAnalysisTop10Service
    private val hotCategorySessionAnalysisTop10Service = new HotCategorySessionAnalysisTop10Service

    override def execute(): Unit = {
        val categories: List[bean.HotCategory] = hotCategoryAnalysisTop10Service.analysis()
        val result = hotCategorySessionAnalysisTop10Service.analysis(categories)
        result.foreach(println)
    }
}

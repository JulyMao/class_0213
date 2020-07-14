package com.me.day08.controller

import com.atguigu.summer.framework.core.TController
import com.me.day08.service.PageflowService

class PageflowController extends TController{

    private val pageflowService = new PageflowService

    override def execute(): Unit = {
        val result = pageflowService.analysis()
    }
}

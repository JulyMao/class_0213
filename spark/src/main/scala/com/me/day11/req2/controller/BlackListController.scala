package com.me.day11.req2.controller

import com.atguigu.summer.framework.core.TController
import com.me.day11.req2.service.BlackListService

class BlackListController extends TController{

    private val blackListService = new BlackListService

    override def execute(): Unit = {
        val result = blackListService.analysis()
    }
}

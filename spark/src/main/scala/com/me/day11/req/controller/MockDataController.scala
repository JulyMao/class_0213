package com.me.day11.req.controller

import com.atguigu.summer.framework.core.TController
import com.me.day11.req.service.MockDataService

class MockDataController extends TController{

    private val mockDataService = new MockDataService

    override def execute(): Unit = {
        val result = mockDataService.analysis()
    }
}

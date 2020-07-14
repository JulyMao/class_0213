package com.me.day11.req2.controller

import com.atguigu.summer.framework.core.TController
import com.me.day11.req2.service.MockDataService

class MockDataController extends TController{

    private val mockDataService = new MockDataService

    override def execute(): Unit = {
        val result = mockDataService.analysis()
    }
}

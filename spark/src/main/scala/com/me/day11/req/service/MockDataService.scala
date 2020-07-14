package com.me.day11.req.service

import com.atguigu.summer.framework.core.TService
import com.me.day11.req.dao.MockDataDao

class MockDataService extends TService{

    private val mockDataDao = new MockDataDao

    /**
      * 数据分析
      *
      * @return
      */
    override def analysis() = {

        val datas  = mockDataDao.genMockData()

        // TODO 生成模拟数据
        //import mockDataDao._

        // TODO 向Kafka中发送数据
        mockDataDao.writeToKakfa(datas)


    }
}

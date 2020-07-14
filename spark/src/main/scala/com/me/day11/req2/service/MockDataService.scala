package com.me.day11.req2.service

import com.atguigu.summer.framework.core.TService
import com.me.day11.req2.dao.MockDataDao

class MockDataService extends TService{

    private val mockDataDao = new MockDataDao

    /**
      * 数据分析
      *
      * @return
      */
    override def analysis() = {
        // TODO 生成模拟数据
        //import mockDataDao._
        val datas  = mockDataDao.genMockData()
        //val a = Seq("a")

        // TODO 向Kafka中发送数据
        mockDataDao.writeToKakfa(datas)


    }
}

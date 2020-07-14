package com.me.day11.req.service

import com.atguigu.summer.framework.core.TService
import com.me.day11.req.dao.BlackListDao
import org.apache.spark.streaming.dstream.DStream

class BlackListService extends TService{

    private val blackListDao = new BlackListDao

    /**
      * 数据分析
      *
      * @return
      */
    override def analysis() = {

        // 读取Kafka的数据
        val ds: DStream[String] = blackListDao.readKafka()

        ds.print()
    }
}

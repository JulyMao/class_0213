package com.me.day08.dao

import java.text.SimpleDateFormat

import com.atguigu.summer.framework.core.TDao
import com.me.day08.bean.{UserVisitAction, UserVisitAction1}
import org.apache.spark.rdd.RDD

class PageflowDao extends TDao{
    val format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    def getUserVisitAction1( path:String ) = {
        val rdd: RDD[String] = readFile(path)
        rdd.map(
            line => {
                val datas = line.split("_")
//                val action_time = format.parse(datas(4)).getTime
                UserVisitAction(
                    datas(0),
                    datas(1).toLong,
                    datas(2),
                    datas(3).toLong,
                    datas(4),
                    datas(5),
                    datas(6).toLong,
                    datas(7).toLong,
                    datas(8),
                    datas(9),
                    datas(10),
                    datas(11),
                    datas(12).toLong
                )
            }
        )
    }

    def getUserVisitAction( path:String ) = {
        val rdd: RDD[String] = readFile(path)
        rdd.map(
            line => {
                val datas = line.split("_")
                UserVisitAction(
                    datas(0),
                    datas(1).toLong,
                    datas(2),
                    datas(3).toLong,
                    datas(4),
                    datas(5),
                    datas(6).toLong,
                    datas(7).toLong,
                    datas(8),
                    datas(9),
                    datas(10),
                    datas(11),
                    datas(12).toLong
                )
            }
        )
    }
}

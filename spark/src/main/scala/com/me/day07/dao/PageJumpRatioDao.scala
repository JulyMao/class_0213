package com.me.day07.dao

import com.atguigu.summer.framework.core.TDao
import com.me.day07.bean.UserJumpPage
import org.apache.spark.rdd.RDD

/**
 * @author maow
 * @create 2020-06-09 21:17
 */
class PageJumpRatioDao extends TDao{

  def getUserJumpPage( path:String ) = {
    val rdd: RDD[String] = readFile(path)
    rdd.map(
      line => {
        val datas = line.split("_")
        UserJumpPage(
          datas(2),
          datas(3).toLong
        )
      }
    )
  }
}

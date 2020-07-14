package com.me.day07.service

import com.atguigu.summer.framework.core.TService
import com.atguigu.summer.framework.util.EnvUtil
import com.me.day07.bean
import com.me.day07.dao.PageJumpRatioDao
import org.apache.spark.broadcast.Broadcast
import org.apache.spark.rdd.RDD

import scala.collection.mutable
import scala.collection.mutable.ListBuffer


/**
 * @author maow
 * @create 2020-06-09 21:18
 */
class PageJumpRatioService extends TService{

  private val dao = new PageJumpRatioDao
  var ratiosMap: mutable.Map[String, (Int,Int,Double)] = mutable.Map[String,(Int,Int,Double)]()
//  private val ratiosMapBroadcast: Broadcast[mutable.Map[String, Long]] = EnvUtil.getEnv().broadcast(ratiosMap)

  override def analysis(): mutable.Map[String, (Int,Int,Double)]= {
    val fileValue: RDD[bean.UserJumpPage] = dao.getUserJumpPage("input/user_visit_action.txt")

    //
    val groupValue: RDD[(String, Iterable[bean.UserJumpPage])] = fileValue.groupBy(_.session_id)

    val mapValue: RDD[(String,ListBuffer[Long] )] = groupValue.map(t => {
      var pages = mutable.ListBuffer[Long]()
      t._2.foreach(
        userJumpPage => {
          pages += userJumpPage.page_id
        }

      )
      (t._1, pages)
    })
    val list: List[ListBuffer[Long]] = mapValue.map((_._2)).collect().toList

    list.foreach(
      listBuffer => {
        var pageToPage = ""
        for (i <- 0 until listBuffer.size) {
          if (listBuffer.size == 1) {
          } else {
            if (i != listBuffer.size - 1) {
              pageToPage = listBuffer(i) + "-" + listBuffer(i + 1)
              ratiosMap(pageToPage) = ratiosMap.getOrElse(pageToPage, (0,0,0))
            }
          }
        }
      }
    )
    ratiosMap.foreach(
      map=>{
        val strings: Array[String] = map._1.split("-")
        var ANumber : Double = 0
        var BNumber : Double = 0
        list.foreach(
          listBuffer => {
            if (listBuffer.toList.contains(strings(0).toLong)){
              ANumber += 1
              val index: Int = listBuffer.indexOf(strings(0).toLong)
              if ((index != listBuffer.size - 1) && (strings(1).toLong == listBuffer(index + 1))) {
                BNumber += 1
              }
            }
          }
        )

        if (ANumber != 0.0){
          val ratio : Double = BNumber/ANumber
          ratiosMap(map._1) = (ANumber.toInt,BNumber.toInt,ratio)
        }

      }
    )


    ratiosMap

  }

}

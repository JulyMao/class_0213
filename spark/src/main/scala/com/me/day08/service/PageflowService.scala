package com.me.day08.service

import java.text.SimpleDateFormat

import com.atguigu.summer.framework.core.TService
import com.me.day08.bean
import com.me.day08.dao.PageflowDao
import org.apache.spark.rdd.RDD

class PageflowService extends TService {

    private val pageflowDao = new PageflowDao
    val format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")


    /**
      * 数据分析
      *
      * @return
      */

    override def analysis() = {

        // TODO 对指定的页面流程进行页面单跳转换率的统计

        // TODO  获取原始用户行为日志数据
        val actionRDD: RDD[bean.UserVisitAction] =
            pageflowDao.getUserVisitAction1("input/user_visit_action.txt")

        // (当前页面，时间戳)
        //
        val value: RDD[List[bean.UserVisitAction]] = actionRDD.groupBy(_.session_id).mapValues(_.toList.sortWith(_.action_time < _.action_time)).map(_._2)

        val value1: RDD[List[(Long, (String,String))]] = value.map(
            list => {
            val list1: List[(Long, String)] = list.map(bean => (bean.page_id, bean.action_time))

            val list2: List[((Long, String), (Long, String))] = list1.zip(list1.tail)

            val tuples: List[(Long, (String,String))] = list2.map {
                case ((t1, t2), (t3, t4)) => {
                    (t1, (t4, t2))
                }
            }
            tuples
        })
       val value2: Array[(Long, Iterable[(String, String)])] = value1.flatMap(list=>list).groupByKey().collect()

        val tuples: List[(Long, Double)] = value2.toList.map {
            case (page, list) => {
                val longs: List[Double] = list.toList.map(t => {
                    val sum: Double = format.parse(t._1).getTime - format.parse(t._2).getTime
                    sum
                })
                val sum = longs.sum
                val size: Double = list.toList.size
                val time: Double = (sum / size) / 1000
                (page, time)
            }
        }
        tuples.foreach(println)

    }

    def analysis2() = {

        // TODO 对指定的页面流程进行页面单跳转换率的统计
        // 1，2，3，4，5，6，7
        // 1-2，2-3，3-4，4-5，5-6，6-7/
        val flowIds = List(1,2,3,4,5,6,7)
        val okFlowIds = flowIds.zip(flowIds.tail).map( t => (t._1 + "-" + t._2) )

        // TODO  获取原始用户行为日志数据
        val actionRDD: RDD[bean.UserVisitAction] =
            pageflowDao.getUserVisitAction("input/user_visit_action.txt")
        actionRDD.cache()

        // TODO 计算分母
        // 将数据进行过滤后再进行统计
        val filterRDD = actionRDD.filter(
            action => {
                flowIds.init.contains(action.page_id.toInt)
            }
        )
        val pageToOneRDD: RDD[(Long, Int)] = filterRDD.map(
            action => {
                (action.page_id, 1)
            }
        )
        val pageToSumRDD: RDD[(Long, Int)] = pageToOneRDD.reduceByKey(_+_)
        val pageCountArray: Array[(Long, Int)] = pageToSumRDD.collect()

        // TODO 计算分子

        // TODO 将数据根据用户Session进行分组
        val sessionRDD: RDD[(String, Iterable[bean.UserVisitAction])] =
            actionRDD.groupBy(_.session_id)

        val pageFlowRDD: RDD[(String, List[(String, Int)])] = sessionRDD.mapValues(
            iter => {
                // TODO 将分组后的数据根据时间进行排序
                val actions: List[bean.UserVisitAction] = iter.toList.sortWith(
                    (left, right) => {
                        left.action_time < right.action_time
                    }
                )
                // TODO 将排序后的数据进行结构的转换
                //  action => pageid
                val pageids: List[Long] = actions.map(_.page_id)

                // TODO 将转换后的结果进行格式的转换
                // 1，2，3，4
                // 2，3，4
                // （1-2），（2-3），（3-4）
                val zipids: List[(Long, Long)] = pageids.zip(pageids.tail)
                // （（1-2），1），（（2-3），1），（（3，4），1）
                zipids.map {
                    case (pageid1, pageid2) => {
                        (pageid1 + "-" + pageid2, 1)
                    }
                }.filter{
                    case ( ids, one ) => {
                        okFlowIds.contains(ids)
                    }
                }
            }
        )

        // TODO 将分组后的数据进行结构的转换
        val pageidSumRDD: RDD[List[(String, Int)]] = pageFlowRDD.map(_._2)
        // (1-2,1)
        val pageflowRDD1: RDD[(String, Int)] = pageidSumRDD.flatMap(list=>list)
        // (1-2,sum)
        val pageflowToSumRDD = pageflowRDD1.reduceByKey(_+_)

        // TODO 计算页面单跳转换率
        // 1-2/1
        pageflowToSumRDD.foreach{
            case ( pageflow, sum ) => {
                val pageid = pageflow.split("-")(0)
                val value = pageCountArray.toMap.getOrElse(pageid.toLong,1)
                println("页面跳转【"+pageflow+"】的转换率为: " + (sum.toDouble / value))
            }
        }
    }

    /**
      * 数据分析
      *
      * @return
      */
    def analysis1() = {

        // TODO  获取原始用户行为日志数据
        val actionRDD: RDD[bean.UserVisitAction] =
            pageflowDao.getUserVisitAction("input/user_visit_action.txt")
        actionRDD.cache()

        // TODO 计算分母
        val pageToOneRDD: RDD[(Long, Int)] = actionRDD.map(
            action => {
                (action.page_id, 1)
            }
        )
        val pageToSumRDD: RDD[(Long, Int)] = pageToOneRDD.reduceByKey(_+_)
        val pageCountArray: Array[(Long, Int)] = pageToSumRDD.collect()

        // TODO 计算分子

        // TODO 将数据根据用户Session进行分组
        val sessionRDD: RDD[(String, Iterable[bean.UserVisitAction])] =
            actionRDD.groupBy(_.session_id)

        val pageFlowRDD: RDD[(String, List[(String, Int)])] = sessionRDD.mapValues(
            iter => {
                // TODO 将分组后的数据根据时间进行排序
                val actions: List[bean.UserVisitAction] = iter.toList.sortWith(
                    (left, right) => {
                        left.action_time < right.action_time
                    }
                )
                // TODO 将排序后的数据进行结构的转换
                //  action => pageid
                val pageids: List[Long] = actions.map(_.page_id)

                // TODO 将转换后的结果进行格式的转换
                // 1，2，3，4
                // 2，3，4
                // （1-2），（2-3），（3-4）
                val zipids: List[(Long, Long)] = pageids.zip(pageids.tail)
                // （（1-2），1），（（2-3），1），（（3，4），1）
                zipids.map {
                    case (pageid1, pageid2) => {
                        (pageid1 + "-" + pageid2, 1)
                    }
                }
            }
        )

        // TODO 将分组后的数据进行结构的转换
        val pageidSumRDD: RDD[List[(String, Int)]] = pageFlowRDD.map(_._2)
        // (1-2,1)
        val pageflowRDD1: RDD[(String, Int)] = pageidSumRDD.flatMap(list=>list)
        // (1-2,sum)
        val pageflowToSumRDD = pageflowRDD1.reduceByKey(_+_)

        // TODO 计算页面单跳转换率
        // 1-2/1
        pageflowToSumRDD.foreach{
            case ( pageflow, sum ) => {
                val pageid = pageflow.split("-")(0)
                val value = pageCountArray.toMap.getOrElse(pageid.toLong,1)
                println("页面跳转【"+pageflow+"】的转换率为: " + (sum.toDouble / value))
            }
        }
    }
}

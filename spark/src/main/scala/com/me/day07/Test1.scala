package com.me.day07

import java.text.SimpleDateFormat

import scala.collection.mutable.ListBuffer

/**
 * @author maow
 * @create 2020-06-09 23:07
 */
object Test1 {
  def main(args: Array[String]): Unit = {
    // 可变集合
    val buffer = new ListBuffer[Int]()
    val buffer1: ListBuffer[Int] = ListBuffer(6, 20, 6, 18, 16, 21, 28)

    buffer1.contains(20)
    // 增加数据
//    buffer.append(1,2,3,4)
    // 修改数据
//    buffer.update(1,3)
    // 删除数据
//    buffer.remove(2)
//    buffer.remove(2,2)
    // 获取数据
//    println(buffer(1))
    // 遍历集合
//    buffer.foreach(println)

//    println(buffer.size)

    val s = "2019-07-17 00:00:03"
    val format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val date = format.parse(s).getTime
    println(date)
    val a : Double = 7
    val b : Double = 8
    val d: Double = a + 1
    val c : Double = a/b
//    println(c.toLong)
  }

}

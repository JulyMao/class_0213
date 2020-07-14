package com.me

import scala.collection.mutable

/**
 * @author maow
 * @create 2020-05-29 21:01
 */
object Test8 {
  def main(args: Array[String]): Unit = {
    val que = new mutable.Queue[String]()
    val queue: mutable.Queue[Int] = mutable.Queue(1,2,3,4)
    println(queue.dequeue())
    println(queue.dequeue())
    println(queue.dequeue())
    queue.tail
    // 添加元素
    que.enqueue("a", "b", "c")
    val que1: mutable.Queue[String] = que += "d"
    println(que eq que1)
    // 获取元素
    println(que.dequeue())
    println(que.dequeue())
    println(que.dequeue())
  }

}

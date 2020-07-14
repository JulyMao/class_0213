package com.me

/**
 * @author maow
 * @create 2020-05-29 9:53
 */
object Test1 {
  def main(args: Array[String]): Unit = {
    val list = List(
      List(1, 2), List(3, 4)
    )
    val list1: List[Int] = list.flatMap(list=>list)
    val flatten: List[Int] = list.flatten
    println(list1)
    println(flatten)
  }
}

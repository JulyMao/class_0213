package com.me

/**
 * @author maow
 * @create 2020-05-29 21:56
 */
object Test11 {
  def main(args: Array[String]): Unit = {
    val list = List(1,2,3,4)
    val list2 = List(5,6,7,8)
    println(5 :: list)
    println(list ::: list2)
    println(list ++ list2)
    println(9 :: list :: list2 :: Nil)
    println(10 :: Nil)
  }
}

package com.me.day01

/**
 * @author maow
 * @create 2020-06-01 20:04
 */
object Test1 {
  def main(args: Array[String]): Unit = {
    val sorted: Array[Int] = Array(2,4,7,1).sorted
    println(sorted.mkString(","))
    println(Map("a" -> 1, "b" -> 2).map(m => {
      m._1 -> m._2 * 2
    }))

  }
}

case class man(name : String = "maow"){
//  name = "maowei"
}

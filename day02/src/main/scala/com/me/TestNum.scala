package com.me

/**
 * @author maow
 * @create 2020-05-19 19:34
 */
object TestNum {
  def main(args: Array[String]): Unit = {
    val b : Byte = 10
    val s : Short = b
    val i : Int = s
    val lon : Long = i
//    println(lon)

    val c : Char = 'A' + 1//常量运算在编译时就已经完成
    println(c)

  }
}

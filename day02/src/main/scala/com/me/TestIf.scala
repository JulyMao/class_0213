package com.me

/**
 * @author maow
 * @create 2020-05-19 20:24
 */
object TestIf {
  def main(args: Array[String]): Unit = {
    val age = 30
    val result = if ( age < 18 ) {
      "童年"
    } else if ( age <= 30 ) {
      "青年"
      100
    } else if ( age <= 50 ) {
      "中年"
    } else {
      "老年"
    }
    println(result)
    val  str = if (2>3) "ha" else "hei"
    println(str)

  }
}

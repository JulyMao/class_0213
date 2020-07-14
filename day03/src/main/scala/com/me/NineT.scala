package com.me

/**
 * @author maow
 * @create 2020-05-20 19:18
 */
object NineT {
  def main(args: Array[String]): Unit = {
    for (i <- 1 to 18 by 2){
      println(" " * ((17 - i) / 2) +"*" * i)
    }
  }


}

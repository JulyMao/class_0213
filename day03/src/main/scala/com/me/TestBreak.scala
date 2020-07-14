package com.me

import scala.util.control.Breaks

/**
 * @author maow
 * @create 2020-05-20 19:31
 */
object TestBreak {
  def main(args: Array[String]): Unit = {
    Breaks.breakable {
      for (i <- 1 to 5) {
        if (i == 4) {
          Breaks.break()
        }
        println(i)
      }
    }

  }
}

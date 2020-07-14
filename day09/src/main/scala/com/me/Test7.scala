package com.me

/**
 * @author maow
 * @create 2020-05-29 20:59
 */
object Test7 {
  def main(args: Array[String]): Unit = {

    //        val ints = List(1,2,3)
    //        ints.foreach(println)

    //val result1 = (0 to 100).map{x => Thread.currentThread.getName}

    val result2 = (0 to 100).par.map{x => Thread.currentThread.getName}

    //println(result1)
    println(result2)

  }
}

package com.me

/**
 * @author maow
 * @create 2020-05-19 20:29
 */
object TestFor {
  def main(args: Array[String]): Unit = {
    for ( i <- Range(1,5) ) { //[1,2,3,4,5)
      println("i = " + i )
    }
    println("============================")
    for ( i <- 1 to 5 ) { // [1,2,3,4,5]
      println("i = " + i )
    }
    println("============================")
    for ( i <- 1 until 5 ) { // [1,2,3,4,5)
      println("i = " + i )
    }
    println("============================")
    for ( i <- Range(1,5,2) ) { //[1,3]
      println("i = " + i )
    }
    println("============================")
    for ( i <- 1 to 5 by 2 ) { // [1,3,5]
      println("i = " + i )
    }
    println("============================")
    for ( i <- 1 until 5 by 2 ) { // [1,3]
      println("i = " + i )
    }
    println("============================")
    for ( i <- Range(1,5) if i != 3  ) {
      println("i = " + i )
    }
    println("============================")
    for ( i <- Range(1,5);j <- Range(1,4) ) {
      println("i = " + i + ",j = " + j )
    }
    println("============================")
    for ( i <- Range(1,5) ) {
      for ( j <- Range(1,4) ) {
        println("i = " + i + ",j = " + j )
      }
    }
    println("============================")
    for ( i <- Range(1,5); j = i - 1 ) {
      println("j = " + j )
    }
    println("============================")
    val result = for ( i <- Range(1,5) ) yield {
      i * 2
    }
    println(result)

  }
}

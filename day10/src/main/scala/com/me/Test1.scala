package com.me

/**
 * @author maow
 * @create 2020-05-30 15:02
 */
object Test1 {
  def main(args: Array[String]): Unit = {
    try{
      val i = 10
      val j = 0
      println(i / j)
    } catch {
      case e : IndexOutOfBoundsException=> {
        println("xxx")
      }
      case e : Exception =>{
        println("yyy")
      }
    }
  }
}

class User {
  var name : String = _
}

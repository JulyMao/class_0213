package com.me

/**
 * @author maow
 * @create 2020-05-20 20:31
 */
object SimpleIsFirst {
  def main(args: Array[String]): Unit = {

    fun2
    def fun1(): String = {

      return "maow"
    }
    def fun11(): String = {

      "maow"
    }
    def fun111 = "maow"

    def fun2 : Unit = {

      return "maow"
    }

    def fun22 {
      return "maow"
    }

//    () => {
//      println("maoooow")
//    }
      val aa = () => "maow"
      aa()
      println(aa())
    def fun21( i:Int ,j:Int): Int = {
      var k = j * i
      return k
    }
    def fun221( f : (Int,Int) => Int ): Int = {
      f(10,2)
    }
    println(fun221(fun21(_,_)))

  }


}

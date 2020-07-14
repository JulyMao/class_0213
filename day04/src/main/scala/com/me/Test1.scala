package com.me

/**
 * @author maow
 * @create 2020-05-22 13:44
 */
object Test1 {
  def main(args: Array[String]): Unit = {

    def fun1(j:Int) = {
      (i:Int) => i * j
//      sum(_)
    }

    println(fun1(5)(10))

    def fun2(op: => Unit) = {
      op
    }
    def fun21 ={
      println("xxx")
    }
    def fun3(j:()=>Unit) ={
      println("yyy")
    }

    fun3(fun21 _)
    fun2(fun21)
    fun2{
      println("xx")
    }


  }

}

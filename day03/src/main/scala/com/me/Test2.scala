package com.me

/**
 * @author maow
 * @create 2020-05-21 21:41
 */
object Test2 {
  def main(args: Array[String]): Unit = {
    def fun2( i:Int ): Int = {
      val a = i * 2
      a * i
    }
    def fun22( f :(Int) => Int ) = {
      f(_)
    }
    println(fun22(fun2(_))(10))
    val a = () => {
      println("zhangsan")
    }
    def fun3 : Int = {
      100
    }
    def fun4(f:Int=>Int) = {
      f(10)
    }

    println(fun4((i) => {
      println("s")
      i + 1
    }))
    println(fun4(_ + 1))

    println(a())
    println(fun3)
  }



}

package com.me

/**
 * @author maow
 * @create 2020-05-20 16:11
 */
object Test1 {
  def main(args: Array[String]): Unit = {
    def fun1(): String = {
      "zhangsan"
    }


    println(Test1 test 1)
    def fun11():String ={
      "maow"
    }
    println(fun11)
    val f3: ()=>String = fun11
    println(f3)
    val a = fun1
    val b = fun1 _
    println(a)
    println(b)
  }
  def test(i:Int) = {
    i
  }
}

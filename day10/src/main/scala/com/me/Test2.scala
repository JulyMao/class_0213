package com.me
/**
 * @author maow
 * @create 2020-05-31 18:15
 */
object Test2 {
  def main(args: Array[String]): Unit = {


    // TODO Scala - 模式匹配 - 应用
    val Array(first, second, _*) = Array(1, 7, 2, 9)

    val Person(name, age) = Person("zhangsan", 16)
    println(name)

    val map = Map("A" -> 1, "B" -> 0, "C" -> 3)
    for ( kv <- map ) {
      //println(kv._1 + "," + kv._2)
    }

    // 模式匹配还可以过滤数据
    for ( ( k, 0 ) <- map ) {
      println(k)
    }

    val intToUnit: Int => Unit = Test2.fun1(_)


  }
  def fun1(i:Int): Unit ={
    println("xxx" + i)
  }

  def fun2( i:Int, j:Int ): Int = {
    i * j
  }
  def fun22( f : (Int,Int) => Int ): Int = {
    f(10,20)
  }
  println(fun22(fun2))
  println(fun22(fun2(_,_)))
  println(fun22(fun2 _))
}

case class Person(name: String, age: Int){
}

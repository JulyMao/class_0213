package com.me

/**
 * @author maow
 * @create 2020-05-19 20:14
 */
object TestEqual {
  def main(args: Array[String]): Unit = {
    val a = new String("abc")
    val b = new String("abc")
  //scala中==和equal在编译器中都是equal，都是比较值；而eq 在编译器中则是==，比较的是地址值
    println(a == b)
    println(a.equals(b))
    println(a eq b)

  }
}

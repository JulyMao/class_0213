package com.me

/**
 * @author maow
 * @create 2020-05-26 16:25
 */
object Test2 {
  def main(args: Array[String]): Unit = {
    val strings: Array[String] = Array("1","2","3")
    val ints: List[Int] = List(1,2,3,4,5)
    val ints1: List[Int] = ints.+:(6)

    val array = Array[Int](1,2,3,4)
    val array0 = array :+ 5
    val array1 = 5 +: array
    val array2 = array.+:(5)
    println(array0.mkString(","))
    println(array1.mkString(","))
    println(array2.mkString(","))
  }

}

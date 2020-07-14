package com.me

/**
 * @author maow
 * @create 2020-05-29 11:02
 */
object Test3 {
  def main(args: Array[String]): Unit = {
    val list = List(1,2,3,4)
    val iterator: Iterator[List[Int]] = list.sliding(2)
//    while (iterator.hasNext){
//      println(iterator.next())
//    }
    val i: Int = list.reduceRight(_-_)
    println(i)
  }

}

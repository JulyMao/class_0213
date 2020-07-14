package com.me

import scala.collection.mutable

/**
 * @author maow
 * @create 2020-05-29 15:13
 */
object Test4 {
  def main(args: Array[String]): Unit = {
    val map1: mutable.Map[String, Int] = mutable.Map("a"->2,"b"->4,"c"->1)
    val map2: mutable.Map[String, Int] = mutable.Map("a"->3,"c"->1,"d"->2)

    val stringToInt: mutable.Map[String, Int] = map1.foldRight(map2)((kv,map2) => {
//      val k = kv._1
//      val v = kv._2
//      val i: Int = map2.getOrElse(k, 0) + v
//      map2(k) = i
      map2(kv._1) = map2.getOrElse(kv._1,0) + kv._2
      map2
      //      map2
    })
    println(stringToInt)

  }
}

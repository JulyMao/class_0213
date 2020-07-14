package com.me

import scala.collection.mutable


object Test8 {

    def main(args: Array[String]): Unit = {

        val map: mutable.Map[String, Int] = mutable.Map("a"->1,"b"->2,"c"->3)

        val maybeInt: Option[Int] = map.get("a")
        println(maybeInt)
        println(maybeInt.getOrElse(-1))

        val i: Int = map.getOrElse("a", -1)
        println(i)


    }
}

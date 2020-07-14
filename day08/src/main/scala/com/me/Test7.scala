package com.me

import scala.collection.mutable


object Test7 {

    def main(args: Array[String]): Unit = {

        val map: mutable.Map[String, Int] = mutable.Map("a"->1,"b"->2,"c"->3)

        map.put("d", 4)

        map("a") = 6

        map.remove("a")


        println(map)



    }
}

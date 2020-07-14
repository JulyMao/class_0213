package com.me

import scala.collection.mutable


object Test10 {

    def main(args: Array[String]): Unit = {

        val data = ( "a", 1 )


        val map: mutable.Map[String, Int] = mutable.Map( ("a", 1), ("b", 2), ("c", 3) )

        for ( kv <- map ) {

            println(kv._1 + "=" +kv._2)
        }

    }
}

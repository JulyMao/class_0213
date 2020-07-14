package com.me

import scala.collection.mutable


object Test5 {

    def main(args: Array[String]): Unit = {

        val set = mutable.Set(1,2,3,4)

        val newSet: mutable.Set[Int] = set + 5
        val oldSet: mutable.Set[Int] = set += 5

        println( set eq newSet )

        set - 3
        set -= 3

        println(set)

    }
}

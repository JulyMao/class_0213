package com.me

import scala.collection.mutable


object Test9 {

    def main(args: Array[String]): Unit = {

        val data: (Int, String, Int, String) = (1, "zhangsan", 30, "xxxxx")
        println(data._1)
        println(data._2)
        println(data._3)
        println(data._4)
        val iterator: Iterator[Any] = data.productIterator
//        while ( iterator.hasNext ) {
////            println(iterator.next())
//        }
        println(data.productElement(0))


    }
}

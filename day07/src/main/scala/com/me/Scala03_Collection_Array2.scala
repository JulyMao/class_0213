package com.me

import scala.collection.mutable.ArrayBuffer

object Scala03_Collection_Array2 {

    def main(args: Array[String]): Unit = {

        val array = new ArrayBuffer[String]()

        array.append("a")
        array.append("b")

        println(array)
        println(array.mkString(", "))

    }
}

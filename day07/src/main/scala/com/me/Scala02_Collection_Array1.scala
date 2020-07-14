package com.me

object Scala02_Collection_Array1 {

    def main(args: Array[String]): Unit = {


        val array = Array(1,2,3,4)

        val newArray: Array[Int] = array :+ 5

        val newArray2: Array[Any] = array :+ "5"

        println(array.mkString(", "))

        val newArray1: Array[Int] = 5 +: array

        println(newArray1.mkString(", "))
        println(newArray2.mkString(", "))
    }
}

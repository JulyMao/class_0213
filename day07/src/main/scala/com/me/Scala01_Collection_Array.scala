package com.me

object Scala01_Collection_Array {

    def main(args: Array[String]): Unit = {
        val array = new Array[String](5)

        array(0) = "zhangsan"
        array(1) = "zhangsan1"
        array(2) = "zhangsan2"
        array(3) = "zhangsan3"
        array(4) = "zhangsan4"

        println(array.mkString(","))


    }
}

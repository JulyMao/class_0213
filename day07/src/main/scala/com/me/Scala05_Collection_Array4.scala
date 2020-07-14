package com.me

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Scala05_Collection_Array4 {

    def main(args: Array[String]): Unit = {

        val array = Array(1,2,3)


        val buffer: mutable.Buffer[Int] = array.toBuffer

        val array1 = ArrayBuffer(1,2,3)

        val array2: Array[Int] = array1.toArray
    }
}

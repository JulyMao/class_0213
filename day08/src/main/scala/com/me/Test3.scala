package com.me

import scala.collection.mutable.ListBuffer

object Test3 {

    def main(args: Array[String]): Unit = {

        val buffer: ListBuffer[Int] = ListBuffer(1,2,3,4)

        buffer.append(5,6,7)
        buffer.insert(1,8)

        buffer.remove(1,3)

        println(buffer)
        buffer.foreach(println)
        buffer.mkString(",")

    }
}

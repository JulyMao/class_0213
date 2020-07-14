package com.me

import scala.io.{BufferedSource, Source}

object Test14 {

    def main(args: Array[String]): Unit = {
        val dataList: List[String] = Source.fromFile("input/word.txt").getLines().toList

        val wordList: List[String] = dataList.flatMap(
            data => {
                data.split(" ")
            }
        )

        val wordGroupMap: Map[String, List[String]] = wordList.groupBy(
            word => word
        )
        val wordToCountMap: Map[String, Int] = wordGroupMap.map(
            kv => {
                (kv._1, kv._2.length)
            }
        )


        val sortList: List[(String, Int)] = wordToCountMap.toList.sortBy(
            kv => kv._2
        )(Ordering.Int.reverse)

        val result: List[(String, Int)] = sortList.take(3)

        println(result)
    }
}

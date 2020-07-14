package com.me

/**
 * @author maow
 * @create 2020-05-28 15:25
 *
 * 1.利用flatMap和Map变成  List((hello,4), (hello,3), (spark,3), (hello,2), (spark,2), (scala,2), (hello,1), (spark,1), (scala,1), (hive,1))
 * 2.再通过groupBy变成  Map(spark -> List((spark,3), (spark,2), (spark,1)), scala -> List((scala,2), (scala,1)), hive -> List((hive,1)),
 *                          hello -> List((hello,4), (hello,3), (hello,2), (hello,1)))
 * 3.再利用map改成其数据结构 变成  Map(spark -> 6, scala -> 3, hive -> 1, hello -> 10)
 * 4.最后List化后排序取前三  List((hello,10), (spark,6), (scala,3))
 */
object WordCount {
  def main(args: Array[String]): Unit = {
    val list = List(
      ("hello", 4),
      ("hello spark", 3),
      ("hello spark scala", 2),
      ("hello spark scala hive", 1)
    )
    //("hello spark", 3) => [("hello",3),("spark",3)]
    val flatList = list.flatMap(
      t=>{
        t._1.split(" ").map(tt=>{
          (tt,t._2)
        })
      }
    )
    println(flatList)
     // [("hello", 4),("hello",3),("spark",3)...]
    val groupList = flatList.groupBy(t=>{
      t._1
    })
    println(groupList)
    //[("hello",List(("hello", 4),("hello",3)),("spark",List(("spark",3)))]

    val mapList = groupList.map(t=>{
      var num = 0
      for (i <- t._2){
        num += i._2
      }
      (t._1,num)
    })
    println(mapList)
    val resultList: List[(String, Int)] = mapList.toList.sortWith((left, right)=>{left._2>right._2}).take(3)

    println(resultList)
  }
}

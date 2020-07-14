package com.me

/**
 * @author maow
 * @create 2020-05-28 16:19
 *
 * 1.利用flatMap，Map和mkString将list转换为字符串  hello, hello, hello, hello, hello, hello, hello, spark, spark, spark,
 *                                                hello, hello, spark, spark, scala, scala, hello, spark, scala, hive
 * 2.再将字符串分割形成集合，通过groupBy和Map组成新的Map集合  Map(spark -> 6, scala -> 3, hive -> 1, hello -> 10)
 * 3.最后list化，排序去前三  List((hello,10), (spark,6), (scala,3))
 */
object WordCount2 {
  def main(args: Array[String]): Unit = {
    val list = List(
      ("hello", 4),
      ("hello  spark", 3),
      ("hello spark scala", 2),
      ("hello spark scala hive", 1)
    )
    val flatListString = list.flatMap(t=>{
      t._1.split(" ").map(tt=>{
        var str = ""
        for (i <- 1 to t._2){
          if (i == 1) {
            str = str.concat(tt)
          }else{
            str = str.concat(", " + tt)
          }
        }
        str
      })
    }).mkString(", ")
    println(flatListString)
    val groupList = flatListString.split(", ").groupBy(t=>t).map(t=>{(t._1,t._2.size)})
    println(groupList)

    val result = groupList.toList.sortWith((l,r)=>{l._2>r._2}).take(3)
    println(result)
  }

}

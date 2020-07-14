package com.me

/**
 * @author maow
 * @create 2020-05-29 19:52
 */
object Test5 {
  def main(args: Array[String]): Unit = {
    //不同省份商品点击排行
    val datalLsit: List[(String, String, String)] = List(
      ("zhangsan", "河北", "鞋"), ("lisi", "河北", "衣服"), ("wangwu", "河北", "鞋"), ("zhangsan", "河南", "鞋"), ("lisi", "河南", "衣服"),
      ("wangwu", "河南", "鞋"), ("zhangsan", "河南", "鞋"), ("lisi", "河北", "衣服"), ("wangwu", "河北", "鞋"), ("zhangsan", "河北", "鞋"),
      ("lisi", "河北", "衣服"), ("wangwu", "河北", "帽子"), ("zhangsan", "河南", "鞋"), ("lisi", "河南", "衣服"), ("wangwu", "河南", "帽子"),
      ("zhangsan", "河南", "鞋"), ("lisi", "河北", "衣服"), ("wangwu", "河北", "帽子"), ("lisi", "河北", "衣服"), ("wangwu", "河北", "电脑"),
      ("zhangsan", "河南", "鞋"), ("lisi", "河南", "衣服"), ("wangwu", "河南", "电脑"), ("zhangsan", "河南", "电脑"), ("lisi", "河北", "衣服"),
      ("wangwu", "河北", "帽子")
    )
    val toList = datalLsit.map(t=>{(t._2 + "-" + t._3)}).groupBy(t=>t).toList.map(t=>{(t._1,t._2.size)})
//    println(toList)
    val tuples: List[(String, (String, Int))] = toList.map(t => {
      val strings: Array[String] = t._1.split("-")
      (strings(0), (strings(1), t._2))
    })
//    println(tuples)
    val stringToTuples: Map[String, List[(String, (String, Int))]] = tuples.groupBy(t=>t._1)
//    println(stringToTuples)
    val result = stringToTuples.mapValues(list => {
      list.map(t => (t._2._1, t._2._2)).sortWith((l, r) => {
              l._2 > r._2
            })
    })

    println(result)
  }
}

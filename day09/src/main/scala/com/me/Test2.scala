package com.me

/**
 * @author maow
 * @create 2020-05-29 10:03
 */
object Test2 {
  def main(args: Array[String]): Unit = {
    val set1 = Set(1,2,3,4)
    val set2 = Set(5,6,7,8)

    // 增加数据
    val set3: Set[Int] = set1 + 5 + 6
    val set4: Set[Int] = set1.+(6,7,8)
    println( set1 eq set3 ) // false
    println( set1 eq set4 ) // false
    set4.foreach(println)
    // 删除数据
    val set5: Set[Int] = set1 - 2 - 3
    set5.foreach(println)

    val set6: Set[Int] = set1 ++ set2
    set6.foreach(println)
    println("********")
    val set7: Set[Int] = set2 ++ set1
//    set7.foreach(println)
    println(set6 eq set7)

  }

}

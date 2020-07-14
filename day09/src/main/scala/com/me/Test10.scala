package com.me

/**
 * @author maow
 * @create 2020-05-29 21:43
 */
object Test10 {
  def main(args: Array[String]): Unit = {
    // 创建数组的另外一种方式
    val arr1 = Array(1,2,3,4)
    val arr2 = Array(5,6,7,8)
    // 添加数组元素，创建新数组
    val arr3: Array[Int] = arr1 :+ 5
    println( arr1 == arr3 ) // false

//    val arr4: Array[Int] = arr1.++:(arr2)
    // 添加集合
    val arr5: Array[Int] = arr1 ++ arr2

//    arr4.foreach(println)
    println("****************")
    arr5.foreach(println)
    println("****************")
    // 多维数组
    var myMatrix = Array.ofDim[Int](3,3)
    myMatrix.foreach(list=>list.foreach(println))
    // 合并数组
    val arr6: Array[Int] = Array.concat(arr1, arr2)
    arr6.foreach(println)

    // 创建指定范围的数组
    val arr7: Array[Int] = Array.range(0,2)
    arr7.foreach(println)

    // 创建并填充指定数量的数组
    val arr8:Array[Int] = Array.fill[Int](5)(-1)
    arr8.foreach(println)
  }

}

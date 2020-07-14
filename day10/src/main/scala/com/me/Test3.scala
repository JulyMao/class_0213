package com.me

/**
 * @author maow
 * @create 2020-05-31 18:19
 */
object Test3 {
  def main(args: Array[String]): Unit = {


    val list : List[Any] = List(1,2,3,4,5,6,"test")

    //        list.map(
    //            data => {
    //                data + 1
    //            }
    //        )

    val ints: List[Int] = list.collect {
      case i: Int => i + 1
    }
    println(ints)
//    println(list.filter(_.isInstanceOf[Int]).map(_.asInstanceOf[Int] + 1))

  }
}

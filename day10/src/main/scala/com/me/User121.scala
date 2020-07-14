package com.me

/**
 * @author maow
 * @create 2020-05-31 17:32
 */
object User121 {
  def main(args: Array[String]): Unit = {
    class User1(val name: String, val age: Int)
    object User1{
      def apply(name: String, age: Int): User1 = new User1(name, age)
      def unapply(user: User1): Option[(String, Int)] = {
        if (user == null)
          None
        else
          Some(user.name, user.age)
      }
    }

    val user: User1 = User1("zhangsan", 11)
    val result = user match {
      case User1("zhangsan", 11) => "yes"
      case _ => "no"
    }
    println(result)
//    for (tuple <- Array((0, 1), (1, 0), (1, 1), (1, 0, 2))) {
//      val result = tuple match {
//        case (0, _) => "0 ..." //是第一个元素是0的元组
//        case (y, 0) => "" + y + "0" // 匹配后一个元素是0的对偶元组
//        case (a, b) => "" + a + " " + b
//        case _ => "something else" //默认
//      }
//      println(result)
//    }

  }
}

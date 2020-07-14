package com.me

/**
 * @author maow
 * @create 2020-05-23 11:21
 */
object Test2 {
  def main(args: Array[String]): Unit = {
    val user = new User
    val work = new Work
    print(user.name + "的工作是" + work)
  }
}

class Work{
  println("IT")
}

class User {
  val work:Work=null
  val name:String="maow"
}

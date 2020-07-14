package com.me

/**
 * @author maow
 * @create 2020-05-26 10:44
 */
object Test1 {
  def main(args: Array[String]): Unit = {
    val user = new User()
    println(user.age)
  }
}
abstract class Person{
  def test() : String
  var name : String
  val age : Int = 20
}

class User extends Person{
  override def test() = {
    "maow"
  }
  var name : String = "maow"
  override val age: Int = 30
}
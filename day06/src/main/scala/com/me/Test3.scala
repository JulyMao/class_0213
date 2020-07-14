package com.me

import scala.beans.BeanProperty

/**
 * @author maow
 * @create 2020-05-25 13:23
 */
object Test3 {
  def main(args: Array[String]): Unit = {
    val test = new Test3
    println(test.name)
    println(test.num)
    println(test.age)
//    val clazz: Class[User] = classOf[User]
    println(this)
  }

}
class Test3{
  @BeanProperty
  var name : String = _
  var num : Int = _
  private var age : Int = _
}

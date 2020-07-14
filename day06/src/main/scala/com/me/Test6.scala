package com.me

/**
 * @author maow
 * @create 2020-05-25 19:44
 */
object Test6 {
  def main(args: Array[String]): Unit = {
    val user = new User2()
//    user.test()
  }
}

class Person2 {
  protected def test(): Unit ={
    println("xxx")
  }
}

class User2 extends Person2 {
  override protected def test(): Unit ={

  }

}

class User() {
  var name: String = _
  // 类体 & 函数体
  println("user.....")

  // public User() {}
  // 普通方法
  def User() = {
    println("user....init...")
  }
}
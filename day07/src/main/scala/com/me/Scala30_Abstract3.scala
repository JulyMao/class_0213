package com.me

import scala.beans.BeanProperty

object Scala30_Abstract3 {
    def main(args: Array[String]): Unit = {

        new SubUser30()

    }
}
abstract class User30() {
//class User30 {
    val age : Int = 20
    println(age) //  age属性的get方法，成员方法，动态绑定技术
}
class SubUser30 extends User30 {
    override val age : Int = 30 // get方法
}


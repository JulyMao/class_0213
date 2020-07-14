package com.me

import scala.beans.BeanProperty

object Scala29_Abstract2 {
    def main(args: Array[String]): Unit = {

        println(new SubUser29())


        println(new SubUser29().test())


    }
}
abstract class User29 {
    // 抽象属性
    var name : String
    // 完整属性
    @BeanProperty
    val age : Int = 20

    def test(): Unit = {
        //age = 40 // set
        println(age)// get
    }
}
class SubUser29 extends User29 {
    // 将抽象属性补充完整
    var name : String = "zhangsan"
    @BeanProperty
    override val age : Int = 30
}


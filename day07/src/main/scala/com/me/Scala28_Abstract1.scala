package com.me

object Scala28_Abstract1 {
    def main(args: Array[String]): Unit = {


        println(new SubUser28())


    }
}
abstract class User28 {
    def test(): Unit = {

    }
}
class SubUser28 extends User28 {
    override def test(): Unit = {

    }
}

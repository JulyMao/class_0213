package com.me

object Scala27_Abstract {
    def main(args: Array[String]): Unit = {

        println(new SubUser227())


    }
}
abstract class User27 {
    def test(): Unit
}
abstract class SubUser27 extends User27 {

}
class SubUser227 extends User27 {
    override def test(): Unit = {

    }
}


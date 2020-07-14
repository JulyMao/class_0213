package com.me

object Scala35_Interface4 {
    def main(args: Array[String]): Unit = {


        new SubUser35()

    }
}
trait Parent35 {
    println("aaaaa")
}
trait Test35 extends Parent35 {
    println("bbbbb")
}
trait SubTest35 extends Parent35 {
    println("ccccc")
}
class User35 extends Test35 {
    println("ddddd")
}
class SubUser35 extends User35 with SubTest35{
    println("eeeee")
}


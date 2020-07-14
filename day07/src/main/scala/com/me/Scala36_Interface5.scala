package com.me

object Scala36_Interface5 {
    def main(args: Array[String]): Unit = {


        new User36();
    }
}
trait Test36 {
    println("aaaaa")
}
trait Test366 {
    println("bbbbb")
}
trait Test3666 {
    println("ccccc")
}
class User36 extends Test36 with Test366 with Test3666{
    println("ddddd")
}


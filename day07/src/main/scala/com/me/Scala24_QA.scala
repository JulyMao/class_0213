package com.me



object Scala24_QA {
    def main(args: Array[String]): Unit = {

        //
        val dept0 = Dept02() // object... apply
        dept0() // class...apply

    }
}

class Dept02 {
    def apply() = {
        println("apply... class...")
    }
}
object Dept02 {
    def apply(): Dept02 = {
        println("apply...object")
        new Dept02()
    }
}




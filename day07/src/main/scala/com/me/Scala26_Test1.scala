package com.me

object Scala26_Test1 {
    def main(args: Array[String]): Unit = {

        val dept1 = Dept04()
        val dept2 = Dept04()

        println(dept1 eq dept2)

    }
}

class Dept04 private {
}

object Dept04 {
    val dept = new Dept04()
    def apply(): Dept04 = {
        dept
    }
}

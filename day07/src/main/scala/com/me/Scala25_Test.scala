package com.me

object Scala25_Test {
    def main(args: Array[String]): Unit = {

        val dept2 = Dept03()

        val clazz: Class[Dept03] = classOf[Dept03]



    }
}

class Dept03 {
    protected def getDeptName(): String = {
        return "xxxx"
    }
}
object Dept03 {
    def apply(): Dept03 = new Dept03()
}

class SubDept1 extends Dept03 {


}
class SubDept2 extends Dept03 {

}

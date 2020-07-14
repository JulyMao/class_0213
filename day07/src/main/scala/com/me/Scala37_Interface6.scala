package com.me

object Scala37_Interface6 {
    def main(args: Array[String]): Unit = {


        new MySQL37().operData()

    }
}
trait Operate37 {
    def operData(): Unit = {
        println("操作数据")
    }
}
trait DB37 extends Operate37 {
    override def operData(): Unit = {
        print("向数据库中")
        super.operData()
    }
}
trait Log37 extends Operate37 {
    override def operData(): Unit = {
        print("向日志中")
        //super[Operate37].operData()
        super.operData()
    }
}

class MySQL37 extends DB37 with Log37 {

}

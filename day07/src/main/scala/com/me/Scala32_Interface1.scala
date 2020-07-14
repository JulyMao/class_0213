package com.me

object Scala32_Interface1 {
    def main(args: Array[String]): Unit = {


        val operate : Operate = new MySQL()
        operate.oper()

    }
}
// 声明特质
trait Operate {
    // 抽象方法 - 不完整方法
    def oper():Unit
}

class MySQL extends Operate {
    def oper():Unit = {
        println("执行mysql数据操作...")
    }
}


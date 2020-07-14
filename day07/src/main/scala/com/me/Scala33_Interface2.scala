package com.me

object Scala33_Interface2 {
    def main(args: Array[String]): Unit = {


        val mysql = new MySQL33() with Operate33
        mysql.select()
        mysql.insert()
    }
}

trait Operate33 {
    def insert(): Unit = {
        println("insert data....")
    }
}

class MySQL33 {
    def select(): Unit = {
        println("select data....")
    }
}


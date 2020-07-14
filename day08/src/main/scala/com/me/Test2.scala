package com.me

object Test2 {

    def main(args: Array[String]): Unit = {

        val list: List[Int] = 1::2::3::Nil
        println(list)
        val list1: List[Int] = 4::5::list

        val list2: List[Any] = 4::5::list:::Nil
        println(list1)
        println(list2)
        val list3: List[Nothing] = List()
        val nil  = Nil
        println(list3 eq nil)

    }
}

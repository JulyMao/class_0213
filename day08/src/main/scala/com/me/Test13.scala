package com.me

object Test13 {

    def main(args: Array[String]): Unit = {

        val user1 = new User()
        user1.age = 20
        user1.name = "zhangsan"

        val user2 = new User()
        user2.name = "lisi"
        user2.age = 20

        val user3 = new User()
        user3.name = "wangwu"
        user3.age = 10

        val list = List(user2, user1, user3 )

        println(list.sortBy(user => {
            (user.age, user.name)
        }))

    }
    class User {
        var name : String = _
        var age : Int = _

        override def toString: String = {
            s"User[$name, $age]"
        }
    }
}

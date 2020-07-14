package com.me

/**
 * @author maow
 * @create 2020-05-20 19:35
 */
object FunctionCode {
  def main(args: Array[String]): Unit = {
    test1()
    println(test2())
    test3("maow")
    println(test4("maow"))
    test5("mao","wei")
    println(test6("mao","wei"))
  }
    /*[修饰符] def 函数名 ( 参数列表 ) [:返回值类型] = {
        函数体
      }

      private def test( s : String ) : Unit = {
         println(s)
      }
*/
    //1.无参无返回值
    def test1() : Unit ={
      println("maow")
    }


    //2.无参有返回值
    def test2() : String = {
      "maow"
    }
    //3.有参无返回值
    def test3(name:String) : Unit = {
      println(name)
    }
    //4.有参有返回值
    def test4(name:String) : String ={
      name
    }

    //5.多参无返回值
    def test5(name:String*) : Unit={
      println(name)
    }
    //6.多参有返回值
    def test6(name:String*) : String={
      println(name)
      "maow"
    }


}

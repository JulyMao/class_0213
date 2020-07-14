package com.me

/**
 * @author maow
 * @create 2020-05-20 21:40
 */
object Exer {
  def main(args: Array[String]): Unit = {

//    1. 如果想把一个任意的数字A通过转换后得到它的2倍，那么这个转换的函数应该如何声明和使用
    def trans(i:Int) : Int ={
      i * 2
    }
    println(trans(5))

//    2. 如果上一题想将数字A转换为任意数据B（不局限为数字），转换规则自己定义，该如何声明
    def trans2(i:Int) = {
      if (i%2==0){
        i
      }else{
        "maow"
      }
    }

    def f(i:Int,j:Int) = {
      i * j
    }
//    3. 如果函数调用：  test(10,20,c)的计算结果由参数c来决定，这个参数c你会如何声明
    def test(i:Int,j:Int,c:(Int,Int) => Int) = c(i,j)
    println(test(10,20,_+_))//_+_实际上是匿名函数的函数体，满足test的第三个参数即可
    println(test(10,20,_-_))
    println(test(10,20,_*_))
    println(test(10,20,_/_))
    println(test(10,20,_*2*_))
    println(test(10,20,f(_,_)))
//    4. 如果设计一个用于过滤的函数，你会如何做？
//    要求：对传递的包含多个单词的字符串参数,根据指定的规则对word进行过滤
//    例子："hello world scala spark" => 首写字母为s => "scala, spark"
    def filtration(str:String) ={
      var finalStr : String = ""
      val string = str.split(" ")
      for (i <-string){
        if (i.startsWith("s")){
          println(i)
          if (finalStr == ""){
            finalStr = finalStr.concat(i)
          }else{
            finalStr = finalStr.concat(","+i)
          }

        }
      }
      finalStr
    }

    println(filtration("hello world scala spark"))
  }
}

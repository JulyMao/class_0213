package com.me

/**
 * @author maow
 * @create 2020-05-18 21:49
 */
object StringConcat {
  def main(args:Array[String]) : Unit = {
    val name : String = "maow";
    // 字符串连接
    println("Hello " + name);

    // 传值字符串(格式化字符串)
    printf("name=%s", name);
    println()

    //插值字符串
    println(s"name = $name");

    //多行字符串
    println(
      s"""
        |name
        |$name
      """.stripMargin
    );
  }
}

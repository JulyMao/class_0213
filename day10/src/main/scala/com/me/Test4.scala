package com.me

/**
 * @author maow
 * @create 2020-05-31 21:26
 */
object Test4 {
  def main(args: Array[String]): Unit = {
    def describe(x: Any) = {
      val result = x match {
        case 5 => "Int five"
        case "hello" => "String hello"
        case true => "Boolean true"
        case '+' => "Char +"
        case  _ => "Something else"
      }
      println( result )
    }
    describe("abc")
  }
}

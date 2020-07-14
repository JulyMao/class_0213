package com.me

/**
 * @author maow
 * @create 2020-05-18 10:48
 */
object Hello {
  def main(args : Array[String]) : Unit = {
    println("Hello")
    println(test())
  }

  def test() : String = {
    return "maow"
  }

}

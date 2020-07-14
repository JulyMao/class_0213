package com.me

import java.io.{File, PrintWriter}

import scala.collection.Iterator
import scala.io.{Source, StdIn}

/**
 * @author maow
 * @create 2020-05-18 21:56
 */
object InputOutput {
  def main(args: Array[String]): Unit = {
//    printAge
//    InputFromFile
    OutputToFile
  }

  def printAge : Unit = {
    val age : Int = StdIn.readInt()
    println(age)
  }

  def  InputFromFile : Unit = {
    val strings: Iterator[String] = Source.fromFile("input/input.txt").getLines();
    while (strings.hasNext){
      println(strings.next());
    }
  }

  def OutputToFile : Unit = {
    val writer = new PrintWriter(new File("output/output.txt"))
    writer.write("maow awesome");
    writer.close();
  }

}

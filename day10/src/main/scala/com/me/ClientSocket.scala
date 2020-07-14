package com.me

import java.net.Socket

/**
 * @author maow
 * @create 2020-05-31 20:29
 */
object ClientSocket {
  def main(args: Array[String]): Unit = {
    val socket1 = new Socket("localhost",9999)
    val socket2 = new Socket("localhost",8888)
    socket1.getOutputStream.write(10)
    socket1.shutdownOutput()
    val i1: Int = socket1.getInputStream.read()
    socket2.getOutputStream.write(20)
    val i2: Int = socket2.getInputStream.read()
    val i3: Int = Calculate().fun3(i1,i2)
    println(i3)
    socket1.close()
    socket2.close()
  }
}

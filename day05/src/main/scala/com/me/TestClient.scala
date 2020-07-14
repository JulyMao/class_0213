package com.me

import java.io.{ByteArrayOutputStream, ObjectOutputStream}
import java.net.Socket


/**
 * @author maow
 * @create 2020-05-22 19:00
 */
object TestClient {

  def main(args: Array[String]): Unit = {
    val ft = new FunctionClass
    val socket = new Socket("localhost", 1024)
    val objectOutputStream = new ObjectOutputStream(socket.getOutputStream)
    objectOutputStream.writeObject(ft)
    socket.shutdownOutput()
    var flag = true
    while (flag) {
      val is = socket.getInputStream
      val baos = new ByteArrayOutputStream
      val buffer1 = new Array[Byte](10)
      var len1 = 0
      while (flag) {
        len1 = is.read(buffer1)
        if (len1 != -1) {
          baos.write(buffer1, 0, len1)
        } else {
          flag = false
        }
      }
      println(baos.toString)
      objectOutputStream.close()
      socket.close()
    }
  }
}

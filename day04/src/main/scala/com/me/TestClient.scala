package com.me

import java.io.{BufferedInputStream, ByteArrayOutputStream, InputStreamReader, ObjectOutputStream}
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

      //      val is = socket.getInputStream
      ////      val bis = new BufferedInputStream(is)
      //      val reader = new InputStreamReader(is, "utf-8")
      //      val cbuf = new Array[Char](100)
      //      var len = 0
      //      while (flag) {
      //        len = reader.read(cbuf)
      //        if (len != -1) {
      //          val str = new String(cbuf, 0, len)
      //          println(str)
      //        } else {
      //          flag = false
      //        }


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

//      val is = socket.getInputStream.read()
//      if (is != -1) {
//        println("结果是" + is.toString)
//      } else {
//        flag = false
//      }

      objectOutputStream.close()
      socket.close()
    }
  }
}

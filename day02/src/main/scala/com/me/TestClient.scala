package com.me

import java.net.Socket

/**
 * @author maow
 * @create 2020-05-19 19:29
 */
object TestClient {
  def main(args: Array[String]): Unit = {

    val socket = new Socket("localhost",9999);
    val write = socket.getOutputStream
    write.write(1);
//    write.write(-1)
    write.write(2)
    socket.close();
//
//    for (i <- 1 to 100) {
//      val socket = new Socket("localhost",9999);
//      socket.getOutputStream.write(i)
//      socket.close()
//    }


  }

}

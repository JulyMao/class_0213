package com.me

import java.net.{ ServerSocket, Socket}

/**
 * @author maow
 * @create 2020-05-31 20:29
 */
object ServerSocket1 {
  def main(args: Array[String]): Unit = {
    val serverSocket = new ServerSocket(9999)
    while (true){

      val socket: Socket = serverSocket.accept()
      val i: Int = socket.getInputStream.read()
      val i1: Int = Calculate().fun1(i)
      socket.shutdownInput()

      socket.getOutputStream.write(i1)
      socket.close()
    }

  }
}

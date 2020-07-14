package com.me

import java.net.{ServerSocket, Socket}

/**
 * @author maow
 * @create 2020-05-31 20:30
 */
object ServerSocket2 {
  def main(args: Array[String]): Unit = {
    val serverSocket = new ServerSocket(8888)
    while (true){

      val socket: Socket = serverSocket.accept()
      val i: Int = socket.getInputStream.read()
      val i2: Int = Calculate().fun2(i)
      socket.shutdownInput()

      socket.getOutputStream.write(i2)
      socket.close()
    }

  }
}

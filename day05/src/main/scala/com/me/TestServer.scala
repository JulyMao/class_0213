package com.me

import java.io.ObjectInputStream
import java.net.ServerSocket


object TestServer {
  def main(args: Array[String]): Unit = {
    val socketServer = new ServerSocket(1024)
    while (true) {
      val socket = socketServer.accept()
      new Thread(
        new Runnable {
          override def run(): Unit = {
            while (!socket.isClosed) {
              try {
                val stream = socket.getInputStream
                val objectInputStream = new ObjectInputStream(stream)
                println("Got it!")
                val obj = objectInputStream.readObject().asInstanceOf[FunctionClass]
                val os = socket.getOutputStream

                //"fun=>Int:" +
                os.write((obj.fun(10).toString + "\n").getBytes)
                os.write((obj.fun1(10,20).toString + "\n").getBytes)
                os.write((obj.fun2().toString + "\n").getBytes())
                os.write((obj.fun3("哈哈哈").toString + "\n").getBytes())
                objectInputStream.close()
                stream.close()
              } catch {
                case e: Exception => {
                  println("客户端已经关闭")
                  socket.close()
                }
              }
            }
          }
        }
      ).start()
    }
  }

}

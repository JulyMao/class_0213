package com.me

import java.net.ServerSocket

/**
 * @author maow
 * @create 2020-05-19 19:18
 */
object TestServer {
  def main(args: Array[String]): Unit = {
    val server = new ServerSocket(9999);

    while (true){
      val socket = server.accept();
      new Thread(new Runnable {
//        println("====")
        override def run(): Unit = {
          try {
//            println("1111")
//            while (socket.getInputStream.read != -1){
//              val date = socket.getInputStream.read;
//              println(date)
//            }
            while ( true ) {
              val data = socket.getInputStream.read;
              if (data != -1) {
                System.out.println("data = " + data);
              }
            }

          }catch {
            case e : Exception =>{
              println("exception")
            }
          }
        }

      }).start()
    }

//    while (true){
//      val socket = server.accept();
//      val date = socket.getInputStream().read();
//      println(date)
//    }
  }
}

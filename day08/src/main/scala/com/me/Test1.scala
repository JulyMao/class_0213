package com.me
import scala.collection.mutable
/**
 * @author maow
 * @create 2020-05-28 17:47
 */
object Test1 {


    def main(args: Array[String]): Unit = {
      //1.
      var data:List[Tuple2[String,Int]] =   List(
        ("hello", 4),
        ("hello spark", 3),
        ("hello spark scala", 2),
        ("hello spark scala hive", 1)
      )
//      var map:mutable.Map[String,Int] = mutable.Map()
//      for (elem <- data) {
//        var str:String= elem._1
//        var strs:Array[String] = str.split(" ")
//        var value = elem._2
//        for (elem <- strs) {
//          if(map.contains(elem)==true){
//            //println(elem)
//            var count:Int = map.get(elem).getOrElse(0)
//            count = count+value
//            map.update(elem,count)
//          }
//          else{
//            map.put(elem,value)
//          }
//        }
//      }
//      var newList = map.toList.sortBy(a =>a._2)(Ordering.Int.reverse).take(3)
//      println(newList)
      //2.
      val tuples = data.map(a => (a._1+" ") * a._2)
        .flatMap(a => a.split(" "))
      //  .groupBy(a => a).map(a => (a._1, a._2.length))
//        .toList.sortBy(a => a._2)(Ordering.Int.reverse).take(3)
      println(tuples)
    }

}

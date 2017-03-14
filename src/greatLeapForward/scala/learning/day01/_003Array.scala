package greatLeapForward.scala.learning.day01

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Jinbin Zhu on 3/13/17.
  */
class _003Array {

}
object _003Array extends App{

  //10, 是数组长度
  val arr1 = new Array[Int](10)

  //调用了Array的apply方法，apply会new数组实例并将值赋给数组实例
  val arr2 = Array(1, 2, 3)

  //8, 是数组元素
  val arr3 = Array[Int](8)

  //可变长度数组
  val abuf = new ArrayBuffer[Int]()

  abuf += 2 //添加单个元素
  abuf += 4
  abuf += 6
  abuf += (7, 8, 9) //添加元组
  abuf ++= arr2     //添加数组
  abuf.insert(2, 99, 99, 100) //在(2)处添加99，99，100
  abuf.remove(1, 3) //从（1）处开始，删除3个元素


  //print(abuf.toList)
  abuf.map(println)

  //map返回值类型，由前面表达式确定
  val abuf2 = abuf.map(_ * 2)
  abuf2.map(println)

  /**
    * 数组常用方法
    */

  println(abuf.sum)
  println(abuf.min)
  println(abuf.max)
  println(abuf.length)
  println(abuf.last)
  abuf.sorted.map(println)
  //abuf.sortBy(_)
  abuf.sortWith(_ > _).map(println)

}

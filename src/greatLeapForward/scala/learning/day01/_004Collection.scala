package greatLeapForward.scala.learning.day01

import scala.collection.mutable

/**
  * Created by Jinbin Zhu on 3/13/17.
  */
class _004Collection {

}

object _004Collection extends App{

  /**
    * Map
    */
  import scala.collection.mutable._
  val map = Map("name" -> "zhousan", "age" -> 18)
  //map("name") = "lisi"  //scala集合类分为mutable（值可变）和immutable（值不可变). 默认为immutable
  map("age") = 21

  //添加元素
  map("score") = 59.5
  map += ("gender" -> "male")


  /**
    * Tuple
    */
  val stu = ("zhousan", 18, 59.5)
  println(stu._1) //角标从1开始

  val arr = Array(("name", "zhangsan"), ("age", 21))
  arr.toMap

  /**
    * Zip
    */
  val a = Array("name", "age", "class") //如果数组长度不一致，则多出来的部分去掉
  val b = Array("zhousan", 17, 3)
  a.zip(b)

  /**
    * List
    */
  val list1 = List(1, 2, 3, 4, 5)
  //list(0) = 4 //不可改变

  val list2 = List(6, 7, 8, 9, 10)

  //list的合并
  val list3 = 0 :: list1
  val list4 = 0 +: list1
  val list5 = list1 :: list2

  val listB = ListBuffer(1, 2, 3, 4, 5)
  listB(2) = 100
  listB += 8
  listB.append(90, 83, 32)

  val listB2 = ListBuffer(32, 54)
  listB ++= listB2


  /**
    * Set, 元素不可重复
    */
  val hSet = new mutable.HashSet[Int]()
  hSet += 1
  hSet ++= Set(2, 3, 4, 5)
  hSet -= 4
  hSet.remove(5)
  hSet.map(println)

}

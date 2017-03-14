package greatLeapForward.scala.leaning.day01

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

}

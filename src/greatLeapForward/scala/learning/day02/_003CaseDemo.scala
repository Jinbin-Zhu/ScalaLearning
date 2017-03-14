package greatLeapForward.scala.learning.day02

import scala.util.Random


/**
  * Created by Jinbin Zhu on 3/14/17.
  */
class _003CaseDemo {


}

/**
  * case String
  */
object _003CaseDemo extends App {

  val stus = Array("zhangsan", "lisi", "wangwu")

  val name = stus(Random.nextInt(stus.length))
  println(name)
  name match {
    case "zhangsan" =>
      println("zhangsan selected")
    case "lisi" =>
      println("lisi selected")
    case "wangwu" =>
      println("wangwu selected")
    case _ =>
      println("nobody selected")
  }
}

/**
  * case data type
  */
object _003CaseDemo2 extends App {
  val stu = Array("zhangsan", 18, 59.5f)
  val elem = stu(Random.nextInt(stu.length))
  println(elem)
  elem match {
    case name: String =>
      println("this is zhangsan")
    case age: Int if(age > 18)=>
      print("he is 18 now")
    case score: Float =>
      print("his match score is 59.5")
    case _ =>
      print("something is wrong")

  }
}

/**
  *case Array
  */
object _003CaseDemo3 extends App {
  val arr = Array(0, 3, 5)
  arr match {
    case Array(1, x, y) =>
      println(s"there are three nums, the fist num is 1, the second is $x and the third is $y")
    case Array(0, _*) =>
      println("the first num is 0")
    case _ =>
      println("I have no idea")
  }
}

/**
  * case List
  */
object _003CaseDemo4 extends App {
  val list = List(1, 3, 6, 7)
  list match {
    case 9 :: Nil =>
      println("the first is 9")
    case x :: y :: Nil =>
      println(s"$x, $y, $Nil")
    case 1 :: last =>
      println(s"$last")
    case _ =>
      println("some thing is wrong")
  }
}

/**
  * case Tuple
  */
object _003CaseDemo5 extends App {
  val tu = (3, 5, 9)
  tu match {
    case (4, x, y) =>
      println("the head is 4")
    case (_, 5, 9) =>
      println("three element, the last two are 5, 9")
    case _ =>
      println("some thing is wrong")
  }
}

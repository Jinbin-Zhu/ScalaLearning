package greatLeapForward.scala.learning.day02

/**
  * Created by johann on 3/14/17.
  */
class _006PartialFun {

}

object _006PartialFun extends App {

  //偏函数的定义
  val fun1: PartialFunction[String, Int] = {

    case "one" => 1
    case "two" => 2
    case _ => -1
  }

  println(fun1("two"))

  //match模拟偏函数
  val fun2: (String) => Int = {
    _ match {
      case "one" => 1
      case "two" => 2
      case _ => -1
    }
  }

  println(fun2("one"))

}

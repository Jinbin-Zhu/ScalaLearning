package greatLeapForward.scala.leaning.day01

/**
  * Created by johann on 3/13/17.
  * scala方法和函数的使用
  * 注：函数可以作为值（参数）传递给方法，二方法不可以
  */
class _002Functional {

  //方法， 使用def定义
  def max(num1: Int, num2: Int): Int = {

    if(num1 > num2) num1 else num2
  }

  /**
    * 函数，使用val定义（和变量声明一样）
    */
  //函数的第一种定义方式
  val min = (num1: Int, num2: Int) => {

    if(num1 < num2) num1 else num2
  }

  //函数的第二种定义方式 -- 按定义变量的方式，定义一个函数
  val num: Int = 2
  val sum: (Int, Int) => Int = _ + _

  //用第二种方式，将函数传递给一个方法
  def minus(f: (Int, Int) => Int, num: Int): Int = {
    f(1, 2) - num
  }
}

object _002Functional {

  def main(args: Array[String]): Unit = {

    val fun = new _002Functional
    println(fun.max(3, 6))
    println(fun.min(5, 9))

    //函数作为参数，传递给方法
    val arr = Array(1, 2, 3, 4, 5, 6, 7)
    println(arr.reduce(fun.max))

    println(fun.sum(3, 5))

    println(fun.minus(fun.sum, 3))
  }
}

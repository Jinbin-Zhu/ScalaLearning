package greatLeapForward.scala.learning.day01

/**
  * Created by Jinbin Zhu on 3/13/17.
  */
class _001HelloScala {

}

/**
  * 伴生对象
  * 静态方法或静态变量，即object不需要new便可使用
  */
object _001HelloScala {
  def main(args: Array[String]): Unit = {

    /**
      * 第一要点， 声明变量
      * val 变量名：数据类型 = 值
      * val定义的变量的值不可修改
      * var 定义的变量可以修改
      * val定义变量的好处：1、安全；2、垃圾回收效率高
      */
    val info: String = "Hello Scala!"
    var name: String = "zhousan"

    //scala字符串输入格式 —— s"$变量名"
    println(s"$info, I am $name")

    /**
      * 第二要点， 数据类型
      * scala没有包装类，一切皆对象
      * 首字母大写
      */
    val age: Int = 15
    val score: Float = 59.5f

    /**
      * 条件表达式
      */
    val num1 = 23
    val num2 = 54
    val max = if(num1 > num2) num1 else num2

    //混合条件表达式
    val pass = if(score > 60) "yes" else score
    val fail = if(score < 60) "fail" else () //else ()可以省略, ()相当于Java中的void
    val grade = if(score > 85) "perfect" else if(score > 70) "good" else if(score > 60) "ok" else "bad"

    println(s"$grade")

    /**
      * 循环
      */
    val arr = Array(1, 2, 3, 4, 5, 6)
    //for(i <- 0 to arr.length) //内存溢出了，因为to方法是包含了数组长度那个值
    for(i <- 0 until arr.length  )
      println(arr(i))

    //高级条件for循环
    for(i <- 0 until arr.length; if arr(i) % 2 == 0)
      println(arr(i))
    //scala高级实现 —— filter()
    arr.filter(_ % 2 == 0)

    //yield会生成新的集合，其数据类型由前面表达式决定
    val even = for(num <- 1 to 10 ) yield num * 2
    for(num <- even)
      println(num)
    //scala高级实现 —— map()
    val even2 = arr.map(_ * 2)
    for(num <- even2)
      println(num)

  }
}

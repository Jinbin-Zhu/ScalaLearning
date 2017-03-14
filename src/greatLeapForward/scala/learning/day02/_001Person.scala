package greatLeapForward.scala.learning.day02

import scala.io.Source

/**
  * Created by Jinbin Zhu on 3/13/17.
  */
private[day02] class _001Person private {
  //第一个private -- 包访问权限，只能是包day02之下的对象能够访问该类
  //第二个private -- 私有构造器, 只能伴生对象可以调用该构造器

  var id: String = "001"
  val name: String = "zhousan"
  private var gender: String = "female" //可以在本类或伴生对象中访问
  private[this] var age: Int = _ //只能在本类中访问, _显示不进行明确初始化(scala要求变量必须初始化)

  def getAge = this.age
}

object _001Person {

  def main(args: Array[String]): Unit = {

    val per = new _001Person
    println(per.gender)
  }
}


/**
  * 主构造器内的所有内容在初始化时，将全部被执行（自定义方法或函数会被加载）
  * @param name
  * @param age
  * @param gender
  */
class People(val name: String, var age: Int, var gender: String = "female") {
  //构造器内变量设了默认值，在new对象的时候可以不指定设置该参数
  //如果new对象的时候不指定该变量，则该变量是private[this]型的
  //如果new对象的时候指定该变量，则该变量是public型的

  print(s"$name")

  try {
    val info = Source.fromFile("/home/johann/Data/bigdata/words1.txt")
    info.map(println)
  } catch {
    case e: Exception => e.printStackTrace()
  } finally {

  }

  def sayHi() = {
    println("hello")
  }



}

object People {
  def main(args: Array[String]): Unit = {

    val peo = new People("zhousan", 18, "male")

  }
}

class Dog {

}

object Dog {

  def apply(): Unit = {
    println("this is apply()")
  }

  def apply(name: String): Unit = {
    println(s"this is apply($name)")
  }
  def main(args: Array[String]): Unit = {

    val dog1 = Dog("wangcai")
    val dog2 = Dog()
  }
}
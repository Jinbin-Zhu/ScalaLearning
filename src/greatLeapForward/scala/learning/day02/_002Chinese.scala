package greatLeapForward.scala.learning.day02

/**
  * Created by Jjinbin Zhu on 3/14/17.
  */

//trait
trait Animal {
  def run
}

//abstract class
abstract class Human {
  var name: String = _
  var age: Int = _

  def getInfo
}

class _002Chinese extends Human with Animal{
  override def run: Unit = {
    println(" I can run.")
  }

  override def getInfo: Unit = {
    println(s"Hello everybody, I am $name, I'm $age now.")
  }
}

object _002Chinese {
  def main(args: Array[String]): Unit = {

    val cn = new _002Chinese
    cn.name = "zhousan"
    cn.age = 18
    cn.getInfo
  }
}

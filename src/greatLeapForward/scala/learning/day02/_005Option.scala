package greatLeapForward.scala.learning.day02

/**
  * Created by johann on 3/14/17.
  */
class _005Option {

}

object _005Option extends App {

  val stu = Map("name" -> "zhousan", "age" -> 18)
  val score = stu.get("score") match {
    case Some(score) =>
      println(s"your match score is $score")
    case None =>
      println("some thing is wrong")

  }

  println(stu.getOrElse("score", "some thing is wrong"))
}

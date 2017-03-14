package greatLeapForward.scala.learning.day02

import scala.util.Random

/**
  * Created by johann on 3/14/17.
  */
class _004CaseClass {

}

//样例类必须含参数,样例类在使用时不需要new
case class SubmitTask(id: String, name: String)
case class HeartBeat(time: Long)
case object HearBeatCheck

object _004CaseClass extends App{

  val objs = Array(SubmitTask("001", "zhangsan"), HeartBeat(12345), HearBeatCheck)
  val obj = objs(Random.nextInt(objs.length))
  obj match {
    case SubmitTask(id, name) =>
      println("SubmitTask selected")
    case HeartBeat(time) =>
      println("HeartBeat selected")
    case HearBeatCheck =>
      println("HearBeatCheck selected")
    case _ =>
      println("some thing is wrong")
  }
}

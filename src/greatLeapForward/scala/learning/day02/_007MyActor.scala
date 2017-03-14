package greatLeapForward.scala.learning.day02

import scala.actors.Actor

/**
  * Created by johann on 3/14/17.
  */
object _007MyActor1 extends Actor {
  override def act(): Unit = {
    for(i <- 1 to 10){
      println("My-Actor-1")
      Thread.sleep(2000)
    }
  }
}

object _007MyActor2 extends Actor {
  override def act(): Unit = {
    for(i <- 1 to 10){
      println("My-Actor-2")
      Thread.sleep(2000)
    }
  }
}

object ActorTest extends App {
  _007MyActor1.start() //调用actor.start()便会执行actor中的act方法
  _007MyActor2.start()
}

class _007MyActor3 extends Actor {
  override def act(): Unit = {
    while(true){
      receive {
        case "start" =>
          println("receive start instruction")
          Thread.sleep(2000)
        case "stop" =>
          println("receive stop instruction")
          Thread.sleep(2000)
        case _ =>
          println("something is wrong, program will stop")
          exit()
      }
    }
  }
}

object ActorTest2 extends App {
  val actor = new _007MyActor3
  actor.start()
  actor ! "start" //发送异步消息，需等待结果
  actor ! "stop"
  actor ! "hello"
}

class _007MyActor4 extends Actor {
  override def act(): Unit = {
    loop {
      react {
        case "start" =>
          println("receive start instruction")
          Thread.sleep(2000)
        case "stop" =>
          println("receive stop instruction")
          Thread.sleep(2000)
        case _ =>
          println("something is wrong, program will stop")
          exit()
      }
    }
  }
}

object ActorTest3 extends App {
  val actor = new _007MyActor3
  actor.start()
  actor ! "start" //发送异步消息，需等待结果
  actor ! "stop"
  actor ! "hello"
}
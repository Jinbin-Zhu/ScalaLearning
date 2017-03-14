package greatLeapForward.scala.learning.day02

import scala.actors.{Actor, Future}
import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.io.Source

/**
  * Created by Jinbin Zhu on 3/13/17.
  * 基于actor多并发的单机版wordcount
  */
case class Begin(file: String)
case class Result(result: Map[String, Int])
case object Stop

class _008Test extends Actor{
  override def act(): Unit = {
    loop {
      react {
        case Begin(file) =>
          val result = Source.fromFile(file).
                              getLines().
                              flatMap(_.split(" ")).
                              map((_, 1)).
                              toList.
                              groupBy(_._1).
                              mapValues(_.foldLeft(0)(_+_._2))
          sender! Result(result)  //将结果返回给发送者
        case Stop =>
          exit()
      }
    }
  }
}

object _008Test {
  def main(args: Array[String]): Unit = {
    val replySet = new mutable.HashSet[Future[Any]]() //用来存放返回结果
    val resultList = new ListBuffer[Result]

    val files = Array("/home/johann/Data/bigdata/words1.txt", "/home/johann/Data/bigdata/words2.txt")
    for(file <- files){
      val actor = new _008Test
      actor.start
      val reply = actor !! Begin(file) //发送同步消息，不需要等待结果
      replySet += reply
    }

    while(replySet.size > 0){
      val toCompute = replySet.filter(_.isSet) //toCompute —— 可计算的，即actor已经返回结果
      for(compute <- toCompute){
        val result = compute.apply().asInstanceOf[Result] //获得Future的内容, asInstanceOf —— 强转类型
        resultList += result
        replySet -= compute
      }
    }

    val words = resultList.
                flatMap(_.result).
                groupBy(_._1).
                mapValues(_.foldLeft(0)(_+_._2)).
                toList.sortBy(_._2).
                reverse
    print(words)
  }
}
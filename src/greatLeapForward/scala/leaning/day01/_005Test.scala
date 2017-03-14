package greatLeapForward.scala.leaning.day01

/**
  * Created by Jinbin Zhu on 3/13/17.
  */
class _005Test {

}

object _005Test {

}

object wordCount {
  def main(args: Array[String]): Unit = {

    val lines = List("hello jim hello lilie",
                      "I am zhangsan haha",
                      "hello liuliu hi",
                      "liuliu niHao")
    val words1 =
      lines.map(_.split(" ")).    //List[Array[String]] = List(Array(hello, jim, hello, lilie), Array(I, am, zhangsan, haha), Array(hello, liuliu, hi), Array(liuliu, niHao))
      flatten.                    //List[String] = List(hello, jim, hello, lilie, I, am, zhangsan, haha, hello, liuliu, hi, liuliu, niHao)
      map((_, 1)).                //List[(String, Int)] = List((hello,1), (jim,1), (hello,1), (lilie,1), (I,1), (am,1), (zhangsan,1), (haha,1), (hello,1), (liuliu,1), (hi,1), (liuliu,1), (niHao,1))
      groupBy(_._1).              //Map[String,List[(String, Int)]] = Map(am -> List((am,1)), liuliu -> List((liuliu,1), (liuliu,1)), I -> List((I,1)), jim -> List((jim,1)), lilie -> List((lilie,1)), niHao -> List((niHao,1)), hi -> List((hi,1)), haha -> List((haha,1)), hello -> List((hello,1), (hello,1), (hello,1)), zhangsan -> List((zhangsan,1)))
      map(t => (t._1, t._2.size)).//Map[String,Int] = Map(am -> 1, liuliu -> 2, I -> 1, jim -> 1, lilie -> 1, niHao -> 1, hi -> 1, haha -> 1, hello -> 3, zhangsan -> 1)
      toList.sortBy(_._2).reverse //List[(String, Int)] = List((hello,3), (liuliu,2), (zhangsan,1), (haha,1), (hi,1), (niHao,1), (lilie,1), (jim,1), (I,1), (am,1))
    println(words1)

    val words2 =
      lines.flatMap(_.split(" ")).
        map((_, 1)).
        groupBy(_._1).            //liuliu -> List((liuliu,1), (liuliu,1))
        mapValues(_.size).        //mapVlues将key取出，然后对values进行相关函数操作
        toList.sortBy(_._2).reverse
    println(words2)

    val words3 =
      lines.flatMap(_.split(" ")).
        map((_, 1)).
        groupBy(_._1).            //liuliu -> List((liuliu,1), (liuliu,1))
        mapValues(_.foldLeft(0)(_+_._2)).//_.foldLeft(0)(_+_._2)， 第一个_为liuliu -> List((liuliu,1), (liuliu,1))中的value部分；第二个_为累加值；第三个_为(liuliu,1)；第四个_.2为1
        toList.sortBy(_._2).reverse
    println(words3)
  }
}
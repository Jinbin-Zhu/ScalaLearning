package greatLeapForward.scala.leaning.day01

/**
  * Created by Jinbin Zhu on 3/13/17.
  */
class _002FunctionalPlus {

}

object _002FunctionalPlus extends App{

  override def main(args: Array[String]): Unit = {

    val list = List(1, 2, 3, 4, 5)
    val groups = list.grouped(3) //3个元素一组
    groups.toList.map(println)

    val list2 = List(List(1, 2, 3, 4, 5), List(6, 7, 8, 9))
    list2.map(println)
    val list3 = list2.flatten //List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    list3.map(println)

    val arr = Array(1, 2, 3, 4, 5)
    println(arr.reduce(_ + _)) //(((1+2)+3)+4)+5, 左 ——> 右
    println(arr.par.reduce(_+_)) //arr.par, 将arr数据并行化，并行度依据系统核数

    println(arr.fold(10)(_+_))  //（10）为初始值
    println(arr.par.fold(10)(_+_))//答案为55，因为系统有4个核，所以arr会被并行化为4个并行任务，而每个并行任务的初始值都是10，所以10被加了4次
  }
}
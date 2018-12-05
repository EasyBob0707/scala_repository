package com.scala.grammar

/**
  * If条件语句
  * 在scala中的使用方式与java中基本一样，函数式编程的特点就是，定义的参数都是val修饰的
  *
  * while循环语句
  * Scala 的 while 循环和其它语言如 Java 功能一样，它含有一个条件，和一个循环体，只有条件满足，就一直执行循环体的代码。
  *
  * do-while循环语句
  * Scala 也有 do-while 循环，它和 while 循环类似，只是检查条件是否满足在循环体执行之后检查。
  *
  *
  *
  */
class ConditionExpression {

    /**
      * if条件语句
      *
      * @param num
      */
    def ifCondition(num: Int): Unit = {
        if (num > 0) println("输入的参数大于0")
        if (num < 0) println("输入的参数小于0")
        if (num == 0) println("输入的参数等于0")
    }

    /**
      * while条件语句
      *
      * @param num
      * @return
      */
    def whileCondition(num: Int*): Int = {
        var sum = 0
        if (num.size <= 0) {
            println("输入的参数不能为空")
        } else {
            var i = 0
            while (num.size - 1 >= i) {
                sum += num(i)
                i += 1
            }
        }
        sum
    }

    /**
      * doWhile循环
      *
      * @param num
      * @return
      */
    def doWhileCondition(num: Int*): Int = {
        var sum = 0
        if (num.size <= 0) {
            println("输入的参数不能为空")
        } else {
            var i = 0
            do {
                sum += num(i)
                i += 1
            } while (num.size - 1 >= i)
        }
        sum
    }

    def forCondition(): Unit = {
        val list = new scala.collection.mutable.ListBuffer[Int]
        // to是闭区间  until是左闭右开区间
        for (i <- 0 to 10) {
            list.+=(i)
        }
        // 遍历集合
        println("集合中所有的元素")
        for (li <- list) {
            println(li)
        }
        // 将集合中能被3和5整除的打印出来(循环中加入过滤条件)
        println("集合中能被2和5整除的数")
        for (li <- list if li % 2 == 0 && li % 5 == 0 && li != 0) {
            println(li)
        }
        // 返回一个集合
        println("返回一个新的数据集合")
        val lis = for (li <- list if (li % 2 == 0 || li % 5 == 0) && li != 0) yield li
        println(lis)
    }



}

object ConditionExpression {

    def main(args: Array[String]): Unit = {
        // while循环
        println(new ConditionExpression().whileCondition(1, 2, 3, 4, 5))
        println(new ConditionExpression().doWhileCondition(1, 2, 3, 4, 5))
        // for循环
        println(new ConditionExpression().forCondition())
    }

}

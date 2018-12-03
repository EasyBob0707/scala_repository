package com.scala.grammar

/**
  * If条件语句
  * 在scala中的使用方式与java中基本一样，函数式编程的特点就是，定义的参数都是val修饰的
  *
  * while循环语句
  * Scala 的 while 循环和其它语言如 Java 功能一样，它含有一个条件，和一个循环体，只有条件满足，就一直执行循环体的代码。
  *
  */
class ConditionExpression {

    /**
      * if条件语句
      * @param num
      */
    def ifCondition(num: Int): Unit = {
        if (num > 0) println("输入的参数大于0")
        if (num < 0) println("输入的参数小于0")
        if (num == 0) println("输入的参数等于0")
    }

    def whileCondition(num: Int*): Unit = {
        if (num.size == 0) {

        } else {
            println("输入的参数不能为空")
        }
    }



}

object ConditionExpression {

    def main(args: Array[String]): Unit = {

    }

}

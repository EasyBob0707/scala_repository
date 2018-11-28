package com.scala.grammar

/**
  * 在Scala中函数的定义方式（5种方式）
  * 1、规范花的写法：
  * def addInt(a: Int, b: Int): Int = {
  *     val total: Int = a + b
  *     return total
  * }
  *
  * Unit是Scala中的一种数据类型，表示无值，用作不返回任何结果的方法
  * 2、不写明返回值的类型，程序会自行判断，最后一行代码的执行结果为返回值
  * def addInt(a: Int, b: Int) = {
  *     a + b
  * }
  *
  * 3、省略返回值类型和等于号，返回的是()
  * def addInt(a: Int, b: Int){
  *     a + b
  * }
  *
  * 4、函数只有一行
  * def addInt(x: Int, y: Int) = x + y
  *
  * 5、最简单的方式
  * val addInt = (x: Int, y: Int) => x + y
  *
  * 高阶函数主要有两种：
  * 一、将一个函数作为另一个函数的参数（即函数参数）
  * 二、返回值是函数的函数
  *
  */
object HigherOrderFunction {

    def main(args: Array[String]): Unit = {
        println(addInt(1, 2))
        println(addInt01(2, 3))
        println(addInt02(1, 5))
        val addFive = addBy(5)                        //> addFive  : Double => Double = <function1>
        println(addFive(20))
    }

    /**
      * 返回的是一个()
      * @param a
      * @param b
      */
    def addInt(a: Int, b: Int){
        a + b
    }

    /**
      * 函数
      * @param x
      * @param y
      * @return
      */
    def addInt01(x: Int,y: Int) = x + y

    /**
      * 匿名函数
      * 调用方式：变量名称(对应参数列表值)
      */
    val addInt02 = (x: Int, y: Int) => x + y

    /**
      * 高阶函数：返回函数的函数(外层定义一个函数，返回值又是另外的一个函数， 简单理解函数嵌套)
      * 最终的返回值是由内部的函数决定的
      *
      * @param factor
      * @return
      */
    def addBy(factor:Int) = {
        (x:Double) => factor + x
    }                                             //> addBy: (factor: Int)Double => Double

    // val addFive = addBy(5)                        //> addFive  : Double => Double = <function1>
    // println(addFive)                          //> 25.0

}

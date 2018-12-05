package com.scala.grammar

/**
  * 函数的柯里化操作：是把接受多个参数的函数变换成接受一个单一参数(最初函数的第一个参数)的函数
  * 并且返回接受余下的参数且返回结果的新函数的技术
  *
  * 简单理解：
  * 柯里化指的是将原来接受凉的参数的函数编程新的接受一个参数的函数的过程。
  * 新的函数返回一个以原有第二个参数作为参数的函数
  *
  * 在方法后加_下划线表示将该方法转化为函数
  *
  *
  *
  */
object CurryingFunction {

    def main(args: Array[String]): Unit = {
        println("===============柯里化函数===============")
        println(multiply(76)_)
    }

    /**
      * 柯里化函数
      * @param x
      * @param y
      * @return
      */
    def multiply(x: Int)(y: Int): Int = x * y

    // Scala 允许程序员自己新创建一些控制结构，并且可以使得这些控制结构在语法看起来和 Scala 内置的控制结构一样，
    // 在 Scala 中需要借助于柯里化(Currying)，柯里化是把接受多个参数的函数变换成接受一个单一参数（最初函数的第一个参数）的函数，
    // 并且返回接受余下的参数而且返回结果的新函数的技术。
    // 下面先给出一个普通的非柯里化的函数定义，实现一个加法函数
    def curriedSum(x:Int)(y:Int) = x + y

    def first(x:Int) = (y:Int) => x + y

}

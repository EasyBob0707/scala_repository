package com.scala.grammar

/**
  * 递归
  * Scala 编译器可以检测到尾递归而使用循环来代替。因此，你应该习惯使用递归函数来解决问题，如果是尾递归，那么在效率时不会有什么损失。
  * 一个尾递归函数在每次调用不会构造一个新的调用栈(stack frame)。所有递归都在同一个执行栈中运行，如果你在调试时，如果在尾递归中调试错误，不会看到嵌套的调用栈。
  */
class ScalaRecurve {

    def boom(x:Int):Int=
        if(x==0)
            throw new Exception("boom!")
        else
            boom(x-1) + 1

    // isEven 和 isOdd 事件也是为递归，但不是直接定义的尾递归，scala 编译器无法对这种递归进行优化。
    def isEven(x:Int): Boolean =
        if(x==0) true else isOdd(x-1)
    def isOdd(x:Int): Boolean=
        if(x==0) false else isEven(x-1)

}

object ScalaRecurve {

    def main(args: Array[String]): Unit = {

    }

}

package com.scala.grammar

/**
  * 闭包
  */
class ScalaClosure {

    // 这样定义的函数变量 addMore 成为一个“闭包”，因为它引用到函数外面定义的变量，定义这个函数的过程是将这个自由变量捕获而构成一个封闭的函数。
    // 有意思的是，当这个自由变量发生变化时，Scala 的闭包能够捕获到这个变化，因此 Scala 的闭包捕获的是变量本身而不是当时变量的值。
    var more = 1
    val addMore = (x: Int) => x + more

    // 柯里化，把参数拆分成多个
    def makeIncreaser(more: Int) = (x: Int) => x + more

}

object ScalaClosure {

    def main(args: Array[String]): Unit = {
        println(new ScalaClosure().addMore(1000))
        var sum = 0
        val someNumbers = List ( -11, -10, -5, 0, 5, 10)
        someNumbers.foreach(sum += _)
        println(sum)
    }

}

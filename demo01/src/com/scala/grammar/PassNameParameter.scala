package com.scala.grammar

/**
  * 传名参数
  * 通常函数参数传递的两种模式，一是传值，一是引用。而这里是第三种按名称传递。
  */
class PassNameParameter {

    var assertionsEnabled = false

    def myAssert(predicate: () => Boolean) = {
        if (assertionsEnabled && !predicate()) {
            throw new AssertionError
        }
    }

    def myAssert02(predicate: => Boolean) = {
        if (assertionsEnabled && !predicate) {
            throw new AssertionError
        }
    }
    // 传名参数（不会先计算出表达式的值）
    def myAssert03(predicate: Boolean) = {
        if (assertionsEnabled && !predicate) {
            throw new AssertionError
        }
    }

}

object PassNameParameter {

    def main(args: Array[String]): Unit = {
        // 这个 myAssert 函数的参数为一个函数类型，如果标志 assertionsEnabled 为 True 时，mymyAssert 根据 predicate 的真假决定是否抛出异常，
        // 如果 assertionsEnabled 为 false，则这个函数什么也不做。
        // 这个定义没什么问题，但调用起来看起来却有些别扭，比如：
        println(new PassNameParameter().myAssert(() => 5 / 0 == 0))
        // 可以不用传() =>
        println(new PassNameParameter().myAssert02(5 / 0 == 0))
        // 直接定义的调用方式
        println(new PassNameParameter().myAssert03(5 / 0 == 0))
    }

}

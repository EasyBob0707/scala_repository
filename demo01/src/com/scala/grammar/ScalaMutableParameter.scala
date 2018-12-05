package com.scala.grammar

/**
  * 参数
  */
class ScalaMutableParameter {

    // 方法接受可变的参数
    // Scala 在定义函数时允许指定最后一个参数可以重复（变长参数），从而允许函数调用者使用变长参数列表来调用该函数，Scala 中使用“*”来指明该参数为重复参数。
    // 方法的参数列表支持可变的的参数，只需要在参数类型后直接加“*”, 如果方法的参数列表包含多个参数，那么可变的参数一定是最后一个
    // 可变的参数列表其实就是一个数组，如下的方法 Int*   Array[Int]
    // 但是直接传入数组编译报错
    def mutableParameter(nums: Int*): Unit = {
        println(nums.size)
    }

    // 往往参数的传递与方法的定义的参数列表是一致的
    // 但是在调用方法的时候也可以指定传入的参数
    def speed(distance: Float, time:Float): Float = distance/time

    // 同样也可以缺省参数  用_替代省略的参数

    // 定义方法的时候可以指定默认值
    def defaultParameter(a : Int = 1, b: Int = 2): Int = {
        a + b
    }

}

object ScalaMutableParameter {

    def main(args: Array[String]): Unit = {
        val arrs: Array[Int] = Array[Int](1,2,3,4,5,6,7,8,9)
        // 将数组整体传入到方法中
        // new ScalaMutableParameter().mutableParameter(arrs)
        // 将数组中的每一个元素传入到方法中
        // 可以通过在变量后面添加 _*来解决，这个符号告诉 Scala 编译器在传递参数时逐个传入数组的每个元素，而不是数组整体。
        new ScalaMutableParameter().mutableParameter(arrs: _*)

        println(new ScalaMutableParameter().speed(time = 1.2f, distance = 100f))

        // 调用有默认值的方法，不给参数就用默认的参数
        println(new ScalaMutableParameter().defaultParameter())
    }

}

package com.scala.grammar

/**
  * 函数与方法的区别：
  *
  * 方法的定义
  * 定义方法的基本格式：
  *
  * def 方法名称(参数列表)： 返回值类型 = 方法体
  * scala中方法的返回值默认为方法体中最后一行表达式的值， 当然也可以使用return关键字（显示声明返回值）
  * 但是scala中不建议这样使用
  *
  * 定义的方法没有显示声明方法的返回值类型时， 在方法体中不能使用return关键字， 否则不能通过编译
  *
  * 方法与函数的区别：
  * 1.方法不能作为单独的表达式而存在（参数为空的方法除外），而函数可以。
  * def m(x: Int) = 2 * x
  * val f = (x: Int) => 2 * x
  * 直接调用f是可以的，如果直接调用m是不可以的
  * 方法转为函数
  * 方法名称_ ----->  函数
  * m_  ------>  名称为m的函数
  *
  * 2.函数必须要有参数列表，而方法可以没有参数列表。
  * def m = 100
  * val f1 = () => 100
  *
  * // 有异常的函数
  * val f2 = => 1000
  *
  * 3.方法名是方法调用，而函数名只是代表函数对象本身
  *
  * 4.在需要函数的地方，如果传递一个方法，会自动进行ETA展开（把方法转换为函数）
  * 方法名称_
  *
  * 5.传名参数本质上是个方法
  * 实际上就是传递一个没有实现方法（类似于抽象方法）
  *
  */
object FunctionAndMethod {

    def main(args: Array[String]): Unit = {
        println(add(2))
        println(sayHello("xxx"))
        // 默认参数方法的调用
        // 参数名称必须方法中定义的参数列表一致，否则不能够赋值成功
        // 反例（无法通过编译）
        // println(takeParameter(contents = "李四"))
        // 正例
        println(takeParameter(content = "张三"))
        println(takeParameter(left = "《《"))
        println(takeParameter(right = "》》"))
        // 显式指定后，参数顺序可以不一致
        // 如果不指定顺序必须一致
        takeParameter(left = "[", right = "]", content = "内容默认")
        // 此处的 :_*是将一个Range转成一个Seq
        // 将范围转化为一个序列
        println(multipleParameter(1 to 10:_*))
        // 调用没有参数列表的方法
        println(noParameter)
        // 调用空参数的函数 返回的是函数
        println(f3)
    }

    // 第一：方法的定义

    /**
      * 标准方法的定义
      *
      * 从给定的参数累加到1
      */
    def add(num: Int): Int = {
        var sum: Int= 0
        if (num == 1) {sum = num; sum}
        else num + add(num-1)
    }

    /**
      * 不写返回值，让编译器做类型推断
      *
      * @param parameter
      * @return
      */
    def sayHello(parameter: String) = {
        "["+ parameter + ", 你好!" +"]"
    }

    /**
      * 编译报错
      * 省略返回值类型，加入return关键字编译期会报异常
      *
      * @param param1
      * @param param2
      * @return
      */
    def method01(param1: String, param2: String) = {
        // 编译时报错
        /*return*/ "[" + param1 + "]" + ",[" + param2 + "]"
    }

    /**
      * 编译通过
      * 不省略返回值类型，加入return关键字编译期不会报异常
      *
      * @param param1
      * @param param2
      * @return
      */
    def method(param1: String, param2: String): String = {
        // 通过编译
        return "[" + param1 + "]" + ",[" + param2 + "]"
    }

    /**
      * 方法没有返回值
      * 省略声明没有返回值
      */
    def noReturn01(param1: String, param2: Double) {
        println("param1:" + param1 + ", param2:" + param2)
    }

    /**
      * 方法有返回值
      * 声明返回值类型
      */
    def return02(param1: String, param2: Double): Unit ={
        println("param1:" + param1 + ", param2:" + param2)
    }

    /**
      * 带有默认参数的方法
      * 不传参数将使用方法中的默认参数
      * 调用的时候可以指定赋值的参数
      * takeParameter(content = "张三")
      * takeParameter(left = "《《")
      * takeParameter(right = "》》")
      */
    def takeParameter(left: String = "<", content: String = "默认内容", right: String = ">"): String = {
        left + content + right
    }

    /**
      * 可变参数的方法（谨慎使用）
      */
    def multipleParameter(parameter: Int*): Int ={
        // 累加和的方法
        parameter.reduceRight(_+_)
    }

    // 没有参数列表的方法
    def noParameter = 100

    // 函数的定义

    /**
      * 定义函数
      */
    val f1 = (x: Int) => println(x)
    val f2 = (x: Int) => x + 4
    // 空参数的函数
    val f3 = () => 1000


}

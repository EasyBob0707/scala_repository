package com.scala.grammar

/**
  * 函数与方法的区别：
  *
  * 方法的定义
  *
  * Scala 函数以 def 定义，然后是函数的名称（如 max)，然后是以逗号分隔的参数。
  * Scala 中变量类型是放在参数和变量的后面，以“：”隔开。
  * 这种做的一个好处是便与 “type inference”。刚开始有些不习惯（如果你是 Pascal 程序员会觉的很亲切）。
  * 同样如果函数需要返回值，它的类型也是定义在参数的后面（实际上每个 Scala 函数都有返回值，
  * 只是有些返回值类型为 Unit，类似为 void 类型）。
  * 此外每个 Scala 表达式都有返回结果（这一点和 Java，C# 等语言不同），
  * 比如 Scala 的 if else 语句也是有返回值的，因此函数返回结果无需使用 return 语句。
  * 实际上在 Scala 代码应当尽量避免使用 return 语句。函数的最后一个表达式的值就可以作为函数的结果作为返回值。
  * 同样由于 Scala 的 “type inference” 特点，本例其实无需指定返回值的类型。
  * 对于大多数函数 Scala 都可以推测出函数返回值的类型，但目前来说回溯函数（函数调用自身）还是需要指明返回结果类型的。
  *
  * scala中不支持i++或者i--操作  可以用+=或者-=来代替这种类似的操作
  * scala访问数组的使用“()”而并非使用“[]” ，当然在指定泛型的时候使用“[]”而并非是“<>”(与java类比)
  *
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
        // 循环
        var i=0
        while (i < args.length) {
            println (args(i))
            i+=1
        }
        // 以上的循环可以改写为使用for或者foreach来实现
        // 用for实现
        for (x <- args) {
            println(x)
        }
        // 用foreach实现
        args.foreach(println)

        // 参数化数组(数组指定泛型)
        // []中指定数组中元素的类型，()指定数组的长度
        // 用val修饰数组长度是不可变的，但是数组的元素是可变的
        val greetStr: Array[String] = new Array[String](3)
        // 以下调用的是apply方法，对数组进行的初始化操作，但是注意并不是new，说明它不是class修饰的
        val array: Array[String] = Array[String]("hello","world","scala")
        // 在 Scala 中，数组和其它普遍的类定义一样，没有什么特别之处，当你在某个值后面使用（）时，Scala 将其翻译成对应对象的 apply 方法。
        // 因此本例中 greetStrings(1) 其实调用 greetString.apply(1) 方法。
        // 这种表达方法不仅仅只限于数组，对于任何对象，如果在其后面使用（）,都将调用该对象的 apply 方法。
        // 同样的如果对某个使用（）的对象赋值
        greetStr(0) = "hello"
        // 将这种赋值的操作可以转换为update方法
        // greetStr.update(0,"hello")
        greetStr(1) = "world"
        greetStr(2) = "scala"
        // 如果一个方法只有一个参数，你可以不用括号和.
        // 来调用这个方法。因此这里的 0 to 2, 其实为（0）.to(2) 调用的为整数类型的 to 方法，to 方法使用一个参数。
        for (z <- 0 to greetStr.length - 1) {
            println(greetStr(z))
        }
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

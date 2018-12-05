package com.scala.grammar

/**
  * 所有的类都继承自 Any，因此 Scala 中的对象都可以使用==,!=,或 equals 来比较，使用##或 hashCode 给出 hash 值，使用 toString 转为字符串。
  * Any 的==和!=定位为 fianl，因此不可以被子类重载。==实际上和 equals 等价，!=和 equals 的否定形式等价，因此重载 equals 可以修改==和!=的定义。
  * 根类 Any 有两个子类：AnyVal 和 AnyRef。AnyVal 是 Scala 里每个内建值类型的父类。
  * 有九个这样的值类型：Byte，Short，Char，Int，Long，Float，Double，Boolean 和 Unit。
  * 其中的前八个对应到 Java 的基本数值类型，它们的值在运行时表示成 Java 的类型。
  * Scala 里这些类的实例都写成字面量。例如，42 是 Int 的实例，’x’是 Char 的实例，false 是 Boolean 的实例。
  * 值类型都被定义为即是抽象的又是 final 的，你不能使用 new 创造这些类的实例。
  * error: class Int is abstract; cannot be instantiated
  *        new Int
  *
  * 另一个值类，Unit，大约对应于 Java 的 void 类型；被用作不返回任何有趣结果的方法的结果类型。 Unit 只有一个实例值，被写作().
  * Scala 的值类型之间的关系是扁平的，所有的值类都是 scala.AnyVal 的子类型，但是它们不是互相的子类。代之以它们不同的值类类型之间可以隐式地互相转换。
  * 方法 min，max，until，to 和 abs 都定义在类 scala.runtime.RichInt 里，并且有一个从类 Int 到 RichInt 的隐式转换。
  * 当你在 Int 上调用没有定义在 Int 上但定义在 RichInt 上的方法时，这个转换就被应用了。
  * 类 Any 的另一个子类是类 AnyRef。这个是 Scala 里所有引用类的基类。
  * 正如前面提到的，在 Java 平台上 AnyRef 实际就是类 java.lang.Object 的别名。
  * 因此 Java 里写的类和 Scala 里写的都继承自 AnyRef。如此说来，你可以认为 java.lang.Object 是 Java 平台上实现 AnyRef 的方式。
  * 因此，尽管你可以在 Java 平台上的 Scala 程序里交换使用 Object 和 AnyRef，推荐的风格是在任何地方都只使用 AnyRef。
  *
  * Scala 定义了两种类型的变量 val 和 var，val 类似于 Java 中的 final 变量，
  * 一旦初始化之后，不可以重新复制（我们可以称它为常变量）。
  * 而 var 类似于一般的非 final 变量。可以任意重新赋值。
  *
  * scala> val msg="Hello,World"
  * msg: String = Hello,World
  *
  * 这个表达式定义了一个 msg 变量，为字符串常量。它的类型为 string (java.lang.string)。
  * 可以看到我们在定义这个变量时并不需要像 Java 一样定义其类型，Scala 可以根据赋值的内容推算出变量的类型。
  * 这在 Scala 语言中成为 “type inference”。
  * 当然如果你愿意，你也可以采用和 Java 一样的方法，明确指定变量的类型，如
  *
  * scala> val msg2:String ="Hello again,world"
  * msg2: String = Hello again,world
  *
  * 如果用_初始化数据，必须指定其数据类型，因为scala在推测数据类型的时候就是依照其数据来进行推测的
  * 但是此处的_赋值是根据不同的数据类型初始化不同的数据，虽然可以通过编译，但是运行的时候报异常
  * var sum = _
  *
  * 注：在scala中不需要用“;”结尾，如果多条语句在一行实现，那么此时必须用“;”隔开
  * scala的宗旨：能简单尽量简单，能少敲代码尽量少敲
  *
  */
object ScalaGrammar {

    // 定义常量或者变量可以指定其声明的类型，当然也可以不声明，不声明scala会对声明常量或者变量进行类型推断
    // val是定义常量的，而var是定义变量的
    // 定义未指定类型的常量
    val str = "hello world"
    // 定义指定类型的常量
    val str01: String = "hello scala"

    // 定义未指定类型的变量
    var str02: String = "hello scala01"
    // 定义指定类型的变量
    var str03: String = "hello scala02"

    // 开启scala学习之旅
    def main(args: Array[String]): Unit = {
        println("开启Scala学习之旅!")
        // 默认值输出
        val students = new Students("李四", 33)
        println(students.name)
    }

}

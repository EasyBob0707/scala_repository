package com.scala.grammar

/**
  * scala中的标志符
  * Scala 可以使用两种形式的标志符，字符数字和符号。
  * 字符数字使用字母或是下划线开头，后面可以接字母或是数字，符号”$”在 Scala 中也看作为字母。
  * 然而以“$”开头的标识符为保留的 Scala 编译器产生的标志符使用，应用程序应该避免使用“$”开始的标识符，以免造成冲突。
  * Scala 的命名规则采用和 Java 类似的 camel 命名规则，首字符小写，比如 toString。类名的首字符还是使用大写。
  * 此外也应该避免使用以下划线结尾的标志符以避免冲突。符号标志符包含一个或多个符号，如+，:，? 等，比如:
  *
  * + ++ ::: < ?> :->
  *
  * Scala 内部实现时会使用转义的标志符，比如:-> 使用 $colon$minus$greater 来表示这个符号。
  * 因此如果你需要在 Java 代码中访问:->方法，你需要使用 Scala 的内部名称 $colon$minus$greater。
  *
  * 混合标志符由字符数字标志符后面跟着一个或多个符号组成，比如 unary_+ 为 Scala 对+方法的内部实现时的名称。
  * 字面量标志符为使用“定义的字符串，比如 `x` `yield`。
  * 你可以在“之间使用任何有效的 Scala 标志符，Scala 将它们解释为一个 Scala 标志符，一个典型的使用为 Thread 的 yield 方法，
  * 在 Scala 中你不能使用 Thread.yield()是因为 yield 为 Scala 中的关键字， 你必须使用 Thread.`yield`()来使用这个方法。
  */
class Designator {

}

package com.scala.scala_trait

/**
  * 这个 Trait 名为 Philosophical。它没有声明基类，因此和类一样，有个缺省的基类 AnyRef。
  * 它定义了一个方法，叫做 philosophize。这是个简单的 Trait，仅够说明 Trait 如何工作。
  * 一但定义好 Trait，它就可以用来和一个类混合，这可以使用 extends 或 with 来混合一个 trait。
  *
  * Trait 就像是带有具体方法的 Java 接口，不过其实它能做的更多。Trait 可以，比方说，声明字段和维持状态值。
  * 实际上，你可以用 Trait 定义做任何用类定义做的事，并且语法也是一样的，除了两点。第一点，Trait 不能有任何“类”参数，也就是说，传递给类的主构造器的参数。
  */
class Frog extends Animal with Philosophical with HasLegs {
    override def toString="green"
    override def philosophize() {
        println("It ain't easy being " + toString + "!")
    }
}


object Frog {

    def main(args: Array[String]): Unit = {
        new Frog().philosophize
    }

}

package com.scala.scala_trait

/**
  * 在 Scala中Trait 为重用代码的一个基本单位。一个 Traits 封装了方法和变量，和 Interface 相比，它的方法可以有实现，这一点有点和抽象类定义类似。
  * 但和类继承不同的是，Scala 中类继承为单一继承，也就是说子类只能有一个父类。当一个类可以和多个 Trait 混合，
  * 这些 Trait 定义的成员变量和方法也就变成了该类的成员变量和方法，由此可以看出 Trait 集合了 Interface 和抽象类的优点，同时又没有破坏单一继承的原则。
  *
  *
  */
trait Philosophical{

    def philosophize() {
        println("I consume memeory, therefor I am!")
    }

}

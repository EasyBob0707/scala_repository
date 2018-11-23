package com.scala.grammar

import java.util.UUID

/**
  * 在scala中的祖先类是Any
  * Any其中包含了AnyVal和AnyRef两部分构成的
  * 在scala中， 用class修饰的类可以定义主构造器以及辅助构造器
  * 用object修饰的类相当于java中的定义的静态属性，没有构造器
  *
  *
  * 主构造器：
  *     定义在类后面的构造器叫做主构造器
  *     定义在类内部的构造器叫做辅构造器
  *
  * 注意：
  *     在主构造器重定义的参数列表（参数属性）没有必要在类体中再次定义（如果定义那么变量名称不能与类体中的属性名称一致）
  *     在主构造器中定义的参数如果没有用val或者var修饰——是没有提供获取值和修改值的方法的（类比于java中的getter/setter方法，可以
  *     反编译class文件证实这一点）
  *
  *     1、如果用val修饰的参数不提供修改的方法（因为val修饰的参数意味着参数一经赋值是没有办法再改变的）
  *     2、如果用var修饰的参数提供修改和获取的方法
  *     获取参数值的方法名称与参数名称一致， 当然修改参数的值直接用赋值符号（=）
  *     如： stu.name     stu.name = "xxx"
  *     3、辅助构造器要调用主构造器
  *     4、在类名称的后面加 private 关键字， 该关键字是修饰主构造器的
  *     5、在 class 关键字前加 private 关键字， 该关键字是修饰这整个类的
  *     6、如果一个类用 private 关键字修饰， 还可以在关键字的后面加中括号里面指明该类的使用范围
  *     如：private[grammar] class Students private (name: String)
  *     7、在同一个文件当中可以定义两个同名的类， 修饰他们的关键字分别是 class 和 object
  *     在scala中没有“static”关键字，用object定义的类中的成员就可以直接访问  类名.属性名  类名.方法名
  *     如：实现scala中的单例模式
  *     8、当一个类中所有能用 private 关键字修饰的地方， 都用 private 修饰， 那么只有被 object 修饰的同名类名才可以访问（其他地方要想访问要看修饰类的私有化指定的位置）
  *     9、循环中的单个参数是用的val修饰的
  *     如：for (arr <- arrays) {
  *         // 伪代码
  *         ......
  *     }
  *     上述的arr就是用val进行修饰的，否则后一个数值将会把前一个数值覆盖掉
  *
  */
private[grammar] class Students private (var name: String) {

    var age: Int = _

    /**
      * 辅助构造器
      *
      * @param name     学生姓名
      * @param age      学生年龄
      */
    def this(name: String, age: Int) = {
        this(name)
        this.age = age
    }

    def sayHello(name: String): Unit = {
        println(s"跟$name 同学打招呼, 你好!")
    }

}

object Students {

    var id: UUID = _

    def main(args: Array[String]): Unit = {
        val students = new Students("张三")
        println(students.name)
    }
}

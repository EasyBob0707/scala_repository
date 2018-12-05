package com.scala.combination_extends

/**
  * 你在定义类时没有使用 extends 关键字，在 Scala 中这个定义类缺省继承自 scala.AnyRef，如同在 Java 中缺省继承自 java.lang.Object。
  */
abstract class Element {
    // 抽象方法
    def contents: Array[String]
    def height: Int = contents.length
    def width: Int = if (height == 0) 0 else contents(0).length
    // Scala 代码可以调用 Java 函数和类，而 Java 没有使用“统一访问原则”，因此 Java 里是 string.length()，不是 string.length。
    // 为了解决这个问题，Scala 对于无参数函数和空括号函数的使用上并不是区分得很严格。也就是，你可以用空括号方法重载无参数方法，并且反之亦可。
    // 你还可以在调用任何不带参数的方法时省略空的括号。
    // 总结起来，Scala 里定义不带参数也没有副作用的方法为无参数方法，也就是说，省略空的括号，是鼓励的风格。
    // 另一方面，永远不要定义没有括号的带副作用的方法，因为那样的话方法调用看上去会像选择一个字段。
    // val height: Int = contents.length
    // val width: Int = if (height == 0) 0 else contents(0).length
    def above(that: Element): Element = {
        new ArrayElement(this.contents ++ that.contents)
    }
    def beside(that: Element): Element = {
        val contents = new Array[String](this.contents.length)
        for(i <- 0 until this.contents.length)
            contents(i)=this.contents(i) + that.contents(i)
        new ArrayElement(contents)
    }
    def beside02(that: Element): Element = {
        new ArrayElement(
            for(
                (line1,line2) <- this.contents zip that.contents
            ) yield line1+line2
        )
    }
    override def toString = contents mkString "\n"
    def widen(w: Int): Element =
        if (w <= width) this
        else {
            val left = Element.elem(' ', (w - width) / 2, height)
            var right = Element.elem(' ', w - width - left.width, height)
            left beside this beside right
        }
    def heighten(h: Int): Element =
        if (h <= height) this
        else {
            val top = Element.elem(' ', width, (h - height) / 2)
            var bot = Element.elem(' ', width, h - height - top.height)
            top above this above bot
        }
    def demo(): Unit = {
        println("this is Element")
    }
}

object Element {
    private class ArrayElement(val contents: Array[String])
            extends Element {
    }
    private class LineElement(s:String) extends ArrayElement(Array(s)) {
        override def width = s.length
        override def height = 1
    }
    private class UniformElement (ch :Char,
                                  override val width:Int,
                                  override val height:Int
                                 ) extends Element{
        private val line=ch.toString * width
        def contents = Array.fill(height)(line)
    }
    def elem(contents: Array[String]):Element =
        new ArrayElement(contents)
    def elem(chr:Char, width:Int, height:Int) :Element =
        new UniformElement(chr,width,height)
    def elem(line:String) :Element =
        new LineElement(line)
}


package chapter10

import chapter10.Element.elem

abstract class Element {
  def contents: Array[String]
  def height: Int = contents.length
  def width: Int = if (height == 0) 0 else contents(0).length

  def above(that: Element): Element = {
    val this1 = this widen that.width
    val that1 = that widen this.width

    elem(this1.contents ++ that1.contents)
  }

  def beside(that: Element): Element = {
    val this1 = this heighten that.height
    val that1 = that heighten this.height

    elem(
      for(
        (line1, line2) <- this1.contents zip that1.contents
      ) yield line1 + line2
    )
  }

  private def widen(w: Int): Element =
    if(w <= width) this
    else {
      val left: Element.UniformElement = elem(' ', (w - width) / 2, height)
      val right: Element.UniformElement = elem(' ', w - width - left.width, height)
      left beside this beside right
    }

  private def heighten(h: Int): Element =
    if(h <= height) this
    else {
      val top = elem(' ', width, (h - height) / 2)
      val bot = elem(' ', width, h - height - top.height)
      top above this above bot
    }

  override def toString: String = contents mkString "\n"
}

object Element {
  private class ArrayElement(val contents: Array[String]) extends Element

  private class LineElement(s: String) extends Element {
    override def width: Int = s.length
    override def height: Int = 1
    override def contents: Array[String] = Array(s)
  }

  private class UniformElement(ch: Char,
                               override val width: Int,
                               override val height: Int) extends Element {
    private val line = ch.toString * width
    override def contents: Array[String] = Array.fill(height)(line)
  }

  def elem(contents: Array[String]): ArrayElement =
    new ArrayElement(contents)

  def elem(chr: Char, width: Int, height: Int): UniformElement =
    new UniformElement(chr, width, height)

  def elem(line: String): LineElement =
    new LineElement(line)
}
package chapter23

import java.util
import scala.collection.convert.ImplicitConversions.`collection AsScalaIterable`

// Abstract class C would then use the FilterWrapper in its withFilter method:
abstract class C[A] extends util.AbstractCollection[A] {
  def map[B](f: A => B): C[B]
  def flatMap[B](f: A => C[B]): C[B]
  def withFilter(p: A => Boolean): FilterWrapper[A] = new FilterWrapper(this.toList, p)
  def foreach(f: A => Unit): Unit
  // toList is a hypothetical method that returns the collection as a List
}
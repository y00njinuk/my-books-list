package chapter23

class FilterWrapper[A](collection: List[A], predicate: A => Boolean) {
  def map[B](f: A => B): List[B] = {
    collection.flatMap(a => if (predicate(a)) Some(f(a)) else None)
  }

  def flatMap[B](f: A => List[B]): List[B] = {
    collection.flatMap(a => if (predicate(a)) f(a) else List.empty)
  }

  def foreach(f: A => Unit): Unit = {
    collection.foreach(a => if (predicate(a)) f(a))
  }
}

object FilterWrapper {
  def main(args: Array[String]): Unit = {
    // Usage example
    val numbers = List(1, 2, 3, 4, 5)
    val evenNumbers = for {
      n <- numbers
      if n % 2 == 0
    } yield n

    println(evenNumbers)
  }
}

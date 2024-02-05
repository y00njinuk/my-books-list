package chapter19

class SlowAppendQueue[T](elems: List[T]) {
  def head: T = elems.head  // O(1)
  def tail: SlowAppendQueue[T] = new SlowAppendQueue(elems.tail) // O(1)
  def enqueue(x: T) = new SlowAppendQueue(elems ::: List(x)) // O(n)
}

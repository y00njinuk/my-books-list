package chapter19

class SlowHeadQueue[T](smele: List[T]) {
  def head: T = smele.last // O(n)
  def tail: SlowHeadQueue[T] = new SlowHeadQueue(smele.init) // O(n)
  def enqueue(x: T): SlowHeadQueue[T] = new SlowHeadQueue(x :: smele) // O(1)
}

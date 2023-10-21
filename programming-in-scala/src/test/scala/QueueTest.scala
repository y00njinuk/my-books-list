import chapter12.{BasicIntQueue, Doubling, Filtering, Incrementing}
import org.scalatest.flatspec.AnyFlatSpec

class QueueTest extends AnyFlatSpec {
  "Queue mixin Doubling" should "put doubled value" in {
    val queue = new BasicIntQueue with Doubling
    val element = 10
    queue.put(element)

    assert(queue.get() == element * 2)
  }

  "Queue mixin Incrementing and Filtering" should "put filtered and incremented value" in {
    // call method : Filtering -> Incrementing -> BasicIntQueue
    val queue = new BasicIntQueue with Incrementing with Filtering
    val list = List(-1, 0, 1)

    list.foreach(queue.put)

    // -1 is filtered in Filtering.
    assert(queue.get() == list(1) + 1) // 0
    assert(queue.get() == list(2) + 1) // 1
  }
}

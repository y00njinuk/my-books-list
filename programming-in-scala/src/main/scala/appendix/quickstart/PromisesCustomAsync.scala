package appendix.quickstart

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, ExecutionContext, Future, Promise}
import scala.util.control.NonFatal

object PromisesCustomAsync {
  def main(args: Array[String]): Unit = {
    def myFuture[T](b: => T): Future[T] = {
      val p = Promise[T]
      ExecutionContext.global.execute(() =>
        try {
          p.success(b)
        } catch {
          case NonFatal(e) => p.failure(e)
        })
      p.future
    }
    val f = myFuture { "naa" + "na" * 8 + " Katamari Damacy!"}

    f foreach { case text: String =>
      println(text)
    }
  }
}

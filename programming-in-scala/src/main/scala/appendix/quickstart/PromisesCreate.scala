package appendix.quickstart

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Promise

object PromisesCreate {
  def main(args: Array[String]): Unit = {
    val p = Promise[String]
    val q = Promise[String]

    p.future foreach { case x => println(s"p succeeded with '$x'") }

    Thread.sleep(3000)

    p.success("assigned")
    q.failure(new Exception("not kept"))

    q.future.failed foreach { case t => println(s"q failed with '$t'")}

    Thread.sleep(3000)
  }
}

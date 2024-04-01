package appendix

import com.twitter.finagle.{Http, Service}
import com.twitter.finagle.http.{Request, RequestBuilder, Response}
import com.twitter.util.{Await, Future, FuturePool}
import org.scalatest.flatspec.AnyFlatSpec

class FinagleClientTest extends AnyFlatSpec {
  trait Client {
    val httpClient: Service[Request, Response]
    var count: Int = 0

    def request(count: Int): Future[Unit] = {
      httpClient {
        RequestBuilder()
          .url("http://localhost:80")
          .buildGet()
      }.flatMap { response =>
        val content = response.getLength()
        val status = response.status

        println(s"--- ($count) $status $content")
        println(s"--- call($count): " + Thread.currentThread().getId)

        this.count += 1
        Future.Done
      }
    }
  }

  def case1(client: Client): Unit = {
    Await.result {
      client.request(1).map { _: Unit =>
        Thread.sleep(3000)
        Await.result(client.request(2))
      }
    }
  }

  def case2(client: Client): Unit = {
    Await.result {
      client.request(1).flatMap { _: Unit =>
        Thread.sleep(3000)
        Await.result(client.request(2))
        Future.Done
      }
    }
  }

  "testClient" should "have blocking issue in case1 and case2" in {
    val testClient: Client = new Client {
      override val httpClient: Service[Request, Response] = Http.client.newService("localhost:80")
    }

    println("start")
    case1(testClient) // blocking
    println("end")

    println("start")
    case2(testClient) // blocking
    println("end")
  }

  "testClient" should "has not blocking issue in case1 and case2" in {
    val testClient = new Client {
      override val httpClient: Service[Request, Response] = Http
        .client
        .withExecutionOffloaded(FuturePool.unboundedPool)
        .newService("localhost:80")
    }

    println("start")
    case1(testClient)
    println("end")

    println("start")
    case2(testClient)
    println("end")
  }
}

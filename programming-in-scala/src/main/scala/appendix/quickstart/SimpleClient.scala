package appendix.quickstart

import com.twitter.finagle.http.Response
import com.twitter.finagle.{Http, Service, http}
import com.twitter.util.Await

object SimpleClient {
  def main(args: Array[String]): Unit = {
    val client: Service[http.Request, http.Response] = Http.newService("localhost:8080")
    val request = http.Request(http.Method.Get, "/")

    request.host = "localhost"
    val response = client(request)

    // SimpleService need to be started.
    Await.result (response.onSuccess((rep: Response) => println("GET success: " + rep)))
    Thread.sleep(3000) // wait 3 seconds for print result
  }
}

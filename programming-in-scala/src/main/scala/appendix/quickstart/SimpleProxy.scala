package appendix.quickstart

import com.twitter.finagle.http.{Request, Response}
import com.twitter.finagle.{Http, Service}
import com.twitter.util.Await

object SimpleProxy {
  val client: Service[Request, Response] = Http.newService("localhost:80")
  val server = Http.serve(":8080", client)
  Await.ready(server)
}

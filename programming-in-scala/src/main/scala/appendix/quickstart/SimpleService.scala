package appendix.quickstart

import com.twitter.finagle.http.{Request, Response}
import com.twitter.finagle.{Service, http}
import com.twitter.util.Future

class SimpleService {
  val service = new Service[http.Request, http.Response] {
    override def apply(request: Request): Future[Response] =
      Future.value(
        http.Response(request.version, http.Status.Ok)
      )
  }
}
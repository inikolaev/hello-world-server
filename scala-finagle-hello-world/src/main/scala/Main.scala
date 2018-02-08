import com.twitter.finagle.{Http, Service}
import com.twitter.finagle.http.{Request, Response, Status}
import com.twitter.util.{Await, Future}
import com.typesafe.config.ConfigFactory

object Main extends App {
  val config = ConfigFactory.load()

  val service = new Service[Request, Response] {
    def apply(req: Request): Future[Response] = {
      val res = Response(req.version, Status.Ok)
      res.contentType = "text/plain"
      res.contentString = "Hello, World!"
      Future.value(res)
    }
  }

  val server = Http.serve(s"${config.getString("http.address")}:${config.getInt("http.port")}", service)

  Await.ready(server)
}

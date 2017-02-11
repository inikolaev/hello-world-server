import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.typesafe.config.ConfigFactory
import akka.http.scaladsl.server.Directives._


object Main {
  implicit val system = ActorSystem()
  implicit val executor = system.dispatcher
  implicit val materializer = ActorMaterializer()

  def main(args: Array[String]): Unit = {
    val config = ConfigFactory.load()
  
    val routes =
      get {
        pathSingleSlash {
          complete {
            "Hello, World!"
          }
        }
      }
  
    Http().bindAndHandle(routes, config.getString("http.address"), config.getInt("http.port"))
  }
}

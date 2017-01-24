package xlx

import scalaz.concurrent.Task

import org.http4s.server.blaze._
import org.http4s.server.{Server, ServerApp}

object Main extends ServerApp {
  override def server(args: List[String]): Task[Server] = {
    BlazeBuilder
      .bindHttp(9503, "localhost")
      .mountService(Users.service, "/")
      .start
  }
}


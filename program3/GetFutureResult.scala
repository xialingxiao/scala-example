import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{ Await, Future }

object GetFutureResult {
  def main(args: Array[String]): Unit = {
    var result = 0
    val f2: Future[Unit] = Future {
        Thread.sleep(1000)
        result = 1+1
    }
    println("Started async process")
    println("Current value: " +result)
    println("Doing something else ...")
    Await.ready(f2, Duration.Inf)
    println("Updated value after process completes: "+result)
  }
}

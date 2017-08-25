import sys.process._
import java.net.URL
import java.io.File

import Data.arr
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives.{complete, get, parameters, path}
import akka.stream.ActorMaterializer
import com.google.gson.Gson

import scala.collection.mutable.ListBuffer
import scala.io.StdIn

object Main {

  var dataCount = 0

  def run(): Unit = {
    // Create MyUrl object instance
    val myURL = new MyURL

    // Get URL
    val url: String = myURL.getURLFromGDELT()

    // Debugging
    println("[DEBUG]:" + url)

    // Get data from URL
    new URL(url) #> new File("zip/data" + dataCount + ".zip") !!

    // Create ZipArchive object instance
    val zipArchive = new ZipArchive

    // Unzip the data into "data" folder under project directory
    zipArchive.unZip("zip/data" + dataCount + ".zip", "data")

    dataCount += 1
  }

  def main(args: Array[String]) {
    // "Hello, World!!" example
    println("Hello, World!!")

    // Timer
    val t = new java.util.Timer()

    // Task creater
    val task = new java.util.TimerTask {
      override def run(): Unit = getData()
    }

    // Submit the task
    t.schedule(task, 1000L, 60 * 15 * 1000L)


    implicit val system = ActorSystem("my-system")
    implicit val materializer = ActorMaterializer()
    // needed for the future flatMap/onComplete in the end
    implicit val executionContext = system.dispatcher
    val data = new Data("20170821114500.gkg.csv")
    val gson = new Gson()
    val route =
      path("hello") {
        get {
          parameters('queryType, 'query) { (queryType, query) => {
            arr = new ListBuffer[String]()
            data.demo(queryType, query)
            complete(HttpEntity(ContentTypes.`application/json`, gson.toJson(arr.toArray)))
          }
          }
        }
      }

    val bindingFuture = Http().bindAndHandle(route, "localhost", 8080)

    println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
    StdIn.readLine() // let it run until user presses return
    bindingFuture
      .flatMap(_.unbind()) // trigger unbinding from the port
      .onComplete(_ => system.terminate()) // and shutdown when done


  }
}


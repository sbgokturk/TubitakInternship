import sys.process._
import java.net.URL
import java.io.File

object Main {

  var dataCount = 0

  def getData(): Unit = {
    // Create MyUrl object instance
    val myURL = new MyURL

    // Get URL
    val url: String = myURL.getURLFromGDELT()

    // Debugging
    println("[DEBUG]:"+url)

    // Get data from URL
    new URL(url) #> new File("../../../zip/data" + dataCount + ".zip") !!

    // Create ZipArchive object instance
    val zipArchive = new ZipArchive

    // Unzip the data into "data" folder under project directory
    zipArchive.unZip("../../../zip/data" + dataCount + ".zip","../../../data")

    dataCount += 1
  }

  def main(args:Array[String]){
    // "Hello, World!!" example
    println("Hello, World!!")

    // Timer
    val t = new java.util.Timer()

    // Task creater
    val task = new java.util.TimerTask {
      override def run(): Unit = getData()
    }

    // Submit the task
    t.schedule(task,1000L,60*15*1000L)
  }
}


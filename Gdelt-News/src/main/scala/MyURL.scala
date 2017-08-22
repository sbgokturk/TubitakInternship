import java.net._
import java.io._
import scala.collection.mutable.ArrayBuffer
import scala.util.matching.Regex

class MyURL {
  def getURLFromGDELT(): String = {
    val url = new URL("http://data.gdeltproject.org/gdeltv2/lastupdate.txt")
    val in = new BufferedReader(new InputStreamReader(url.openStream))
    val buffer = new Array[String](3)
    var inputLine = in.readLine
    var i : Int = 0

    while (inputLine != null) {
      if (!inputLine.trim.equals("")) {
        buffer(i)= inputLine.trim
      }
      inputLine = in.readLine
      i += 1
    }
    in.close

    val pattern = new Regex("http://(.*).gkg.csv.zip")

    val str = buffer(2)

    return (pattern findAllIn str).mkString
  }
}


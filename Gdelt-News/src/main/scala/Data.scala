import org.apache.spark.sql.{Row, SparkSession}

class Data(fileName: String) {

  val spark = SparkSession
    .builder()
    .appName("Spark SQL basic example")
    .config("spark.master", "local[*]")
    .config("spark.driver.allowMultipleContexts", "true")
    .getOrCreate()


  val dataReader = new DataReader;
  val df = dataReader.importData(fileName, dataReader.SCHEMA_GKG)

  def demo(): Unit = {
    df.filter("LOWER(V1PERSONS) LIKE LOWER('%MERKEL%')").foreach(row => Main2.parseRow(row))
    //df.select("V2.1COUNTS").show(10)
    //df.foreach(row => println(row(5)))
  }


}

object Main2 {
  def main(args: Array[String]): Unit = {
    val data = new Data("20170821114500.gkg.csv");
    data.demo()
  }

  def parseRow(row: Row): Unit = {

    var date: myDate = new myDate
    var sourceName: String = ""
    var documentIdent: String = ""
    var counts1: Array[Count] = new Array[Count](1)
    var counts2: Array[Count] = new Array[Count](1)
    var themes1: Array[String] = new Array[String](1)
    var themes2: Array[String] = new Array[String](1)
    var locations1: Array[Location] = new Array[Location](1)

    var locations2: Array[Location] = new Array[Location](1)
    var persons1: Array[String] = new Array[String](1)
    var persons2: Array[String] = new Array[String](1)
    var organizations1: Array[String] = new Array[String](1)
    var organizations2: Array[String] = new Array[String](1)
    var tone: Tone = new Tone
    var gcam: Array[String] = new Array[String](1)
    var image: String = ""
    var relatedImages: Array[String] = new Array[String](1)
    var socialImages: Array[String] = new Array[String](1)
    var socialVideos: Array[String] = new Array[String](1)

    if (row(1) != null) {
      date = myDate.parseDate(row(1).asInstanceOf[String])
    }

    if (row(3) != null) {
      sourceName = row(3).asInstanceOf[String]
    }

    if (row(4) != null) {
      documentIdent = row(4).asInstanceOf[String]
    }

    if (row(5) != null) {
      counts1 = Count.parseCounts(row(5).asInstanceOf[String])
    }

    if (row(6) != null) {
      counts2 = Count.parseCounts(row(6).asInstanceOf[String])
    }

    if (row(7) != null) {
      themes1 = row(7).asInstanceOf[String].split(";")
    }

    if (row(8) != null) {
      themes2 = row(8).asInstanceOf[String].split(";")
    }

    if (row(9) != null) {
      locations1 = Location.parseLocation1(row(9).asInstanceOf[String])
    }

    if (row(10) != null) {
      locations2 = Location.parseLocation2(row(10).asInstanceOf[String])
    }

    if (row(11) != null) {
      persons1 = row(11).asInstanceOf[String].split(";")
    }

    if (row(12) != null) {
      persons2 = row(12).asInstanceOf[String].split(";")
    }

    if (row(13) != null) {
      organizations1 = row(13).asInstanceOf[String].split(";")
    }

    if (row(14) != null) {
      organizations2 = row(14).asInstanceOf[String].split(";")
    }

    if (row(15) != null) {
      tone = Tone.parseTone(row(15).asInstanceOf[String])
    }

    if (row(17) != null) {
      gcam = row(17).asInstanceOf[String].split(",")
    }

    if (row(18) != null) {
      image = row(18).asInstanceOf[String]
    }

    if (row(19) != null) {
      relatedImages = row(19).asInstanceOf[String].split(";")
    }

    if (row(20) != null) {
      socialImages = row(20).asInstanceOf[String].split(";")
    }

    if (row(21) != null) {
      socialVideos = row(21).asInstanceOf[String].split(";")
    }

    var myNew = new New(date, sourceName, documentIdent, counts1, counts2, themes1, themes2, locations1,
      locations2, persons1, persons2, organizations1, organizations2, tone, gcam, image, relatedImages,
      socialImages, socialVideos)

    println(myNew)

  }
}

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
    df.foreach(row => Main2.parseRow(row))
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
    if (row(1) != null) {
      val date: myDate = myDate.parseDate(row(1).asInstanceOf[String])
      println(date)
      println(date)
    }

    if (row(5) != null) {
      val counts: Array[Count] = Count.parseCounts(row(5).asInstanceOf[String])
      for (count <- counts) {
        println(count)
      }
    }
  }
}

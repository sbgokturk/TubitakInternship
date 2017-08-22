import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.{DataFrame, Row, SQLContext, SparkSession}
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.types._


class DataReader {

  // GDELT GKG data schema
  val SCHEMA_GKG = StructType(
    StructField("GKGRECORDID", StringType, true) ::
      StructField("V2.1DATE", StringType, true) ::
      StructField("V2SOURCECOLLECTIONIDENTIFIER", IntegerType, true) ::
      StructField("V2SOURCECOMMONNAME", StringType, true) ::
      StructField("V2DOCUMENTIDENTIFIER", StringType, true) ::
      StructField("V1COUNTS", StringType, true) ::
      StructField("V2.1COUNTS", StringType, true) ::
      StructField("V1THEMES", StringType, true) ::
      StructField("V2ENHANCEDTHEMES", StringType, true) ::
      StructField("V1LOCATIONS", StringType, true) ::
      StructField("V2ENHANCEDLOCATIONS", StringType, true) ::
      StructField("V1PERSONS", StringType, true) ::
      StructField("V2ENHANCEDPERSONS", StringType, true) ::
      StructField("V1ORGANIZATIONS", StringType, true) ::
      StructField("V2ENHANCEDORGANIZATIONS", StringType, true) ::
      StructField("V1.5TONE", StringType, true) ::
      StructField("V2.1ENHANCEDDATES", StringType, true) ::
      StructField("V2GCAM", StringType, true) ::
      StructField("V2.1SHARINGIMAGE", StringType, true) ::
      StructField("V2.1RELATEDIMAGES", StringType, true) ::
      StructField("V2.1SOCIALIMAGEEMBEDS", StringType, true) ::
      StructField("V2.1SOCIALVIDEOEMBEDS", StringType, true) ::
      StructField("V2.1QUOTATIONS", StringType, true) ::
      StructField("V2.1ALLNAMES", StringType, true) ::
      StructField("V2.1AMOUNTS", StringType, true) ::
      StructField("V2.1TRANSLATIONINFO", StringType, true) ::
      StructField("V2EXTRASXML", StringType, true) :: Nil)

  val SCHEMA_EVENTS = StructType(
    StructField("GlobalEventID",IntegerType,true)::
      StructField("Day",IntegerType,true)::
      StructField("MonthYear",IntegerType,true)::
      StructField("Year",IntegerType,true)::
      StructField("FractionDate",FloatType,true)::
      StructField("Actor1Code",StringType,true)::
      StructField("Actor1Name",StringType,true)::
      StructField("Actor1CountryCode",StringType,true)::
      StructField("Actor1KnownGroupCode",StringType,true)::
      StructField("Actor1EthnicCode",StringType,true)::
      StructField("Actor1Religion1Code",StringType,true)::
      StructField("Actor1Religion2Code",StringType,true)::
      StructField("Actor1Type1Code",StringType,true)::
      StructField("Actor1Type2Code",StringType,true)::
      StructField("Actor1Type3Code",StringType,true)::
      StructField("Actor2Code",StringType,true)::
      StructField("Actor2Name",StringType,true)::
      StructField("Actor2CountryCode",StringType,true)::
      StructField("Actor2KnownGroupCode",StringType,true)::
      StructField("Actor2EthnicCode",StringType,true)::
      StructField("Actor2Religion1Code",StringType,true)::
      StructField("Actor2Religion2Code",StringType,true)::
      StructField("Actor2Type1Code",StringType,true)::
      StructField("Actor2Type2Code",StringType,true)::
      StructField("Actor2Type3Code",StringType,true)::
      StructField("IsRootEvent",IntegerType,true)::
      StructField("EventCode",StringType,true)::
      StructField("EventBaseCode",StringType,true)::
      StructField("EventRootCode",StringType,true)::
      StructField("QuadClass",IntegerType,true)::
      StructField("GoldsteinScale",FloatType,true)::
      StructField("NumMentions",IntegerType,true)::
      StructField("NumSources",IntegerType,true)::
      StructField("NumArticles",IntegerType,true)::
      StructField("AvgTone",FloatType,true)::
      StructField("Actor1Geo_Type",IntegerType,true)::
      StructField("Actor1Geo_Fullname",StringType,true)::
      StructField("Actor1Geo_CountryCode",StringType,true)::
      StructField("Actor1Geo_ADM1Code",StringType,true)::
      StructField("Actor1Geo_ADM2Code",StringType,true)::
      StructField("Actor1Geo_Lat",FloatType,true)::
      StructField("Actor1Geo_Long",FloatType,true)::
      StructField("Actor1Geo_FeatureID",StringType,true)::
      StructField("Actor2Geo_Type",IntegerType,true)::
      StructField("Actor2Geo_Fullname",StringType,true)::
      StructField("Actor2Geo_CountryCode",StringType,true)::
      StructField("Actor2Geo_ADM1Code",StringType,true)::
      StructField("Actor2Geo_ADM2Code",StringType,true)::
      StructField("Actor2Geo_Lat",FloatType,true)::
      StructField("Actor2Geo_Long",FloatType,true)::
      StructField("Actor2Geo_FeatureID",StringType,true)::
      StructField("DATEADDED",IntegerType,true)::
      StructField("SOURCEURL",StringType,true)::Nil
  )

  def importData(fileName: String,schema: StructType): org.apache.spark.sql.DataFrame = {

    val conf = new SparkConf().set("spark.driver.allowMultipleContexts","true").setAppName("DataReader").setMaster("local[*]")
    val sc = new SparkContext(conf)

    val sqlContext = new SQLContext(sc)

    val df = sqlContext.read
      .format("com.databricks.spark.csv")
      .option("header", "false")
      .option("delimiter", "\t")
      .schema(schema)
      .load("data/"+fileName)

    return df
  }
}

object Main1 {
  def main(args: Array[String]): Unit = {
    val myDataReader = new DataReader
    val myDF = myDataReader.importData("20170818123000.gkg.csv",myDataReader.SCHEMA_EVENTS)
    myDF.show()
  }
}

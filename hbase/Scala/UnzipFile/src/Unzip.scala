
import java.io.{ IOException, FileOutputStream, FileInputStream, File }
import java.util.zip.{ ZipEntry, ZipInputStream }

object Unzip extends App {
  var unzip=new ZipArchive
  unzip.unZip("src/testZipFile.zip", "Unzips")

}
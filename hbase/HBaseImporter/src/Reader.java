import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import com.csvreader.*;

public class Reader {

	public static long read(String tableName, long rowCounter) {
		//name of file that will be read and parse
		String fileName = "gdelt.csv";
		Hbase hbase = new Hbase();
		// Line
		String line = null;

		try {
			int iLine = 1;
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferReader = new BufferedReader(fileReader);
			while ((line = bufferReader.readLine()) != null) {
				rowCounter = hbase.createData(tableName, line, rowCounter);

			}

			bufferReader.close();

		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("File not found!!!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("exception " + e);
		}

		System.out.println("bitti");
		return rowCounter;
	}
}

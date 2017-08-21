import java.io.IOException;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;


public class Hbase {

	public void createTable(String tableName) {

		// Instantiating configuration class
		Configuration con = HBaseConfiguration.create();

		// Instantiating HbaseAdmin class
		HBaseAdmin admin;
		try {
			admin = new HBaseAdmin(con);
			// Instantiating table descriptor class
			HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf(tableName));

			// Adding column families to table descriptor
			tableDescriptor.addFamily(new HColumnDescriptor("cFamiliy"));

			// Execute the table through admin
			admin.createTable(tableDescriptor);
			System.out.println(" Table created ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public long createData(String tableName, String line, long rowCounter) throws IOException {

		
		// Instantiating Configuration class
		Configuration config = HBaseConfiguration.create();

		// Instantiating HTable class
		HTable hTable = new HTable(config, tableName);

		// Instantiating Put class
		// accepts a row name.
		Put p = new Put(Bytes.toBytes(rowCounter+"row"));
		System.out.println(rowCounter);
		
		String[] parseLine = line.split("\\t");
		System.out.println(parseLine.length);

		// adding values using add() method
		// accepts column family name, qualifier/row name ,value
		
if(parseLine.length>26){
	p.add(Bytes.toBytes("cFamily"), Bytes.toBytes("GKGRECORID"), Bytes.toBytes(parseLine[0]));
	p.add(Bytes.toBytes("cFamily"), Bytes.toBytes("V2.1DATE"), Bytes.toBytes(parseLine[1]));
	p.add(Bytes.toBytes("cFamily"), Bytes.toBytes("V2SOURCECOLLECTIONIDENTIFIER"), Bytes.toBytes(parseLine[2]));
	p.add(Bytes.toBytes("cFamily"), Bytes.toBytes("V2SOURCECOMMONNAME"), Bytes.toBytes(parseLine[3]));
	p.add(Bytes.toBytes("cFamily"), Bytes.toBytes("V2DOCUMENTIDENTEFER"), Bytes.toBytes(parseLine[4]));
	p.add(Bytes.toBytes("cFamily"), Bytes.toBytes("V1COUNTS"), Bytes.toBytes(parseLine[5]));
	p.add(Bytes.toBytes("cFamily"), Bytes.toBytes("V2.1COUNTS"), Bytes.toBytes(parseLine[6]));
	p.add(Bytes.toBytes("cFamily"), Bytes.toBytes("V1THEMES"), Bytes.toBytes(parseLine[7]));
	p.add(Bytes.toBytes("cFamily"), Bytes.toBytes("V2ENCHANDEDTHEMES"), Bytes.toBytes(parseLine[8]));
	p.add(Bytes.toBytes("cFamily"), Bytes.toBytes("V1LOCATIONS"), Bytes.toBytes(parseLine[9]));
	p.add(Bytes.toBytes("cFamily"), Bytes.toBytes("V2ENHANCEDLOCATIONS"), Bytes.toBytes(parseLine[10]));
	p.add(Bytes.toBytes("cFamily"), Bytes.toBytes("V1PERSONS"), Bytes.toBytes(parseLine[11]));
	p.add(Bytes.toBytes("cFamily"), Bytes.toBytes("V2ENHANCEDPERSONS"), Bytes.toBytes(parseLine[12]));
	p.add(Bytes.toBytes("cFamily"), Bytes.toBytes("V1ORGANIZATIONS"), Bytes.toBytes(parseLine[13]));
	p.add(Bytes.toBytes("cFamily"), Bytes.toBytes("V2ENHANCEDORGANIZATIONS"), Bytes.toBytes(parseLine[14]));
	p.add(Bytes.toBytes("cFamily"), Bytes.toBytes("V1.5TONE"), Bytes.toBytes(parseLine[15]));
	p.add(Bytes.toBytes("cFamily"), Bytes.toBytes("V2.1ENHANCEDDATES"), Bytes.toBytes(parseLine[16]));
	p.add(Bytes.toBytes("cFamily"), Bytes.toBytes("V2GCAM"), Bytes.toBytes(parseLine[17]));
	p.add(Bytes.toBytes("cFamily"), Bytes.toBytes("V2.1SHARINGIMAGE"), Bytes.toBytes(parseLine[18]));
	p.add(Bytes.toBytes("cFamily"), Bytes.toBytes("V2.1RELATEDIMAGES"), Bytes.toBytes(parseLine[19]));
	p.add(Bytes.toBytes("cFamily"), Bytes.toBytes("V2.1SOCIALIMAGEEMBEDS"), Bytes.toBytes(parseLine[20]));
	p.add(Bytes.toBytes("cFamily"), Bytes.toBytes("V2.1SOCIALVIDEOEMBEDS"), Bytes.toBytes(parseLine[21]));
	p.add(Bytes.toBytes("cFamily"), Bytes.toBytes("V2.1QUOTATIONS"), Bytes.toBytes(parseLine[22]));
	p.add(Bytes.toBytes("cFamily"), Bytes.toBytes("V2.1ALLNAMES"), Bytes.toBytes(parseLine[23]));
	p.add(Bytes.toBytes("cFamily"), Bytes.toBytes("V2.1AMOUNTS"), Bytes.toBytes(parseLine[24]));
	p.add(Bytes.toBytes("cFamily"), Bytes.toBytes("V2.1TRANSLATIONINFO."), Bytes.toBytes(parseLine[25]));
	p.add(Bytes.toBytes("cFamily"), Bytes.toBytes("V2EXTRASXML"), Bytes.toBytes(parseLine[26]));
	
	
	// Saving the put Instance to the HTable.
	hTable.put(p);
	System.out.println("data inserted");
	rowCounter++;

	
}
		
		// closing HTable
		hTable.close();
		return rowCounter;
	}


}

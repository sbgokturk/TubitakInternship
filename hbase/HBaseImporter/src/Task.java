import java.util.TimerTask;

public class Task extends TimerTask{
	static long rowCounter=0;
	@Override
	public void run() {
		//rowCounter to avoid override rows
		rowCounter = Reader.read("myTable",rowCounter);
		
	}
	
	
}

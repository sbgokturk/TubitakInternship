import java.util.*;

public class Import {

	public static void main(String[] args) {
		
		//Periodcially run every 900000miliseconds(15 min)
		Task newTask = new Task();
		Timer time=new Timer();
	    time.scheduleAtFixedRate(newTask, 0, 900000);

	}
}
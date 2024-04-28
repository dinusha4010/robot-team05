package app;

import threads.LightSensorThread;
import threads.ReadLineFollowerData;
import threads.ReadRunStatusData;
import threads.RunLego;

public class Main {

	public static void main(String[] args) {
		
		 Thread thread = new Thread(new ReadLineFollowerData());
	        thread.start();
	        

			Thread thread2 = new Thread(new RunLego());
		    thread2.start();
		    
		    Thread thread3 = new Thread(new ReadRunStatusData());
	        thread3.start();
	        Thread thread4 = new Thread(new LightSensorThread());
	        thread4.start();

	}

}

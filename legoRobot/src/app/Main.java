package app;

import threads.LightSensorThread;
import threads.ReadData;
import threads.ReadData2;
import threads.RunLego;

public class Main {

	public static void main(String[] args) {
		
		 Thread thread = new Thread(new ReadData());
	        thread.start();
	        

			Thread thread2 = new Thread(new RunLego());
		    thread2.start();
		    
		    Thread thread3 = new Thread(new ReadData2());
	        thread3.start();
	        Thread thread4 = new Thread(new LightSensorThread());
	        thread4.start();

	}

}

package app;

import threads.LightSensorThread;
import threads.ReadLineFollowerData;
import threads.ReadObstacale;
import threads.ReadRunStatusData;
import threads.RunLego;
import threads.UltrasonicSensor;

public class Main {

	public static void main(String[] args) {

		Thread thread = new Thread(new LightSensorThread());

		Thread thread1 = new Thread(new ReadLineFollowerData());

		Thread thread2 = new Thread(new ReadObstacale());

		Thread thread3 = new Thread(new ReadRunStatusData());
		
		Thread thread4 = new Thread(new RunLego());
		
		Thread thread5 = new Thread(new UltrasonicSensor());
		
		
		
		

		thread.start();
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();

	}

}

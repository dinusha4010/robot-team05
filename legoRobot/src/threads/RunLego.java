package threads;


import data.Path;
import data.Run;
import lejos.hardware.Button;
import lejos.hardware.motor.Motor;
import lejos.robotics.RegulatedMotor;

public class RunLego implements Runnable{
	 RegulatedMotor leftMotor = Motor.B;
	 RegulatedMotor rightMotor = Motor.A;

	@Override
	public void run() {
		
		while (!Button.ESCAPE.isDown()) {
		while(Run.getRun()==1) {
			
			try {
				Thread.sleep(1);
				
			}
			catch(InterruptedException e) {
				
				e.printStackTrace();
			}
			
		
			leftMotor.setSpeed(Path.getLeftMotorSpeed());
			rightMotor.setSpeed(Path.getRightMotorSpeed());
			UpdateCurrentSpeed.updateRunValue(Path.getLeftMotorSpeed(), Path.getRightMotorSpeed());
			leftMotor.forward();
			rightMotor.forward();
			
		}
		
		leftMotor.stop();
		rightMotor.stop();
	
	}

}
}

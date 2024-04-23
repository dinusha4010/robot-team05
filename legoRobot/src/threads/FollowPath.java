package threads;

import data.Robot;
import lejos.hardware.motor.Motor;
import lejos.robotics.RegulatedMotor;

public class FollowPath implements Runnable{
	 RegulatedMotor leftMotor = Motor.B;
	 RegulatedMotor rightMotor = Motor.A;

	@Override
	public void run() {
		while(Robot.getRun()==1) {
			
			try {
				Thread.sleep(1);
				
			}
			catch(InterruptedException e) {
				
				e.printStackTrace();
			}
			
			if(Robot.getDirection()==1) {
				leftMotor.forward();
				rightMotor.forward();
			}else {
				leftMotor.backward();;
				rightMotor.backward();
				
			}
			leftMotor.setSpeed(Robot.getSpeed());
			leftMotor.setSpeed(Robot.getSpeed());
			
		}
		
	}

}

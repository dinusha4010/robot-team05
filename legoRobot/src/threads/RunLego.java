package threads;


import data.Obstacale;
import data.Path;
import data.Run;
import lejos.hardware.Button;
import lejos.hardware.motor.Motor;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class RunLego implements Runnable{
	 RegulatedMotor leftMotor = Motor.B;
	 RegulatedMotor rightMotor = Motor.A;
	 private TransferObject transferObject;

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
			if (!transferObject.isObjectdetect())
			{
			leftMotor.setSpeed(Path.getLeftMotorSpeed());
			rightMotor.setSpeed(Path.getRightMotorSpeed());
			UpdateCurrentSpeed.updateRunValue(Path.getLeftMotorSpeed(), Path.getRightMotorSpeed());
			leftMotor.forward();
			rightMotor.forward();
			}
			else {
				
				leftMotor.setSpeed(Obstacale.getStepOneLeftMotorSpeed());
				rightMotor.setSpeed(Obstacale.getStepOneRightMotorSpeed());
				leftMotor.forward();
				rightMotor.forward();
				Delay.msDelay(Obstacale.getStepOneTimeDelay());
				
				leftMotor.setSpeed(Obstacale.getStepTwoLeftMotorSpeed());
				rightMotor.setSpeed(Obstacale.getStepTwoRightMotorSpeed());
				leftMotor.forward();
				rightMotor.forward();
				Delay.msDelay(Obstacale.getStepTwoTimeDelay());
				
				
				leftMotor.setSpeed(Obstacale.getStepThreeLeftMotorSpeed());
				rightMotor.setSpeed(Obstacale.getStepThreeRightMotorSpeed());
				leftMotor.forward();
				rightMotor.forward();
				Delay.msDelay(Obstacale.getStepThreeTimeDelay());
				
				leftMotor.setSpeed(Obstacale.getStepFourLeftMotorSpeed());
				rightMotor.setSpeed(Obstacale.getStepFourRightMotorSpeed());
				leftMotor.forward();
				rightMotor.forward();
				Delay.msDelay(Obstacale.getStepFourTimeDelay());
			}
		}
		
		leftMotor.stop();
		rightMotor.stop();
	
	}

}
}

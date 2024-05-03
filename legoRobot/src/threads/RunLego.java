package threads;

import data.Obstacale;
import data.Path;
import data.Run;
import lejos.hardware.Button;
import lejos.hardware.motor.Motor;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class RunLego implements Runnable {
	RegulatedMotor leftMotor = Motor.B;
	RegulatedMotor rightMotor = Motor.A;
	private int obstacleCount = -1;

	@Override
	public void run() {

		while (!Button.ESCAPE.isDown()) {
			while (Run.getRun() == 1) {

				try {
					Thread.sleep(1);

				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				if (!TransferObject.isObjectdetect()) {
					leftMotor.setSpeed(Path.getLeftMotorSpeed());
					rightMotor.setSpeed(Path.getRightMotorSpeed());
					UpdateCurrentSpeed.updateRunValue(Path.getLeftMotorSpeed(), Path.getRightMotorSpeed());
					leftMotor.forward();
					rightMotor.forward();
				}

				else {

					obstacleCount++;
					if (obstacleCount < Obstacale.getObtacalCount()) {
						leftMotor.stop();
						rightMotor.stop();

						leftMotor.setSpeed(Obstacale.getStepOneLeftMotorSpeed());
						rightMotor.setSpeed(Obstacale.getStepOneRightMotorSpeed());
						UpdateCurrentSpeed.updateRunValue(Path.getLeftMotorSpeed(), Path.getRightMotorSpeed());
						leftMotor.forward();
						rightMotor.forward();
						Delay.msDelay(Obstacale.getStepOneTimeDelay());
						leftMotor.stop();
						rightMotor.stop();

						leftMotor.setSpeed(Obstacale.getStepTwoLeftMotorSpeed());
						rightMotor.setSpeed(Obstacale.getStepTwoRightMotorSpeed());
						UpdateCurrentSpeed.updateRunValue(Path.getLeftMotorSpeed(), Path.getRightMotorSpeed());
						leftMotor.forward();
						rightMotor.forward();
						Delay.msDelay(Obstacale.getStepTwoTimeDelay());
						leftMotor.stop();
						rightMotor.stop();

						leftMotor.setSpeed(Obstacale.getStepThreeLeftMotorSpeed());
						rightMotor.setSpeed(Obstacale.getStepThreeRightMotorSpeed());
						UpdateCurrentSpeed.updateRunValue(Path.getLeftMotorSpeed(), Path.getRightMotorSpeed());
						leftMotor.forward();
						rightMotor.forward();
						Delay.msDelay(Obstacale.getStepThreeTimeDelay());
						leftMotor.stop();
						rightMotor.stop();
						leftMotor.setSpeed(Obstacale.getStepFourLeftMotorSpeed());
						rightMotor.setSpeed(Obstacale.getStepFourRightMotorSpeed());
						UpdateCurrentSpeed.updateRunValue(Path.getLeftMotorSpeed(), Path.getRightMotorSpeed());
						leftMotor.forward();
						rightMotor.forward();
						Delay.msDelay(Obstacale.getStepFourTimeDelay());
					}

					else {
						leftMotor.stop();
						rightMotor.stop();
						UpdateRunStatus.stop(0);

						try {
							Thread.sleep(10000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

						System.exit(0);
					}

				}

			}

			leftMotor.stop();
			rightMotor.stop();
		}

	}
}

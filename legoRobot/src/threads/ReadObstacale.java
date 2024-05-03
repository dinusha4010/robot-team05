package threads;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import data.Obstacale;
import data.Path;
//import lejos.hardware.Button;
import lejos.hardware.Button;

public class ReadObstacale implements Runnable {
	
	URL url=null;
	HttpURLConnection conn=null;
	InputStreamReader isr = null;
	BufferedReader br=null;
	String s=null;

	@Override
	public void run() {
		
		while (!Button.ESCAPE.isDown()) {
		try {
			Thread.sleep(1);
			
		}
		catch(InterruptedException e) {
			
			e.printStackTrace();
		}
		try {
			url = new URL("http://192.168.101.122:8080/rest/legoservice/getobstacle");
			conn = (HttpURLConnection)url.openConnection();
  			System.out.println(conn.toString()); //Tulostaa vain URLin
			InputStream is=null;
			try {
				is=conn.getInputStream();
			}
			catch (Exception e) {
	  			System.out.println("Exception conn.getInputSteam()");
	  			e.printStackTrace();
	            System.out.println("Cannot get InputStream!");
			}
			isr = new InputStreamReader(is);
      		br=new BufferedReader(isr);
			while ((s=br.readLine())!=null){
				String []ds=s.split("#");
				
				Obstacale.setStepOneLeftMotorSpeed(ds[2]);
				Obstacale.setStepOneRightMotorSpeed(ds[3]);
				Obstacale.setStepOneTimeDelay(ds[4]);
				
				Obstacale.setStepTwoLeftMotorSpeed(ds[5]);
				Obstacale.setStepTwoRightMotorSpeed(ds[6]);
				Obstacale.setStepTwoTimeDelay(ds[7]);
				
				Obstacale.setStepThreeLeftMotorSpeed(ds[8]);
				Obstacale.setStepThreeRightMotorSpeed(ds[9]);
				Obstacale.setStepThreeTimeDelay(ds[10]);
				
				Obstacale.setStepFourLeftMotorSpeed(ds[11]);
				Obstacale.setStepFourRightMotorSpeed(ds[12]);
				Obstacale.setStepFourTimeDelay(ds[13]);
				
				Obstacale.setObtacalCount(ds[14]);
				Obstacale.setObtacaDistance(ds[15]);
				
				
			}
		}
  		catch(Exception e) {
  			e.printStackTrace();
            System.out.println("Some problem!");
  		}
		if (UltrasonicSensor.getCurrentDistance() < 20) {
			TransferObject.setFlag(true);
		 
			
		} else {
			TransferObject.setFlag(false);
			 
				
		}
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

		
		
	}
}


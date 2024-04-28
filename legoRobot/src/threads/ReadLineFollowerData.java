package threads;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


import data.Path;
//import lejos.hardware.Button;
import lejos.hardware.Button;

public class ReadLineFollowerData implements Runnable {
	
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
			url = new URL("http://192.168.101.122:8080/rest/legoservice/getfollow");
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
				
				for (int i = 3; i <= 34; i += 7) {
				    Path.setMinIntensity(ds[i]);
				    Path.setMaxIntensity(ds[i + 1]);
				    
				    if (Path.getMinIntensity() < LightSensorThread.getCurrentIntensity() && LightSensorThread.getCurrentIntensity() < Path.getMaxIntensity()) {
				        Path.setLeftMotorSpeed(ds[i + 2]);
				        Path.setRightMotorSpeed(ds[i + 3]);
				    }
				}

				
				
			}
		}
  		catch(Exception e) {
  			e.printStackTrace();
            System.out.println("Some problem!");
  		}
        System.out.println("Press any key to FINISH");
       // Button.waitForAnyPress();
	}

		
		
	}
}


package data;

public class Path {

	private static int Id;
	private static int targetIntensityRange;
	private static int minIntensity;
	private static int maxIntensity;
	private static int LeftMotorSpeed;
	private static int RightMotorSpeed;
	
	
	

	public static int getId() {
		return Id;
	}




	public static void setId(int id) {
		Id = id;
	}
	
	public static void setId(String id) {
		try {
			Id = Integer.parseInt(id);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	public static int getTargetIntensityRange() {
		return targetIntensityRange;
	}




	public static void setTargetIntensityRange(int targetIntensityRange) {
		Path.targetIntensityRange = targetIntensityRange;
	}
	
	public static void setTargetIntensityRange(String targetIntensityRange) {
		try {
			Path.targetIntensityRange = Integer.parseInt(targetIntensityRange);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	public static int getMinIntensity() {
		return minIntensity;
	}




	public static void setMinIntensity(int minIntensity) {
		Path.minIntensity = minIntensity;
	}
	
	public static void setMinIntensity(String minIntensity) {
		try {
			Path.minIntensity = Integer.parseInt(minIntensity);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	public static int getMaxIntensity() {
		return maxIntensity;
	}




	public static void setMaxIntensity(int maxIntensity) {
		Path.maxIntensity = maxIntensity;
	}
	
	public static void setMaxIntensity(String maxIntensity) {
		try {
			Path.maxIntensity = Integer.parseInt(maxIntensity);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	public static int getLeftMotorSpeed() {
		return LeftMotorSpeed;
	}




	public static void setLeftMotorSpeed(int leftMotorSpeed) {
		LeftMotorSpeed = leftMotorSpeed;
	}
	
	public static void setLeftMotorSpeed(String leftMotorSpeed) {
		try {
			LeftMotorSpeed = Integer.parseInt(leftMotorSpeed);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	public static int getRightMotorSpeed() {
		return RightMotorSpeed;
	}




	public static void setRightMotorSpeed(int rightMotorSpeed) {
		RightMotorSpeed = rightMotorSpeed;
	}
	
	public static void setRightMotorSpeed(String rightMotorSpeed) {
		try {
			RightMotorSpeed = Integer.parseInt(rightMotorSpeed);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	@Override
	public String toString() {
		return "Path [Id=" + Id + ", targetIntensityRange=" + targetIntensityRange + ", minIntensity=" + minIntensity
				+ ", maxIntensity=" + maxIntensity + ", LeftMotorSpeed=" + LeftMotorSpeed + ", RightMotorSpeed="
				+ RightMotorSpeed + "]";
	}

}
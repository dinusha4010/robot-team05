package threads;
/**
 * TransferObject class represents an object used for transferring data between
 * threads. It contains a flag indicating whether an object is detected.
 * 
 * @author Dinusha Kaluarachchi
 * @author Nuwani Fernando
 * @author Supun Wathsana
 * @version 1.0
 * @since 04/04/2023
 */
public class TransferObject {
	private static boolean flag=false;

	/**
	 * Checks if an object is detected.
	 * 
	 * @return true if an object is detected, false otherwise
	 */
	public static boolean isObjectdetect() {
		return flag;
	}

	/**
	 * Sets the flag indicating object detection.
	 * 
	 * @param flag The flag value to set
	 */
	public static void setFlag(boolean Flag) {
		flag = Flag;
	}
}

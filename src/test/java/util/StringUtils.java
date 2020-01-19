package util;

public class StringUtils {

	private static StringUtils instance = null;
	
	private StringUtils() {}
	
	public static StringUtils getInstance() {
		if(instance == null) {
			instance = new StringUtils();
		} 
		return instance;
	}
	
	public static boolean isValidEmail(String email) {
		//TODO needs use regex to validate more accurately 
		boolean isValid = email.contains("@") ? true : false;
		return isValid;
	}
}

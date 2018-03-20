package util;

/**
 * Simple class that provides a static Validator object to validate information provided by the user
 * 
 * @author Kleber Silva
 *
 */

public class Validator {

	private static Validator instance = null;
	
	private Validator() {}
	
	public static Validator getInstance() {
		if(instance == null) {
			instance = new Validator();
		} 
		return instance;
	}
	
	public static boolean isValidEmail(String email) {
		//TODO needs use regex to validate more accurately 
		boolean isValid = email.contains("@") ? true : false;
		return isValid;
	}
}

package com.example.selenium.util;

public class StringUtils {
	
	public static boolean isValidEmail(String email) {
		return email.contains("@");
	}

	public static boolean isValidPhoneNumber(String phoneNumber) {
		return phoneNumber.length() == 10;
	}
}
package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class is responsible for handling with the management of the properties file.
 * It uses the Singleton pattern to ensure that only one instance of the class exists in memory.
 * 
 * @author Kleber Silva
 * @date 3/18/2018
 */

public class ResourceUtil {

	private Properties prop = null;
	private static ResourceUtil instance = null;

	/**
	 * Constructor must be kept private so it is only accessible through the public static method getInstance()  
	 */
	private ResourceUtil() {}

	/**
	 * Static method that returns an instance of the class ResourceUtil if none has not been instantiated  
	 * @return An instance of the ResourceUtil class
	 */
	public static ResourceUtil getInstance() {
		if (instance == null) {
			instance = new ResourceUtil();
		}
		return instance;
	}

	/** Generates a new properties file containing the path to the drivers binaries according to the user operating system  
	 * @return A properties object
	 * @throws IOException
	 */
	private Properties createProperties() throws IOException {
		Properties prop = new Properties();
		try {
			String osName = System.getProperty("os.name");
			String userDir = System.getProperty("user.dir");
			
			if (osName.contains("Windows")) {
				prop.setProperty("webdriver.gecko.driver", userDir + "\\src\\test\\resources\\bin\\win32\\geckodriver.exe");
				prop.setProperty("webdriver.chrome.driver", userDir + "\\src\\test\\resources\\bin\\win32\\chromedriver.exe");
			} else if (osName.contains("Mac")) {
				prop.setProperty("webdriver.gecko.driver", userDir + "/src/test/resources/bin/mac64/geckodriver");
				prop.setProperty("webdriver.chrome.driver", userDir + "/src/test/resources/bin/mac64/chromedriver");
			} else if (osName.contains("Linux")) {
				prop.setProperty("webdriver.gecko.driver", userDir + "/src/test/resources/bin/linux64/geckodriver");
				prop.setProperty("webdriver.chrome.driver", userDir + "/src/test/resources/bin/linux64/chromedriver");
			} 
			prop.store(new FileOutputStream("config.properties"), null);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return prop;
	}

	/** Loads the specified properties file generating 
	 * 	a new one by invoking createProperties() if file does not exist
	 * @return A properties object
	 * @throws IOException
	 */
	private Properties loadProperties() throws IOException {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("config.properties"));
			return prop;
		} catch (FileNotFoundException fe) {
			return createProperties();
		} catch (IOException ioe) {
			ioe.printStackTrace();;
		}
		return prop;
	}

	private Properties getProp() throws IOException {
		if (prop == null) {
			prop = loadProperties();
		}
		return prop;
	}

	public String getProperty(String key) {
		try {
			return getProp().getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
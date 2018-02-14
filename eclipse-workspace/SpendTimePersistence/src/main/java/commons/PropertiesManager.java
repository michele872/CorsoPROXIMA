/**
 * 
 */
package commons;

import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

/**
 * @author maurizio
 *
 */
public class PropertiesManager {

	private final static Properties configProp = new Properties();
	
	public static void main(String[] args) throws Exception {
		
//		String propFileName = "application.properties";
//		 
//		InputStream inputStream = PropertiesManager.class
//				.getClassLoader().getResourceAsStream(propFileName);
//		
//		configProp.load(inputStream);
//		
//		String dbHostname   = configProp.getProperty("database.hostname");
//		String dbPort = configProp.getProperty("database.port");
//
//		System.out.println("dbHostname: " + dbHostname + " - dbPort: " +  dbPort);
		System.out.println("getPropertyAsString(\"database.hostname\"): " + getPropertyAsString("database.hostname"));
		;
	}
	
	/**
	 * @param args
	 */
	public PropertiesManager () throws Exception {
		String propFileName = "application.properties";
		 
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		
		configProp.load(inputStream);
		
	}
	
	public static String getPropertyAsString (String key) {
		String returnValue = "" ;
		try {
			String propFileName = "application.properties";
			 
			InputStream inputStream = PropertiesManager.class
					.getClassLoader().getResourceAsStream(propFileName);
			
			configProp.load(inputStream);
			
			returnValue = configProp.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return returnValue ;
	}

}

package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropFile {
	public static String getPropData(String datatoberead) throws IOException {
		
		Properties prop = new Properties();	
		String path = System.getProperty("user.dir")+"\\config.properties";
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		String value = prop.getProperty(datatoberead);
		
		return value;
	}
}

package Generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Proprty {
	
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("");
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
	}

}

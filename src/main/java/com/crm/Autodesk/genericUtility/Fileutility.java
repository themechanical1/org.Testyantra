package com.crm.Autodesk.genericUtility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author Lenovo
 *
 */

public class Fileutility {
	/**
	 * its used to read the data from commonData.properties File based on Key which you pass as an argument
	 * @param key
	 * @throws Throwable 
	 */
    public String getPropertyKeyValue(String key) throws Throwable {
    	 FileInputStream fis = new FileInputStream(".\\src\\main\\resources\\commondata\\credentials.properties");
    	 Properties pobj = new Properties();
    	 pobj.load(fis);
    	 String value = pobj.getProperty(key);
		return value;
    	
    }


}

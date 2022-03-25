package com.crm.Autodesk.genericUtility;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Random;
/**
 * 
 * @author Lenovo
 *
 */

public class JavaUtility {
	/**
	 * its used to generate random number
	 * @return int data
	 */
	public int getRanDomNumber() {
		Random random= new Random();
		int intRandom=random.nextInt(100000);
		return intRandom;
	}
	/**
	 * used to get system date&time in IST format
	 * @return
	 */
	
	public String getSystemDateAndTime() {
		Date date= new Date();
		return date.toString().replace(":","-");
	}
	/**
	 * used to get System date in YYYY-MM-DD format
	 * @return
	 */
	public String getSystemDatewithFormate() {
		Date date= new Date();
		String dateAndTime= date.toString();
		String YYYY=dateAndTime.split(" ")[5];
		String DD=dateAndTime.split(" ")[2];
		int MM = date.getMonth()+1;
		String finalFormate=YYYY+"-"+MM+"-"+DD;
		return finalFormate;
		
	}
	/**
     * used to pass Virtual Key to OS
     * @throws Throwable
     */
    public void pressVurtualEnterKey() throws Throwable {
    	
    	Robot rc=new Robot();
    	rc.keyPress(KeyEvent.VK_ENTER);
    	rc.keyRelease(KeyEvent.VK_ENTER);
    }



}

package com.crm.Autodesk.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalayzerImplementationClass implements IRetryAnalyzer {
        int count=0;
        int retrycount=5;
	public boolean retry(ITestResult result) {
		if(count<retrycount) {
			count++;
			return true;
		}
		return false;
	}
	

}

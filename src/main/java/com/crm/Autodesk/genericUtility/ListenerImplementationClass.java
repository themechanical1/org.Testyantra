package com.crm.Autodesk.genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
/**
 * This Class Contain implementation for ITestListener interface of TestNG
 * @author Aman
 *
 */

public class ListenerImplementationClass implements ITestListener {

	public void onFinish(ITestContext context) {
		System.out.println("Finished");
		
		
	}

	public void onStart(ITestContext context) {
		System.out.println("started");
		
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"-------->execution failed");
		System.out.println(result.getThrowable());
		
		try {
			String path = new WebDriverutility().takeScreenshot(BaseClass.sDriver,methodName);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"-------->execution Skipped");
		System.out.println(result.getThrowable());
		
			}

	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"-------->execution Started");
		
			}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"-------->execution successfull");
		
	}
	

}

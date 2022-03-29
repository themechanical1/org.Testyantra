package com.crm.Autodesk.genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * This Class Contain implementation for ITestListener interface of TestNG
 * @author Aman
 *
 */

public class ListenerImplementationClass implements ITestListener {
		ExtentTest test;
		ExtentReports report;
		@Override
	public void onFinish(ITestContext context) {
		report.flush();
		
		
	}
		@Override
	public void onStart(ITestContext context) {
		//Step 1: Extent report configuration
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("./extentReport"+new JavaUtility().getSystemDateAndTime()+".html");
		htmlReporter.config().setReportName("Regression execution Report");
		htmlReporter.config().setDocumentTitle("Autodesk automation execution Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		//step 2: attach the physical report and do the system configuration
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("OS", "Windows 10");
		report.setSystemInfo("Environment", "Testing Environment");
		report.setSystemInfo("URL", "http://localhost:8888");
		report.setSystemInfo("Reporter Name", "Aman");
		
		
		
	}
		@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			}
		@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}
		@Override
	public void onTestFailure(ITestResult result) {
		//Step 6: log fail method, take screenshot,attach screen shot to extent report, add exception log
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		String path=null;
		WebDriverutility wLib= new WebDriverutility();
		try {
			path = wLib.takeScreenshot(BaseClass.sDriver,result.getMethod().getMethodName());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(path);
		
	}
		@Override
	public void onTestSkipped(ITestResult result) {
		//Step 5: log the skip method
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
		
			}
		@Override
	public void onTestStart(ITestResult result) {
		//Step 3: create a test method during the test execution start
		test=report.createTest(result.getMethod().getMethodName());
		
			}
		@Override
	public void onTestSuccess(ITestResult result) {
		//step 4: log the pass method
		test.log(Status.PASS, result.getMethod().getMethodName());
		
	}
	

}

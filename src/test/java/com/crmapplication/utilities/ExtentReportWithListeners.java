package com.crmapplication.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crmapplication.testcase.Base;

public class ExtentReportWithListeners extends Base implements ITestListener
{
	public ExtentSparkReporter create_report;
	public ExtentReports addtest;
	public ExtentTest addlogs; 
	
	@BeforeClass
	 void report() {
		 
		 create_report  = new ExtentSparkReporter("report123.html");
		 addtest = new ExtentReports(); 
		 
		 addtest.attachReporter(create_report); 
		 //Set Environment
		 
		  addtest.setSystemInfo("OS", "Windows");
		  addtest.setSystemInfo("Browser", "Chrome");
		  addtest.setSystemInfo("Browser_version", "122.34.56.01");
		  addtest.setSystemInfo("Environment", "QA");
		  addtest.setSystemInfo("Username", "Sunny Kumar");
		  
		  //Set Configuration
		  
		  create_report.config().setReportName("CrmApllicartion");
		  create_report.config().setDocumentTitle("myDomeReport");
		  create_report.config().setTheme(Theme.DARK);

		 
	 }

	
	//Listeners
	
	
	
	public void onStart(ITestContext Result) {
		
		report();
		
	}
	
	
	public void onTestSuccess(ITestResult Result) {
		
		addlogs = addtest.createTest(Result.getName());
		addlogs.log(Status.PASS, MarkupHelper.createLabel("My Pass Test Case", ExtentColor.GREEN));
		
	}
	
	
	
	public void onTestFailure(ITestResult Result) {
		
		try {
			screenshot();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String path = System.getProperty("user.dir") + "/screenshot/login.png"; 
		addlogs = addtest.createTest(Result.getName());
		addlogs.log(Status.FAIL, MarkupHelper.createLabel("My Fail Test Case", ExtentColor.RED));
		addlogs.fail("Fail Test Case: " + addlogs.addScreenCaptureFromPath(path));
		
	}
	
	
	public void onTestSkipped(ITestResult Result) {
		
		addlogs = addtest.createTest(Result.getName());
		addlogs.log(Status.SKIP, MarkupHelper.createLabel("My Skip Test Case", ExtentColor.YELLOW));
		
	}
	
	
	public void onFinish(ITestContext Result) {
		
		addtest.flush();
		
	}
}

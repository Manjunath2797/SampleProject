package com.SDET43.GenericLibraries;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementaionClass implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName();
		test = report.createTest(MethodName);
		Reporter.log(MethodName+"--Testscript execution started--");
	}

	public void onTestSuccess(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"-->Passed");
		Reporter.log(MethodName+"----> script executed successfully");
	}

	public void onTestFailure(ITestResult result) 
	{
		test.log(Status.FAIL,result.getMethod().getMethodName());
		test.log(Status.FAIL,result.getThrowable());
		
		//String FScript = Failedscript + new JavaUtility().getSystemDateAndTimeInFormat();
		//EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
		//File src = edriver.getScreenshotAs(OutputType.FILE);
		//File dst = new File(".\\screenshot\\"+FScript+".png");
			try {
				String screenshotname = WebDriverUtility.getScreenShot(BaseClass.sdriver,result.getMethod().getMethodName());
				test.addScreenCaptureFromPath(screenshotname);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//FileUtils.copyFile(src, dst);
		} 

	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"--> skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(MethodName+"--testscript execution skipped");
		
	}

	public void onStart(ITestContext context) {
		//Execution starts here
		//configure the report
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\ExtentReport\\report.html");
		htmlReport.config().setDocumentTitle("SDET-43 Execution report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("VTiger Execution Report");
		
		
		report = new ExtentReports();
		
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base_Browser", "Chrome");
		report.setSystemInfo("OS", "windows");
		report.setSystemInfo("Base_url", "https://localhost:8888");
		report.setSystemInfo("ReporterName", "Vijayalaxmi");
		
	}

	public void onFinish(ITestContext context)  {
		
		//Consolidate all the parameters and generate the report
		report.flush();
	}
	

}

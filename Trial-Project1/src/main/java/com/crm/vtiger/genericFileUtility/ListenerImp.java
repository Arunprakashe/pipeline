package com.crm.vtiger.genericFileUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImp extends BaseClass implements ITestListener {
	
	public ExtentReports reports;
	public ExtentTest test;

	public void onTestStart(ITestResult result) {

		test = reports.createTest(result.getMethod().getMethodName());
		
		// String fileLocation = "E:\\Screenshot"+result.getName()+"
		// "+ju.getSystemDate(); ;
		// String fileExtension = ".png" ;
		System.out.println("test started");
		try {
			
			String path = wb.takeScreenshot(BaseClass.statdriver, ".//screenshot//" + result.getName() + " " + ju.getSystemDate(),
					".png");
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSuccess(ITestResult result) {

		test.log(Status.PASS, result.getMethod().getMethodName() + " is passed");
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName() + " is failed");
		test.log(Status.FAIL, result.getThrowable());
		
		try {
			String path = wb.takeScreenshot(BaseClass.statdriver, ".//screenshot//" + result.getName() + " " + ju.getSystemDate(),
					".png");
			test.addScreenCaptureFromPath(path);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName() + " is skipped");
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {

		// This acts as Beforesuite: configuration steps for sparkreporter and extent
		// report
		ExtentSparkReporter report = new ExtentSparkReporter("./ExtentReport.html");

		// Title of the page
		report.config().setDocumentTitle("opportunity");

		// set report name
		report.config().setReportName("smoketest");

		// set a theme color
		report.config().setTheme(Theme.DARK);

		// create an object of extent reports to attach above configuration
		ExtentReports reports = new ExtentReports();

		// To attach the above spark configuration settings to the extent report
		reports.attachReporter(report);

		reports.setSystemInfo("OS", "Windows");
		reports.setSystemInfo("Platform", "Windows 10");
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("Test URL", "localhost:8888/index.php?action=Login&module=Users");
		try {
			reports.setSystemInfo("Browser", "chrome");
		}

		catch (Throwable e) {
			e.printStackTrace();
		}

	}

	public void onFinish(ITestContext context) {
	}

}

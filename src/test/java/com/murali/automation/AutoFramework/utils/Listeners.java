package com.murali.automation.AutoFramework.utils;

import java.io.IOException;

import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Listeners implements ITestListener {
	ExtentSparkReporter spark;
	ExtentReports extent;

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(" On Test Start ");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extent.createTest(result.getMethod().getMethodName()).log(Status.PASS,
				"test Passed" + result.getMethod().getMethodName());
		System.out.println(" On Test Success ");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String path = System.getProperty("user.dir");
		try {
			WebDriverHelper.getScreenShot(result.getMethod().getMethodName());
			extent.createTest(result.getMethod().getMethodName())
					.log(Status.FAIL, "test Failed " + result.getMethod().getMethodName())
					.fail(MediaEntityBuilder
							.createScreenCaptureFromPath("./screenshots/" + result.getMethod().getMethodName() + ".png")
							.build());

		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" On Test Failure ");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extent.createTest(result.getMethod().getMethodName()).log(Status.SKIP,
				"test Skipped " + result.getMethod().getMethodName());
		System.out.println(" On Test Skipped ");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("Spark.html");
		extent.attachReporter(spark);
		System.out.println(" On Start ");
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		System.out.println(" On Finish ");
	}

}

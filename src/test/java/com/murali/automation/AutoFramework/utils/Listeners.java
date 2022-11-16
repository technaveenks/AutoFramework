package com.murali.automation.AutoFramework.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
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
		extent.createTest(result.getMethod().getMethodName())
		  .log(Status.PASS, "test Passed"+result.getMethod().getMethodName());
		System.out.println(" On Test Success ");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extent.createTest(result.getMethod().getMethodName())
		  .log(Status.FAIL,"test Failed "+result.getMethod().getMethodName());
		System.out.println(" On Test Failure ");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
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

package org.qa.opencart.listeners;

import org.openqa.selenium.WebDriver;
import org.qa.opencart.factory.DriverFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AppListeners implements ITestListener{
	
	//DriverFactory df;
	private static WebDriver driver;
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Testing Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		new DriverFactory().getScreenshot(result.getMethod().getMethodName(), driver);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Testing Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Testing Skipped");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Testing OnStart");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Testing OnFinish");
	}
	
	

}

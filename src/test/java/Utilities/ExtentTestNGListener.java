package Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Base.Baseclass;

public class ExtentTestNGListener implements ITestListener {

	private static ExtentReports extent = ExtentManager.getInstance();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
		test.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.get().log(Status.PASS, "Test Passed");

		try {
			String screenshotPath = Baseclass.getScreenshotAsPath();
			test.get().addScreenCaptureFromPath(screenshotPath);
		} catch (Exception e) {
			test.get().log(Status.WARNING, "Screenshot not attached");
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.get().log(Status.FAIL, result.getThrowable());

		try {
			String screenshotPath = Baseclass.getScreenshotAsPath();
			test.get().addScreenCaptureFromPath(screenshotPath);
		} catch (Exception e) {
			test.get().log(Status.WARNING, "Screenshot not attached");
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.get().log(Status.SKIP, "Test Skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}

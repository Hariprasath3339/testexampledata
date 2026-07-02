package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			createInstance("test-output/ExtentReport.html");
		}
		return extent;
	}

	public static ExtentReports createInstance(String fileName) {
		ExtentSparkReporter reporter = new ExtentSparkReporter(fileName);
		reporter.config().setDocumentTitle("Spacira Automation Report");
		reporter.config().setReportName("Spacira Test Report");
		reporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Java Version", System.getProperty("java.version"));
		extent.setSystemInfo("Tester", "Hari Prasath");

		return extent;
	}
}

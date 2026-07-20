package RunnerTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POM.BasicInfo;
import POM.FileUpload;
import POM.Login;
import POM.ROI;
import Utilities.ExtentTestNGListener;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(ExtentTestNGListener.class)
public class PropertTest_Vacant {

	public static WebDriver driver;
	Login login;
	BasicInfo base;
	ROI roi;
	FileUpload FU;

	@BeforeClass
	public void before() throws Exception {

		System.out.println("====== BEFORE CLASS EXECUTED ======");

		// Setup ChromeDriver
		WebDriverManager.chromedriver().setup();

		// Chrome Options (Normal Mode)
		ChromeOptions options = new ChromeOptions();

		// Remove Headless Mode
		// options.addArguments("--headless=new");

		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		options.addArguments("--remote-allow-origins=*");

		// Launch Browser
		driver = new ChromeDriver(options);

		// Maximize Window
		driver.manage().window().maximize();

		// Create Login Page Object
		login = new Login(driver);
		base = new BasicInfo(driver);
		roi = new ROI(driver);
		FU = new FileUpload(driver);

		System.out.println("Chrome Driver Created (NORMAL MODE)");
	}

	@Test(priority = 1)
	public void SpaciraLogin() throws Exception {

		System.out.println("====== TEST STARTED ======");

		login.loginAndNavigate();

		System.out.println("====== LOGIN COMPLETED ======");
	}

	@Test(priority = 2)
	public void MP_VAC_TS001() throws Exception {
		base.Basic_Vacant();
	}

	@Test(priority = 3)
	public void MP_VAC_TS002() throws Exception {
		roi.ROIESTIMATOR();
	}

	@Test(priority = 4)
	public void MP_VAC_TS003() throws Exception {
		FU.FILEUPLOAD_Vacant();
	}

	@AfterClass
	public void after() {

		System.out.println("====== AFTER CLASS EXECUTED ======");

//		if (driver != null) {
//		//	driver.quit();
//		}
	}
}
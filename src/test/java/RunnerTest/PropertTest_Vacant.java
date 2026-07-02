package RunnerTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POM.Login;
import Utilities.ExtentTestNGListener;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(ExtentTestNGListener.class)
public class PropertTest_Vacant {

	public static WebDriver driver;
	Login login;

	@BeforeClass
	public void before() throws Exception {

		System.out.println("====== BEFORE CLASS EXECUTED ======");

		// Setup ChromeDriver
		WebDriverManager.chromedriver().setup();

		// ✅ Add Chrome Options (HEADLESS MODE)
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new"); // modern headless mode
		options.addArguments("--disable-gpu");
		options.addArguments("--window-size=1920,1080");

		// Launch Browser (HEADLESS)
		driver = new ChromeDriver(options);

		// No need for maximize in headless, but safe to keep logic consistent
		driver.manage().window().maximize();

		// Create Login Page Object
		login = new Login(driver);

		System.out.println("Chrome Driver Created (HEADLESS MODE)");
	}

	@Test(priority = 1)
	public void SpaciraLogin() throws Exception {

		System.out.println("====== TEST STARTED ======");

		login.loginAndNavigate();

		System.out.println("====== LOGIN COMPLETED ======");
	}

	@AfterClass
	public void after() {

		System.out.println("====== AFTER CLASS EXECUTED ======");

		if (driver != null) {
			driver.quit();
		}
	}
}
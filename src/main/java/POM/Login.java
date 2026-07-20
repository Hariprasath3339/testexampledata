package POM;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base.Baseclass;
import Utilities.ExcelUtils;

public class Login extends Baseclass {

	public Login(WebDriver driver) throws IOException, AWTException {
		super(driver);
	}

	// Locators

	@FindBy(xpath = "//div[@class='flex items-center gap-4 rtl:gap-1 rtl:sm:gap-4 ms-auto xl:ms-0']//a[1]")
	private WebElement dashboard;

	@FindBy(id = "email")
	private WebElement emailField;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(className = "green_Btn")
	private WebElement loginButton;

	@FindBy(xpath = "//button[contains(@class,'absolute -top-5 -right-3')]")
	private WebElement homeAdCloseBtn;

	@FindBy(xpath = "//button[contains(@class,'absolute -top-5 -right-3')]")
	private WebElement homeAdCloseBtn1;

	@FindBy(xpath = "//div[@class='bg-[#FBF8F3] p-3 mb-5 rounded-[40px] flex flex-col gap-3 menu_item border-1 border-[#fff]']/li[3]")
	private WebElement myProperty;

	@FindBy(xpath = "//div[@class='flex lg:gap-3 gap-2 cus_font']/a[1]")
	private WebElement addProperty;

	@FindBy(xpath = "//div[@id='property_card']/div[1]/div/div/div/div[3]/div")
	private WebElement clickedit;

	// Main Methods

	public void loginAndNavigate() throws IOException, InterruptedException {

		ExcelUtils excel = new ExcelUtils(
				"C:\\Users\\Hariprasath\\OneDrive - CLOUDREVEL INNOVATIONS\\Desktop\\SPACIRAPHASE-2.xlsx",
				"BASIC-Vacant");

		String url = excel.getData(1, 0);
		driver.get(url);

		click(homeAdCloseBtn);
		click(dashboard);

		type(emailField, excel.getData(1, 1));
		type(passwordField, excel.getData(1, 2));
		click(loginButton);
		
		Thread.sleep(1000);

		click(homeAdCloseBtn1);

		Thread.sleep(1000);

		click(myProperty);

	//	js.executeScript("window.location='https://spacira.qacri.com/myproperty/vacant'");

		click(addProperty);

	}

}

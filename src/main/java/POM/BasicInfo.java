package POM;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base.Baseclass;
import Utilities.*;

public class BasicInfo extends Baseclass {

	// Construtor

	public BasicInfo(WebDriver driver) throws IOException, AWTException {
		super(driver);
	}

	// Locators

	@FindBy(xpath = "//input[@placeholder='Enter Property Owner']")
	private WebElement propertyOwner;

	@FindBy(xpath = "//div[contains(@class,'grid')]/div[2]//div[2]")
	private WebElement rera;

	@FindBy(xpath = "//div[contains(@class,'grid')]/div[3]//div[2]")
	private WebElement propertyType;

	@FindBy(xpath = "//input[@placeholder='Enter Property Title']")
	private WebElement propertyTitle;

	@FindBy(xpath = "//div[contains(@class,'grid')]/div[5]//div[2]")
	private WebElement emirates;

	@FindBy(xpath = "//div[contains(@class,'grid')]/div[6]//div[2]")
	private WebElement zone;

	@FindBy(xpath = "//input[@placeholder='Enter Address']")
	private WebElement address;

	@FindBy(xpath = "//input[@placeholder='Enter Title Deed Number']")
	private WebElement titleDeed;

	@FindBy(xpath = "//div[contains(@class,'grid')]/div[9]//div[2]")
	private WebElement bed;

	@FindBy(xpath = "//div[contains(@class,'grid')]/div[10]//div[2]")
	private WebElement bath;

	@FindBy(xpath = "//input[@placeholder='Enter Unit / Building Name']")
	private WebElement unit;

	@FindBy(xpath = "//input[@placeholder='Enter Total Area in Sqft']")
	private WebElement sqft;

	@FindBy(xpath = "//div[@data-testid='flowbite-navbar-collapse']//span/*")
	private WebElement clickSide;

	@FindBy(xpath = "//div[contains(@class,'grid')]/div[13]//div[2]")
	private WebElement occupied;

	@FindBy(xpath = "//input[@placeholder='Enter Makani Number']")
	private WebElement makani;

	@FindBy(xpath = "//input[@placeholder='Enter Floor Number']")
	private WebElement floor;

	@FindBy(xpath = "//input[@placeholder='Enter Building Number']")
	private WebElement buildingNumber;

	@FindBy(xpath = "//input[@placeholder='Enter DEWA Premise Number']")
	private WebElement DEWANumber;

	@FindBy(xpath = "//div[@class='grid lg:grid-cols-3 sm:grid-cols-2 grid-cols-1 gap-x-10 gap-y-10 mt-6']/div[18]/div/div/div[2]")
	private WebElement ClickAmenities;

	@FindBy(xpath = "//div[@class='grid lg:grid-cols-3 sm:grid-cols-2 grid-cols-1 gap-x-10 gap-y-10 mt-6']/div[18]/div/div/div[2]")
	private WebElement SelectAmenities;

	@FindBy(xpath = "//div[@class='border border-borderColor rounded-xl p-5 mt-2 flex justify-between items-center']/div[2]/button")
	private WebElement Clickprivateorpublic;

	@FindBy(xpath = "//div[@class='border border-borderColor rounded-xl overflow-hidden mt-2 flex flex-col']/label/input[@id='property_status_spacira']")
	private WebElement ClickSpacira;

	@FindBy(xpath = "//div[@class='flex items-center gap-2 mt-4']/input")
	private WebElement Clickterms;

	@FindBy(xpath = "//div[@class='flex justify-end gap-3 mt-4']/button[2]")
	private WebElement ClickMByS;

	@FindBy(xpath = "//div[@class='border border-borderColor rounded-xl overflow-hidden mt-2 flex flex-col']/label/input[@id='property_status_self']")
	private WebElement ClickSelfManaged;

	@FindBy(xpath = "//div[@class='flex gap-5 justify-end px-5 mt-5']/button[1]")
	private WebElement ClickCancel;

	@FindBy(xpath = "//div[@class='relative flex flex-col rounded-lg bg-white dark:bg-darkgray cust_height mb-10']/div[1]/div[1]/*[name()='svg']/*[2]")
	private WebElement Clickexit;

	@FindBy(xpath = "//div[@class='flex gap-5 justify-end px-5 mt-5']/button[2]")
	private WebElement ClickContinue;

	// Main Method

	public void Basic_Vacant() throws IOException, InterruptedException {

		ExcelUtils excel = new ExcelUtils(
				"C:\\Users\\Hariprasath\\OneDrive - CLOUDREVEL INNOVATIONS\\Desktop\\SPACIRAPHASE-2.xlsx",
				"BASIC-Vacant");

		type(propertyOwner, excel.getData(3, 0));
		selectDropdown(rera, excel.getData(3, 1));
		selectDropdown(propertyType, excel.getData(3, 2));

		type(propertyTitle, excel.getData(5, 0));
		selectDropdown(emirates, excel.getData(5, 1));

		js.executeScript("window.scrollBy(0,400)");
		selectDropdown(zone, excel.getData(5, 2));

		type(address, excel.getData(7, 0));
		type(titleDeed, excel.getData(7, 1));

		selectDropdown(bed, excel.getData(7, 2));
		selectDropdown(bath, excel.getData(9, 0));

		type(unit, excel.getData(9, 1));
		type(sqft, excel.getData(9, 2));

		click(clickSide);
		js.executeScript("window.scrollBy(0,400)");
		selectDropdown(occupied, excel.getData(11, 0));

		type(makani, excel.getData(11, 1));
		type(floor, excel.getData(11, 2));

		type(buildingNumber, excel.getData(13, 0));
		type(DEWANumber, excel.getData(13, 1));

		js.executeScript("window.scrollBy(0,400)");
		selectDropdown(SelectAmenities, excel.getData(13, 2));
		for (int i = 0; i < 4; i++) {
			act.sendKeys(Keys.TAB).perform();
		}
		js.executeScript("window.scrollBy(0,400)");

		for (int i = 0; i < 2; i++) {
			click(Clickprivateorpublic);
		}

		click(ClickSpacira);
		click(Clickterms);
		click(ClickMByS);
//		click(ClickSelfManaged);

		js.executeScript("window.scrollBy(0,400)");
		click(ClickCancel);
		click(Clickexit);
		click(ClickContinue);

		excel.close();
	}

	public void Basic_Occupied() throws IOException, InterruptedException {

		ExcelUtils excel = new ExcelUtils(
				"C:\\Users\\Hariprasath\\OneDrive - CLOUDREVEL INNOVATIONS\\Desktop\\SPACIRAPHASE-2.xlsx",
				"BASIC-Occupied");

		//type(propertyOwner, excel.getData(3, 0));
		selectDropdown(rera, excel.getData(3, 1));
		selectDropdown(propertyType, excel.getData(3, 2));

		type(propertyTitle, excel.getData(5, 0));
		selectDropdown(emirates, excel.getData(5, 1));

		js.executeScript("window.scrollBy(0,400)");
		selectDropdown(zone, excel.getData(5, 2));

		type(address, excel.getData(7, 0));
		type(titleDeed, excel.getData(7, 1));

		selectDropdown(bed, excel.getData(7, 2));
		selectDropdown(bath, excel.getData(9, 0));

		type(unit, excel.getData(9, 1));
		type(sqft, excel.getData(9, 2));

		click(clickSide);
		js.executeScript("window.scrollBy(0,400)");
		selectDropdown(occupied, excel.getData(11, 0));

		type(makani, excel.getData(11, 1));
		type(floor, excel.getData(11, 2));

		type(buildingNumber, excel.getData(13, 0));
		type(DEWANumber, excel.getData(13, 1));

		js.executeScript("window.scrollBy(0,400)");
		selectDropdown(SelectAmenities, excel.getData(13, 2));
		for (int i = 0; i < 4; i++) {
			act.sendKeys(Keys.TAB).perform();
		}
		js.executeScript("window.scrollBy(0,400)");

		for (int i = 0; i < 2; i++) {
			click(Clickprivateorpublic);
		}

		click(ClickSpacira);
		click(Clickterms);
		click(ClickMByS);
		// click(ClickSelfManaged);

		js.executeScript("window.scrollBy(0,400)");
		click(ClickCancel);
		click(Clickexit);
		click(ClickContinue);

		excel.close();
	}

}

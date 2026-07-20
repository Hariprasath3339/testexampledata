package POM;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base.Baseclass;
import Utilities.*;

public class ROI extends Baseclass {

	// Constructor
	public ROI(WebDriver driver) throws IOException, AWTException {
		super(driver);
	}

	// Locators

	@FindBy(xpath = "//div[@class='w-full mx-auto lg:p-6 p-3 pb-5']/form/div[1]/div[1]/div/div/input")
	private WebElement AnnualRentalIncome;

	@FindBy(xpath = "//div[@class='flex gap-5 items-center']/button")
	private WebElement ClickROI;

	@FindBy(xpath = "//div[@class='grid lg:grid-cols-3 sm:grid-cols-2 grid-cols-1 gap-x-10 gap-y-10 sm:px-5 py-4']/div[1]/div/div/input")
	private WebElement PurchaseDate;

	@FindBy(xpath = "//div[@class='grid lg:grid-cols-3 sm:grid-cols-2 grid-cols-1 gap-x-10 gap-y-10 sm:px-5 py-4']/div[2]/div/input")
	private WebElement TotalInvestmentCost;

	@FindBy(xpath = "//div[@class='grid lg:grid-cols-3 sm:grid-cols-2 grid-cols-1 gap-x-10 gap-y-10 sm:px-5 py-4']/div[3]/div/input")
	private WebElement AnnualExpense;

	@FindBy(xpath = "//div[@class='flex gap-5 justify-end px-5 mt-5']/button[1]")
	private WebElement ClickCancel;

	@FindBy(xpath = "//div[@class='relative flex flex-col rounded-lg bg-white dark:bg-darkgray cust_height mb-10']/div[1]/div[1]/*[name()='svg']/*[2]")
	private WebElement Clickexit;

	@FindBy(xpath = "//div[@class='flex gap-5 justify-end px-5 mt-5']/button[2]")
	private WebElement ClickContinue;

	@FindBy(xpath = "//div[@class='flex gap-5 justify-end px-5 mt-5']/button[2]")
	private String Continue;

	// Main Methods
	public void ROIESTIMATOR() throws IOException, InterruptedException {

		ExcelUtils excel = new ExcelUtils(
				"C:\\Users\\Hariprasath\\OneDrive - CLOUDREVEL INNOVATIONS\\Desktop\\SPACIRAPHASE-2.xlsx",
				"ROI-Vacant");

		type(AnnualRentalIncome, excel.getData(1, 0));
		click(ClickROI);
		type(PurchaseDate, excel.getData(1, 1));
		type(TotalInvestmentCost, excel.getData(3, 0));
		type(AnnualExpense, excel.getData(3, 1));

		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(2000);

		click(ClickCancel);
		click(Clickexit);
		click(ClickContinue);

		// excel.close();
	}

}

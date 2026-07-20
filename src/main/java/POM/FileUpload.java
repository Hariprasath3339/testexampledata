package POM;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base.Baseclass;
import Utilities.*;

public class FileUpload extends Baseclass {

	// Constructor
	public FileUpload(WebDriver driver) throws IOException, AWTException {
		super(driver);
	}

	// LOCATORS

	@FindBy(xpath = "//div[@class='grid lg:grid-cols-2 sm:grid-cols-2 grid-cols-1 gap-10 lg:py-4']/div[1]//button")
	private WebElement TitleDeed;

	@FindBy(xpath = "//div[@class='grid lg:grid-cols-2 sm:grid-cols-2 grid-cols-1 gap-10 lg:py-4']/div[2]//button")
	private WebElement PropertyImages;

	@FindBy(xpath = "//div[@class='grid lg:grid-cols-2 sm:grid-cols-2 grid-cols-1 gap-10 lg:py-4']/div[3]//button")
	private WebElement PurchaseReceipt;

	@FindBy(xpath = "//div[@class='grid lg:grid-cols-2 sm:grid-cols-2 grid-cols-1 gap-10 lg:py-4']/div[4]//button")
	private WebElement OtherDocuments;

	@FindBy(xpath = "//div[@class='flex gap-5 justify-end px-5 mt-5']/button[1]")
	private WebElement ClickCancel;

	@FindBy(xpath = "//div[@class='relative flex flex-col rounded-lg bg-white dark:bg-darkgray cust_height mb-10']/div[1]/div[1]/*[name()='svg']/*[2]")
	private WebElement Clickexit;

	@FindBy(xpath = "//div[@class='flex gap-5 justify-end px-5 mt-5']/button[2]")
	private WebElement ClickContinue;

	@FindBy(xpath = "//input[@placeholder='Enter Tenant E-mail ID']")
	private WebElement EnterEmail;

	@FindBy(xpath = "//input[@placeholder='Enter Mobile Number']")
	private WebElement Entermobile;

	@FindBy(xpath = "//input[@name='lease_start_date']")
	private WebElement Leasestartdate;

	@FindBy(xpath = "//div[@class='ant-picker-body']/table/tbody/tr/td[@title='2026-01-01']")
	private WebElement Leasestartdateclick;

	@FindBy(xpath = "//input[@placeholder='Enter Total Lease Amount']")
	private WebElement Totalleaseamt;

	@FindBy(xpath = "//input[@name='lease_end_date']")
	private WebElement leaseenddate;

	@FindBy(xpath = "(//div[@class='ant-picker-body']/table/tbody/tr/td[@title='2026-01-31'])[last()]")
	private WebElement leaseenddateclick;

	@FindBy(xpath = "//input[@placeholder='Enter Security Deposit Amount']")
	private WebElement entersecuritydeposit;

	@FindBy(xpath = "//input[@name='payment_date']")
	private WebElement enterpaymentdate;

	@FindBy(xpath = "(//td[@title='2026-01-22'])[3]")
	private WebElement enterpaymentdateclick;

	@FindBy(xpath = "//input[@placeholder='Enter Tenant Name']")
	private WebElement entertenantname;

	// MAIN METHOD

	public void FILEUPLOAD_Vacant() throws IOException, InterruptedException {

		ExcelUtils excel = new ExcelUtils(
				"C:\\Users\\Hariprasath\\OneDrive - CLOUDREVEL INNOVATIONS\\Desktop\\SPACIRAPHASE-2.xlsx",
				"File Upload-Vacant");

		uploadFile(TitleDeed, excel.getData(1, 0));
		uploadFile(PropertyImages, excel.getData(1, 1));

		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);

		uploadFile(PurchaseReceipt, excel.getData(3, 0));
		uploadFile(OtherDocuments, excel.getData(3, 1));

		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(2000);

		click(ClickCancel);
		click(Clickexit);
		click(ClickContinue);

	}

	public void FILEUPLOAD_Occupied() throws IOException, InterruptedException {

		ExcelUtils excel = new ExcelUtils(
				"C:\\Users\\Hariprasath\\OneDrive - CLOUDREVEL INNOVATIONS\\Desktop\\SPACIRAPHASE-2.xlsx",
				"File Upload-Occupied");

		type(EnterEmail, excel.getData(1, 1));
		type(Entermobile, excel.getData(1, 2));

		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,150)");
		Thread.sleep(2000);

		click(Leasestartdate);
		click(Leasestartdateclick);

		type(Totalleaseamt, excel.getData(3, 0));
		click(leaseenddate);
		click(leaseenddateclick);
		type(entersecuritydeposit, excel.getData(3, 1));

		click(enterpaymentdate);
		click(enterpaymentdateclick);

		type(entertenantname, excel.getData(1, 0));

		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,350)");
		Thread.sleep(2000);

		uploadFile(TitleDeed, excel.getData(7, 0));
		uploadFile(PropertyImages, excel.getData(7, 1));

		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,450)");
		Thread.sleep(2000);

		uploadFile(PurchaseReceipt, excel.getData(9, 0));
		uploadFile(OtherDocuments, excel.getData(9, 1));

		js.executeScript("window.scrollBy(0,100)");

		click(ClickCancel);
		click(Clickexit);
		click(ClickContinue);

	}

}

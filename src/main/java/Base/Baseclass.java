package Base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Baseclass {

	public static WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public Actions act;
	public Robot robot;

	public Baseclass(WebDriver driver) throws IOException, AWTException {
		Baseclass.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		js = (JavascriptExecutor) driver;
		act = new Actions(driver);
		robot = new Robot();
	}

	
	protected void type(WebElement element, String value) {
		wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(value);
		
	}

	protected void click(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	
	
	protected void selectDropdown(WebElement dropdown, String value) {
		wait.until(ExpectedConditions.elementToBeClickable(dropdown)).click();
		By option = By.xpath("//*[(text())='" + value + "']");
		wait.until(ExpectedConditions.elementToBeClickable(option)).click();
	}

	
	protected void clearAndType(WebElement element, String value) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(Keys.DELETE);
		element.sendKeys(value);
	}

	protected void clearAndSelectDropdown(WebElement dropdown, String value) {
		wait.until(ExpectedConditions.elementToBeClickable(dropdown)).click();
		By option = By.xpath("//*[(text())='" + value + "']");
		wait.until(ExpectedConditions.elementToBeClickable(option)).click();
	}

	protected void uploadFile(WebElement element, String filePath) throws InterruptedException {

		click(element);
		StringSelection file = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);

		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		Thread.sleep(500);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(2000);
	}

	protected void moveToElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		act.moveToElement(element).pause(Duration.ofSeconds(1)).perform();
	}

	
	
	
	public static String getScreenshotAsPath() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);

		String path = System.getProperty("user.dir") + "/test-output/screenshots/" + System.currentTimeMillis()
				+ ".png";

		FileUtils.copyFile(src, new File(path));
		return path;
	}

	
	
	
	
	
}

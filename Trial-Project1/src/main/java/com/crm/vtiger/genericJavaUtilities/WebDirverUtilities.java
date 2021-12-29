package com.crm.vtiger.genericJavaUtilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDirverUtilities {

	/**
	 * This method is to use implicitwait
	 * 
	 * @param driver
	 */
	public void implicit(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	

	/**
	 * This method is to use for explicitwait
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementVisiblelity(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	/**
	 * This method is to use for pageLoad wait
	 * 
	 * @param driver
	 */
	public void waitUntilPageLoad(WebDriver driver) {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.findElement(By.id(""));
	}

	/**
	 *  This method is to use for Dropdown using text
	 * 
	 * @param element
	 * @param text
	 * @param index
	 * @param value
	 */
	public void selectDropDown(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * This method is to use for select dropdown using index
	 * @param element
	 * @param index
	 */
	public void selectDropDown(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * This method is to use for selecdropdown using value
	 * @param value
	 * @param element
	 */
	public void selectDropDown(String value, WebElement element) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * This method is to use for mousehouver
	 * @param driver
	 * @param target
	 */
	public void mouseHover(WebDriver driver, WebElement target) {

		Actions act = new Actions(driver);
		act.moveToElement(target).build().perform();
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element) {
		Actions act1 = new Actions(driver);
		act1.contextClick(element).build().perform();
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions act2 = new Actions(driver);
		act2.doubleClick(element).build().perform();
	}
	/**
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchToWindows(WebDriver driver, int index) {
		ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(index));
		
		
	}
	/**
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		Alert aler = driver.switchTo().alert();
		aler.accept();
	}
	/**
	 * 
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver) {
		Alert aler = driver.switchTo().alert();
		aler.dismiss();
	}
	/**
	 * 
	 * @param driver
	 * @param text
	 * @return
	 */
	public String promptPop(WebDriver driver, String text) {

		Alert aler = driver.switchTo().alert();
		aler.sendKeys(text);
		return aler.getText();
	}
	/**
	 * 
	 * @param driver
	 * @param fileLocation
	 * @param fileExtension
	 * @throws IOException
	 */
	public String takeScreenshot(WebDriver driver, String fileLocation, String fileExtension) throws IOException {
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File(fileLocation +  fileExtension));
		String path = fileLocation;
		return path;
		
	}
	/**
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * 
	 * @param driver
	 * @param locator
	 */
	public void switchFrame(WebDriver driver, String locator) {
		driver.switchTo().frame(locator);
	}
	/**
	 * 
	 * @param driver
	 * @param argument
	 * @param element
	 */
	public void scrollToWebElement(WebDriver driver, String argument, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(argument, element);
	}
}
 
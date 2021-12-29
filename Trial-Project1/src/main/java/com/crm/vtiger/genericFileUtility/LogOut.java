package com.crm.vtiger.genericFileUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LogOut {
	
	public void logOut(WebDriver driver) {

		WebElement Industry = driver.findElement(By.xpath("//span[@class='userName']/following::img[1]"));
		Actions ref = new Actions(driver);
		ref.moveToElement(Industry).perform();
		driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();	
	}

}

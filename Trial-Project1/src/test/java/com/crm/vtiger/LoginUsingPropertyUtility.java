package com.crm.vtiger;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.genericFileUtility.PropertyFileUtility;

public class LoginUsingPropertyUtility {
	
	public WebDriver driver;
	public void readLoginDetailFromProperty() throws IOException {
		
		PropertyFileUtility pf = new PropertyFileUtility();
		String brw = pf.readDataFromProperty("Browser");
		String url = pf.readDataFromProperty("Url");
		String un = pf.readDataFromProperty("Username");
		String pwd = pf.readDataFromProperty("Password");
		
		driver.get(url);
		//driver.findElement(By.xpath("//div[text()='User Name']/following::input")).sendKeys(un);
		//driver.findElement(By.xpath("//div[text()='User Name']/following::input[2]")).sendKeys(pwd);
		//driver.findElement(By.id("submitButton")).click();
		
	}

}

package com.crm.vtiger;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.genericFileUtility.JsonFileUtility;

public class LoginUsingJsonUtility {
	
	@Test
	public void loginUsingJson() throws IOException, ParseException {
	
	JsonFileUtility jf = new JsonFileUtility();
	String url = jf.readDataFromJson("Url");
	String un = jf.readDataFromJson("Username");
	String pwd = jf.readDataFromJson("Pwd");
	String bwr = jf.readDataFromJson("Browser");
	WebDriver driver= new ChromeDriver();
	driver.get(url);
	driver.findElement(By.xpath("//div[text()='User Name']/following::input")).sendKeys(un);
	driver.findElement(By.xpath("//div[text()='User Name']/following::input[2]")).sendKeys(pwd);
	driver.findElement(By.id("submitButton")).click(); 
}
}
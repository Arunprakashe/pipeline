package com.crm.vtiger;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.vtiger.genericFileUtility.BaseClass;


public class DependsOnMethod extends BaseClass{
	
public void login() {
		
		driver.findElement(By.xpath("//div[text()='User Name']/following::input")).sendKeys("admin");
		driver.findElement(By.xpath("//div[text()='User Name']/following::input[2]")).sendKeys("admin");
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
}
	
	@Test(dependsOnMethods="login")
	public void addToCard() {
		
}
}
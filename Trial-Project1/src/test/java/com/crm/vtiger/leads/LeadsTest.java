package com.crm.vtiger.leads;

import org.testng.annotations.Test;

import com.crm.vtiger.genericFileUtility.BaseClass;
import com.crm.vtiger.genericJavaUtilities.WebDirverUtilities;
import com.crm.vtiger.objectRepository.HomePage;

public class LeadsTest extends BaseClass {
	
	WebDirverUtilities wb = new WebDirverUtilities();
	@Test
	public void tc_01() {
		HomePage hp = new HomePage(driver);  
			
		hp.leadsClk();
	//driver.findElement(By.xpath("(//a[text()='Leads'])[1]")).click();
	//driver.findElement(By.xpath("(//a[text()='Leads'])[2]/following::img[1]")).click();		
	}
	/*
	@Test
	public void tc_02() {

		driver.findElement(By.xpath("(//a[text()='Leads'])[1]")).click();
		driver.findElement(By.xpath("(//a[text()='Leads'])[2]/following::img[1]")).click();		
		driver.findElement(By.name("firstname")).sendKeys("kut");
		driver.findElement(By.name("lastname")).sendKeys("poon");
		driver.findElement(By.name("company")).sendKeys("petsh");
		
	}
	 
	@Test(groups="SmokeTest")
	
	public void tc_03(){
		driver.findElement(By.xpath("(//a[text()='Leads'])[1]")).click();
		driver.findElement(By.xpath("(//a[text()='Leads'])[2]/following::img[1]")).click();		
		
		driver.findElement(By.name("firstname")).sendKeys("kut");
		driver.findElement(By.name("lastname")).sendKeys("poon");
		driver.findElement(By.name("company")).sendKeys("petsh");
		driver.findElement(By.id("designation")).sendKeys("Gm");
		
		WebElement element = driver.findElement(By.name("leadsource"));
		String text = "Word of mouth";
		wb.selectDropDown(element , text);
		
		WebElement element1 = driver.findElement(By.name("industry"));
		String text1 = "Apparel";
		wb.selectDropDown(element1, text1);
		
		driver.findElement(By.name("annualrevenue")).sendKeys("50000000");
		driver.findElement(By.id("noofemployees")).sendKeys("5000");
		driver.findElement(By.id("secondaryemail")).sendKeys("vadvadvad@sfge.com");
		driver.findElement(By.id("phone")).sendKeys("65641656");
		driver.findElement(By.id("mobile")).sendKeys("64646661");
		driver.findElement(By.id("fax")).sendKeys("641f165ev");
		driver.findElement(By.id("email")).sendKeys("dvsdvsd@efr.com");
		driver.findElement(By.name("website")).sendKeys("www.sssss.com");
		
		WebElement element2=driver.findElement(By.name("leadstatus"));
		String text2="Cold";
		wb.selectDropDown(element2, text2);
		
		WebElement element3=driver.findElement(By.name("rating"));
		String text3="Active";
		wb.selectDropDown(element3, text3);
		
		driver.findElement(By.name("lane")).sendKeys("Street");
		driver.findElement(By.id("pobox")).sendKeys("pobox");
		driver.findElement(By.id("code")).sendKeys("646466");
		driver.findElement(By.id("city")).sendKeys("la");
		driver.findElement(By.id("country")).sendKeys("usa");
		driver.findElement(By.id("state")).sendKeys("cali");
		driver.findElement(By.name("description")).sendKeys("just");
		driver.findElement(By.name("button")).click();
	} */
}

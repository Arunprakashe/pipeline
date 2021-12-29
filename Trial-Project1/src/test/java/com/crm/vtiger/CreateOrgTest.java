package com.crm.vtiger;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateOrgTest {
WebDriver driver;
	@BeforeTest
	public void launchBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Se\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	@BeforeClass
	public void enterUrl() {
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void createOrg() {
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("(//a[text()='Organizations'])[2]/following::a[1]")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("km");
		driver.findElement(By.xpath("//input[@name='account_name']/following::img[1]")).click();
		
		String parent = driver.getWindowHandle();
		
	ArrayList<String> navi = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(navi.get(1));
		driver.findElement(By.xpath("//a[text()='Vj']")).click();
		
		Alert aler = driver.switchTo().alert();
		aler.accept();
		
		driver.switchTo().window(parent);
		driver.findElement(By.name("button")).click();

	}
	
	@BeforeMethod
	public void login() {

		driver.findElement(By.xpath("//div[text()='User Name']/following::input")).sendKeys("admin");
		driver.findElement(By.xpath("//div[text()='User Name']/following::input[2]")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
	}
	
	
	@AfterMethod
	
	public void logOut() {
		WebElement Industry = driver.findElement(By.xpath("//span[@class='userName']/following::img[1]"));
		Actions ref = new Actions(driver);
		ref.moveToElement(Industry).perform();
		driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
}

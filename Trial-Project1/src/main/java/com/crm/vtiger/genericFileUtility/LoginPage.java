package com.crm.vtiger.genericFileUtility;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	 PropertyFileUtility pf = new PropertyFileUtility();
	 WebDriver driver;
	  public LoginPage(WebDriver driver) {
		  
		  this.driver=driver;
		  PageFactory.initElements(driver, this);
	}
		

		@FindBy(xpath="//div[text()='User Name']/following::input")
		private WebElement username;
		
		@FindBy(xpath="//div[text()='User Name']/following::input[2]")
		private WebElement password;
		
		@FindBy(id="submitButton")
		private WebElement loginbutton;
		
		/*public WebElement uName() {
			return username;	
		}

		public WebElement pwd() {
			return password;	
		}

		public WebElement loginBtn() {
			return loginbutton;	
		}*/
		
		public void loginToApp(String UN , String Pwd) throws IOException {
			//LoginPage lp = new LoginPage(driver);
			username.sendKeys(UN);
			password.sendKeys(Pwd);
			loginbutton.click();
		}
		
		//driver.findElement(By.xpath("//div[text()='User Name']/following::input")).sendKeys(pf.readDataFromProperty("Username"));		
		//driver.findElement(By.xpath("//div[text()='User Name']/following::input[2]")).sendKeys(pf.readDataFromProperty("Password"));
		//driver.findElement(By.id("submitButton")).click();	
	}



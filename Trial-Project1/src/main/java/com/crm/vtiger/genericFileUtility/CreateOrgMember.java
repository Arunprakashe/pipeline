package com.crm.vtiger.genericFileUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.genericJavaUtilities.JavaUtilities;
import com.crm.vtiger.genericJavaUtilities.WebDirverUtilities;

public class CreateOrgMember extends WebDirverUtilities {
	WebDriver driver; 
	public CreateOrgMember(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='hdrLink']/following::img[1]")
	private WebElement orgplus;
	
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement enterAccname;
	
	@FindBy(xpath="//input[@name='account_name']/following::img[1]")
	private WebElement clickMemPlus;
	
	@FindBy(xpath = "//a[text()='Vj']")
	private WebElement selectName;
	
	@FindBy(name="button")
	private WebElement savebutton;
	
	public WebElement orgPlusClick() {
		return orgplus;
		
	}
	public WebElement accName() {
		return enterAccname;
	}
	
	public WebElement memPlus() {
		
		return clickMemPlus;
	}
	
	public WebElement selectName() {
		return selectName;
		
	}
	
	public WebElement saveButton() {
		return savebutton;
	}
	public void enteraccName() {
		//CreateOrgMember memb = new CreateOrgMember(driver);
		WebDirverUtilities wb = new WebDirverUtilities();
		JavaUtilities ju = new  JavaUtilities();
		orgPlusClick().click();
		accName().sendKeys("kmo"+ ju.getRamdomNumber()) ;
		memPlus().click();
		//selectName().click();
		//saveButton().click();
	}
}

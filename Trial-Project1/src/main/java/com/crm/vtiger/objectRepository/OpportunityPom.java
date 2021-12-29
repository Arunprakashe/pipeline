package com.crm.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.genericJavaUtilities.WebDirverUtilities;

public class OpportunityPom extends WebDirverUtilities {
	public WebDriver driver;

	public OpportunityPom(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="(//a[@class='hdrLink'])[1]//following::img[1]")
private WebElement oppclk;

public WebElement getOppclk() {
	return oppclk;
}

public void opportunityPlus() {
	getOppclk().click();
}

@FindBy(xpath = "(//input[@class='crmbutton small save'])[1]")
private WebElement savebutton;

public WebElement getSavebutton() {
	return savebutton;
}

public void saveClick() {
	getSavebutton().click();
}
}

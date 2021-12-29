package com.crm.vtiger.opportunity;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.vtiger.genericFileUtility.BaseClass;
import com.crm.vtiger.genericJavaUtilities.JavaUtilities;
import com.crm.vtiger.objectRepository.HomePage;
import com.crm.vtiger.objectRepository.OpportunityPom;

public class Tc_03_Test extends BaseClass {
	
@Test (groups = {"SmokeTest","Regression"})
public void oppurtunityTest() {
	
	HomePage hp =new HomePage(driver);
	hp.opportunityClk();
	
	OpportunityPom opp = new OpportunityPom(driver);
	opp.opportunityPlus();
	JavaUtilities ju = new JavaUtilities();
	driver.findElement(By.xpath("//input[@name='potentialname']")).sendKeys("sfwfw"+ju.getRamdomNumber());
	opp.saveClick();
}

}

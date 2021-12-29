package com.crm.vtiger.leads;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.vtiger.genericFileUtility.BaseClass;
import com.crm.vtiger.genericFileUtility.CreateOrgMember;
import com.crm.vtiger.genericJavaUtilities.WebDirverUtilities;
import com.crm.vtiger.objectRepository.HomePage;
//@Listeners(com.crm.vtiger.genericFileUtility.ListenerImp.class)
public class Tc_7_Test extends BaseClass {
	//retryAnalyzer = com.crm.vtiger.genericFileUtility.RetryAnalyser.class
	@Test(groups= {"SmokeTest"}) 
	public void clear() throws InterruptedException {
		
		HomePage hp = new HomePage(driver);
		hp.orgclk();
		
		CreateOrgMember mem = new CreateOrgMember(driver);
		mem.enteraccName();
		
		WebDirverUtilities wb= new WebDirverUtilities(); 
		wb.switchToWindows(driver, 1);
		mem.selectName().click();
		wb.acceptAlert(driver);
		
		
		wb.switchToWindows(driver, 0);
		mem.saveButton().click();
		//Assert.assertTrue(false);
		// System.out.println("sagWRV");
		Thread.sleep(10000);
		System.out.println("saved");
		
		//wb.switchToWindows(driver, 0);
		
		
		
		/*
		//String parent = new String(driver.getWindowHandle());
		//ArrayList<String> ref = new ArrayList<String>(driver.getWindowHandles());
		//driver.switchTo().window(ref.get(1));
		String parent = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		String child = null;
		for (String singleWin : windows) {
			if (singleWin.equals(parent))
					System.out.println("Parent window:"+parent);
			else
				child = singleWin;
		}
		System.out.println("Child Window:"+child);
		driver.switchTo().window(child);
		driver.findElement(By.xpath("//a[text()='Vj']")).click();
		Alert al = driver.switchTo().alert();
		al.accept();
		
		driver.switchTo().window(parent);
		driver.findElement(By.xpath("//input[@name='account_name']/following::input[2]")).click();
		driver.findElement(By.name("button")).click();
		System.out.println("Parent window:"+parent);
		
		/*WebElement Industry = driver.findElement(By.xpath("//span[@class='userName']/following::img[1]"));
		Actions act = new Actions(driver);
		act.moveToElement(Industry).perform();
		driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
	*/
		
	}
	

}

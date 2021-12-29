package com.crm.vtiger.genericFileUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.vtiger.genericJavaUtilities.JavaUtilities;
import com.crm.vtiger.genericJavaUtilities.WebDirverUtilities;
import com.crm.vtiger.objectRepository.HomePage;


public class BaseClass extends WebDirverUtilities {
	
	public WebDriver driver;

	//HomePage hp = new HomePage(driver);
	public WebDirverUtilities wb = new WebDirverUtilities();

	public static WebDriver statdriver;
	
	public DatabaseUtility db = new DatabaseUtility();
	public PropertyFileUtility pf = new PropertyFileUtility();
	public JsonFileUtility jf = new JsonFileUtility();
	public LoginPage log = new LoginPage(driver);
	public LogOut lo = new LogOut();
	public JavaUtilities ju = new JavaUtilities();

	@BeforeSuite
	public void connectToDb() throws SQLException {
		db.connectToDB();
	}
	//@Parameters("browser")
	@BeforeClass(groups = { "SmokeTest", "RegionalTest" ,"Regression"})
	public void launchBrowser() throws IOException {

		// System.setProperty("webdriver.chrome.driver",
		// "E:\\Se\\chromedriver_win32\\chromedriver.exe");
		// driver = new ChromeDriver();
		//String browser = pf.readDataFromProperty("Browser");
		
		String browser = System.getProperty("browser");
		if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("diff browser");
		}
		statdriver=driver;
		driver.manage().window().maximize();
		String url = pf.readDataFromProperty("Url");
		driver.get(url);
		wb.implicit(driver);

	}

	@BeforeMethod(groups = { "SmokeTest", "RegionalTest","Regression" })
	public void login() throws IOException {
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(pf.readDataFromProperty("Username"),pf.readDataFromProperty("Password"));
		
	}

	@AfterMethod(groups = { "SmokeTest", "RegionalTest","Regression" })
	public void logOut() {
		HomePage hp1 = new HomePage(driver);
		System.out.println("entering logout");
		//wb.waitForElementVisiblelity(driver, hp1.signHouver());
		System.out.println("after houver");
		hp1.logOut();
	}

	/*
	 * public void logOut() { lo.logOut(driver); }
	 */
	@AfterClass(groups = { "SmokeTest", "RegionalTest","Regression" })
	public void closeBrowser() {
		statdriver.close();
		//driver.close();
	}

	@AfterSuite
	public void closeDb() throws SQLException {
		db.close();
	}
}

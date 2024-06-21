package com.testScenarios;

import org.apache.commons.mail.EmailException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.baseclass.BaseMethods;
import com.baseclass.MailWithAttachment;
import com.degradeReport.javaclasses.Complogin;
import com.degradeReport.javaclasses.Homepage;
import com.degradeReport.javaclasses.UserLogin;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DegradeReport {

	public WebDriver driver;
	BaseMethods bm = new BaseMethods();
	Complogin clogin;
	UserLogin ulogin;
	Homepage homepage;
	

	@BeforeTest
	public void driverinfo() {

		bm.setupExtentReport(driver);
		bm.startTest(driver, "driver_info");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("start-maximized");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		bm.driverinfo(driver);
		bm.logInfo(driver, "driver info verified");
		
		

	}

	@Test(enabled = true, priority = 1,testName = "CompLogin")
	public void complogin() throws InterruptedException {
		
		bm.startTest(driver, "comp_login_Page");
		clogin = new Complogin();
		clogin.setCname(driver);
		System.out.println("Compname entered");
		bm.logInfo(driver, "username entered in complogin");
		clogin.setCpass(driver);
		bm.logInfo(driver, "password entered in complogin");
		clogin.clogin(driver);
		bm.logInfo(driver, "complogin button clicked");
		clogin.complogin_page_validate_url(driver);
	}

	@Test(enabled = true, priority = 2,testName = "UserLogin")
	public void userlogin() throws InterruptedException {
		bm.startTest(driver, "User_Login_page");
		ulogin = new UserLogin();
		ulogin.userPageValidate(driver);
		ulogin.setUname(driver);
		bm.logInfo(driver, "username entered");
		ulogin.setUpass(driver);
		bm.logInfo(driver, "password entered");
		ulogin.ulogin(driver);
		bm.logInfo(driver, "login successfull");
		ulogin.userlogin_page_validate_url(driver);
		bm.logInfo(driver, "userpage validated");
		

	}
	
	@Test(priority = 3, enabled=true,testName = "searchPNG_in_Homepage")
	public void searchpng() throws InterruptedException {
		homepage = new Homepage();
		homepage.searchPNG(driver);
		
		
		
	}

	@AfterTest
	public void tearDown() throws InterruptedException, EmailException {
		
		bm.endreport(driver);
		bm.endTest(driver);
		bm.browserclose(driver);
		System.out.println("Browser closed and report generated");
		
		//MailWithAttachment mwa = new MailWithAttachment();
		//mwa.sendReport();		
		
		}
		
	
}
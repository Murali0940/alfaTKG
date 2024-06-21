package com.testScenarios;

import org.apache.commons.mail.EmailException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.baseclass.Complogin;
import com.baseclass.UserLogin;
import com.basemethods.BaseMethods;
import com.basemethods.MailWithAttachment;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestCases {

	public WebDriver driver;
	BaseMethods bm = new BaseMethods();
	Complogin clogin;
	UserLogin ulogin;
	ExtentTest test;
	ExtentReports reports;

	@BeforeTest
	public void driverinfo() {

		reports = new ExtentReports("./ExtentReports/Report.html", true);
		test = reports.startTest("driver_info");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("start-maximized");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		bm.compURL(driver);
		test.log(LogStatus.INFO, "driver info verified");

	}

	@Test(priority = 1, enabled = true)
	public void complogin() throws InterruptedException {

		test = reports.startTest("company Login");
		clogin = new Complogin();
		clogin.setCname(driver);
		test.log(LogStatus.INFO, "Compname entered");
		System.out.println("Compname entered");
		clogin.setCpass(driver);
		test.log(LogStatus.INFO, "password entered");
		System.out.println("password entered");
		clogin.clogin(driver);
		test.log(LogStatus.INFO, "complogin sucessfull");
		clogin.complogin_page_validate_url(driver);
		test.log(LogStatus.INFO, "complogin validated");

	}

	@Test(priority = 2, enabled = true)
	public void userlogin() throws InterruptedException {
		test = reports.startTest("Username Login");
		ulogin = new UserLogin();
		ulogin.userPageValidate(driver);
		ulogin.setUname(driver);
		test.log(LogStatus.INFO, "username entered");
		ulogin.setUpass(driver);
		test.log(LogStatus.INFO, "password entered");
		ulogin.ulogin(driver);
		test.log(LogStatus.INFO, "login successfull");
		ulogin.userlogin_page_validate_url(driver);
		test.log(LogStatus.INFO, "userpage validated");

	}

	@AfterTest
	public void tearDown() throws InterruptedException, EmailException {
		
		bm.browserclose(driver);
		reports.endTest(test);
		reports.flush();
		System.out.println("Browser closed and report generated");
		
		MailWithAttachment mwa = new MailWithAttachment();
		mwa.sendReport();		
		
		}
		
	
}
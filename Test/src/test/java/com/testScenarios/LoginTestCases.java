package com.testScenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.baseclass.Complogin;
import com.basemethods.BaseMethods;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestCases {

	public WebDriver driver;
	BaseMethods bm = new BaseMethods();
	Complogin clogin = new Complogin();
	ExtentTest test;
	ExtentReports reports;

	@BeforeTest
	public void driverinfo() {

		reports = new ExtentReports("./ExtentReports/Report.html", true);
		test = reports.startTest("LoginTestCases");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("start-maximized");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		bm.compURL(driver);
		test.log(LogStatus.INFO, "driver info verified");

	}

	@Test(enabled = true)
	public void complogin() throws InterruptedException {

//		Thread.sleep(3000);

		clogin.setCname(driver);
		test.log(LogStatus.INFO, "Compname entered");
		System.out.println("Compname entered");
		clogin.setCpass(driver);
		test.log(LogStatus.INFO, "password entered");
		System.out.println("password entered");
		clogin.clogin(driver);
		test.log(LogStatus.INFO, "complogin sucessfull");

	}

	@AfterTest
	public void tearDown() throws InterruptedException {

		reports.endTest(test);
		reports.flush();
		test.log(LogStatus.INFO, "report generated");
		bm.browserclose(driver);

	}

}

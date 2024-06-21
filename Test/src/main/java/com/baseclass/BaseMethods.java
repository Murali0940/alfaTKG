package com.baseclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.HTMLReporter;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseMethods {

	public WebDriver driver;
	public ExtentReports reports = null;
	public ExtentTest test = null;

	public void driverinfo(WebDriver driver) {

		String URL = "https://www.alfadock-pack.com/";
		driver.get(URL);

	}

//	public int webdriverwait(int sec, String name) {
//		
//		// Create WebDriverWait instance with a timeout of 10 seconds
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
//
//		// Wait until the element with id "myButton" is clickable
//		wait.until(ExpectedConditions.elementToBeClickable(name)));
//		return sec;
//	}

	public void browserclose(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

	public void setupExtentReport(WebDriver driver) {
		reports = new ExtentReports("F:\\ScreenShotsAndExtentReport\\ExtentReport\\Report.html", true);

	}

	public void startTest(WebDriver driver, String testName) {
		test = reports.startTest(testName);

	}

	public void logInfo(WebDriver driver, String message) {
		test.log(LogStatus.INFO, message);

	}

	public void logPASS(WebDriver driver, String message) {
		test.log(LogStatus.PASS, message);

	}

	public void logFAIL(WebDriver driver, String message) {
		test.log(LogStatus.FAIL, message);

	}

	public void endTest(WebDriver driver) {
		reports.endTest(test);
	}

	public void endreport(WebDriver driver) {
		reports.flush();
	}

}

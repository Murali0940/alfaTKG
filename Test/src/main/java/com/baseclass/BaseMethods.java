package com.baseclass;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseMethods {

	public WebDriver driver;
	static ExtentReports reports;
	protected static ExtentTest test;

	public void driverinfo(WebDriver driver) {

		String URL = "https://www.alfadock-pack.com/";
		driver.get(URL);

	}

	public int waitkaro(int sec) {
		new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec)).pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		return sec;
	}
	
	

	public void browserclose(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

	public static void extentReports() {
		reports = new ExtentReports("./ExtentReports/Report.html", true);
		
	}
	
	public static String extenttest(String testname) {
		test = reports.startTest(testname);
		
		return testname;
		
	}

	
}

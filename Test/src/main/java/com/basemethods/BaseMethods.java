package com.basemethods;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseMethods {

	public WebDriver driver;
	ExtentReports reports;
	ExtentTest test;

	public void compURL(WebDriver driver) {

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

	

	
}

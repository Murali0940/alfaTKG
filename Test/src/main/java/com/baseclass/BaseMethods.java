package com.baseclass;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseMethods {

	public WebDriver driver;
	public ExtentReports reports = null;
	public ExtentTest test = null;
	public WebDriverWait wait;

	// driver info
	public void driverinfo(WebDriver driver) {

		String URL = "https://www.alfadock-pack.com/";
		driver.get(URL);

	}

	// close the browser
	public void browserclose(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

	// extent report path
	public void setupExtentReport(WebDriver driver) {
		// Get current timestamp
        LocalDateTime currentTime = LocalDateTime.now();
        
        // Format timestamp (optional)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String timestamp = currentTime.format(formatter);
        
		reports = new ExtentReports("F:\\ScreenShotsAndExtentReport\\ExtentReport\\Report_"+timestamp+".html", true);

	}

	// extent report start test
	public void startTest(WebDriver driver, String testName) {
		test = reports.startTest(testName);

	}

	// extent report logStatus.INFO
	public void logInfo(WebDriver driver, String message) {
		test.log(LogStatus.INFO, message);

	}

	// extent report logStatus.PASS
	public void logPASS(WebDriver driver, String message) {
		test.log(LogStatus.PASS, message);

	}

	// extent report logStatus.FAIL
	public void logFAIL(WebDriver driver, String message) {
		test.log(LogStatus.FAIL, message);

	}

	// extent report end test
	public void endTest(WebDriver driver) {
		reports.endTest(test);
	}

	// extent report end and generate the report.
	public void endreport(WebDriver driver) {
		reports.flush();
	}
	
	public Duration wait(WebDriver driver,Duration sec) {
        wait = new WebDriverWait(driver, sec); // Initialize WebDriverWait with a timeout of 10 seconds
		return sec;
    }
	
	public WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}

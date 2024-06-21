package com.degradeReport.javaclasses;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baseclass.BaseMethods;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Homepage extends BaseMethods{

	BaseMethods bm;
	JavascriptExecutor js;
	Actions act;
	
	
	public void searchPNG(WebDriver driver) throws InterruptedException {

		startTest(driver, "searchPNG");
		// search bar
		driver.findElement(By.xpath(
				"//input[@class='ng-untouched ng-pristine ng-valid ui-inputtext ui-corner-all ui-state-default ui-widget']"))
				.sendKeys(".png");

		logInfo(driver, "Png entered in search bar");
		System.out.println("Png entered in search bar");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// search button
		WebElement searchbutton = driver.findElement(By.xpath("//img[@src='assets/ai-search.png']"));
		logInfo(driver, "PNG file searched");
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchbutton);
		System.out.println("Clicked  search button");
		logInfo(driver, "search button clicked");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='imageDiv'])[1]")));
		element.click();
		logInfo(driver, "Result is displayed");
		System.out.println("Click the first displayed file ");
			}
}

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
import org.testng.Assert;

import com.baseclass.BaseMethods;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Homepage extends BaseMethods {

	BaseMethods bm = new BaseMethods();
	JavascriptExecutor js;
	Actions act;

	public String searchPNG(WebDriver driver, String name) throws InterruptedException {

		// bm.startTest(driver, "searchPNG");

		By searchbar = By.xpath(
				"//img[@src='assets/qr-code.png']/following::input[@placeholder='検索' or @placeholder='Search' and @class='ng-untouched ng-pristine ng-valid ui-inputtext ui-corner-all ui-state-default ui-widget']");

		// search bar
		driver.findElement(searchbar).sendKeys(name);

		bm.wait(driver, Duration.ofSeconds(10));
		// search button
		WebElement searchbutton = driver.findElement(By.xpath("//img[@src='assets/ai-search.png']"));

		bm.wait(driver, Duration.ofSeconds(10));
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchbutton);
		System.out.println("Clicked  search button");
		// bm.logInfo(driver, "Clicked search button");
		bm.wait(driver, Duration.ofSeconds(30));
		bm.waitForElementToBeClickable(By.xpath("(//div[@class='imageDiv'])[1]"));

		// double click
		act = new Actions(driver);
		By pngimage = By.xpath("(//div[@class='imageDiv'])[1]");
		act.doubleClick(driver.findElement(pngimage)).build().perform();
		// bm.logInfo(driver, "double clicked the file");
		bm.wait(driver, Duration.ofSeconds(30));
		// switching windows
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		// go to tab 2
		driver.switchTo().window(tabs2.get(1));
		// bm.logInfo(driver, "switched to tab1");
		String expectedURL = "https://www.alfadock-pack.com/ver10/#/drawing/9711/camera?filename=.png";
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(expectedURL, actualURL);

		if (expectedURL.equals(actualURL)) {
			System.out.println("png viewer displayed ");
			//bm.logPASS(driver, "Login successful!");
		} else {
			System.out.println("png viewer failed!");
			//bm.logFAIL(driver, "Login failed!");
		}

		Thread.sleep(5000);
		driver.close();
		driver.switchTo().window(tabs2.get(0));
		Thread.sleep(3000);
		// Go to homepage
		driver.findElement(By.xpath("//img[@src='assets/icons/logo.png']")).click();
		System.out.println("alfadock logo clicked");
		bm.wait(driver, Duration.ofSeconds(30));
		return name;

	}
}

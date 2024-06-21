package com.testScenarios;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.baseclass.BaseMethods;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestCases extends BaseMethods {

	public WebDriver driver;
	BaseMethods bm = new BaseMethods();

	@BeforeClass
	public void setUp() {
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

	@Test(enabled = true, priority = 1, testName = "comp_login_With_Valid_Credentials")
	public void loginWithValidCredentials() throws InterruptedException {

		bm.startTest(driver, "comp_login_With_Valid_Credentials");

		// Create WebDriverWait instance with a timeout of 10 seconds
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Wait until the element with id "myButton" is clickable
		wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
		// Enter username
		WebElement usernameField = driver.findElement(By.id("username"));
		usernameField.sendKeys("Atkgi");
		bm.logInfo(driver, "username entered");

		// Enter password
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("1234");
		bm.logInfo(driver, "password entered");

		// Click login button
		WebElement loginButton = driver.findElement(By.id("logmein"));
		loginButton.click();
		bm.logInfo(driver, "login button clicked");
		Thread.sleep(3000);

		WebElement logoutbutton = driver.findElement(By.id("logout"));
		if (logoutbutton.isDisplayed() == true) {
			bm.logPASS(driver, "login sucessfull");
			Thread.sleep(3000);
			logoutbutton.click();
		} else {
			bm.logFAIL(driver, "login failed");
		}
		
	}

	@Test(enabled = true, priority = 2, testName = "comp_login_With_Invalid_Credentials")
	public void loginWithInValidCredentials() throws InterruptedException {

		bm.startTest(driver, "comp_login_With_Invalid_Credentials");

		// Create WebDriverWait instance with a timeout of 10 seconds
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Wait until the element with id "myButton" is clickable
		wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));

		// Enter username
		WebElement usernameField = driver.findElement(By.id("username"));
		usernameField.sendKeys("Atkgi");
		bm.logInfo(driver, "username entered");

		// Enter password
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("123");
		bm.logInfo(driver, "password entered");

		// Click login button
		WebElement loginButton = driver.findElement(By.id("logmein"));
		loginButton.click();
		bm.logInfo(driver, "login button clicked");
		bm.logInfo(driver, "popup displayed");
		Thread.sleep(3000);
		By dialogbox = By.xpath("//h4[text()='ログインエラー']/following::button[text()='OK' or @class='btn btn-default']");
		driver.findElement(dialogbox).click();
		bm.logInfo(driver, "popup closed");
		
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		bm.endTest(driver);
		bm.endreport(driver);
		bm.browserclose(driver);
	}

}

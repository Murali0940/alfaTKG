package com.baseclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.basemethods.BaseMethods;

public class Complogin extends BaseMethods{
	
	
	By cname = By.id("username");
	By cpass = By.id("password");
	By clogin = By.id("logmein");

	public void setCname(WebDriver driver) throws InterruptedException {

		String compname = driver.findElement(By.id("companylogin")).getText();
		System.out.println(compname);
		Thread.sleep(2000);
		driver.findElement(By.id("username")).sendKeys("Atkgi");

	}

	public void setCpass(WebDriver driver) {
		driver.findElement(By.id("password")).sendKeys("1234");
	}

	public void clogin(WebDriver driver) throws InterruptedException {

		driver.findElement(By.id("logmein")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Thread.sleep(3000);
		String expectedURL = driver.getCurrentUrl();
		String actualURL = "https://www.alfadock-pack.com/userlogin.html";
		Assert.assertEquals(expectedURL, actualURL);

	}
	

}

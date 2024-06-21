package com.baseclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

	public UserLogin clogin(WebDriver driver) throws InterruptedException {

		driver.findElement(By.id("logmein")).click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return new UserLogin();

	}
	
	public void complogin_page_validate_url(WebDriver driver) throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String expectedURL = "https://www.alfadock-pack.com/userlogin.html";
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(expectedURL, actualURL);
		
		
	}
	

}

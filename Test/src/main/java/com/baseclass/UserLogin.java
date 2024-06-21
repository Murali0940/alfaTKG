package com.baseclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.basemethods.BaseMethods;

public class UserLogin extends BaseMethods{
	
	By uname = By.id("username");
	By upass = By.id("password");
	By ulogin = By.id("login");
	By Ulogout = By.id("logout");
	
	//Validation
	public void userPageValidate(WebDriver driver) {
		
		System.out.println("Username text is displayed: "+driver.findElement(By.id("username")).isDisplayed());
		System.out.println("password text is displayed: "+driver.findElement(By.id("password")).isDisplayed());
		System.out.println("login button is displayed: "+driver.findElement(By.id("login")).isDisplayed());
		System.out.println("logout button is displayed: "+driver.findElement(By.id("logout")).isDisplayed());
	}
	
	public void setUname(WebDriver driver) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.id("username")).sendKeys("admin");

	}
	
	public void setUpass(WebDriver driver) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys("admin");

	}
	
	public Homepage ulogin(WebDriver driver) throws InterruptedException {

		driver.findElement(By.id("login")).click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return new Homepage();

	}
	
	public void userlogin_page_validate_url(WebDriver driver) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(2000);
		String expectedURL = "https://www.alfadock-pack.com/ver10/#/home";
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(expectedURL, actualURL);
	}
	
	
	
	
	
	

}

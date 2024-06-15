package com.testScenarios;

import java.time.Duration;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.baseclass.Complogin;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestCases {
	
	WebDriver driver;

	@BeforeTest
	public void driverinfo() {
		String URL = "https://www.alfadock-pack.com/";
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("start-maximized");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Capabilities cap = ((ChromeDriver) driver).getCapabilities();
		System.out.println("Chrome Browser Name is " + cap.getBrowserName());
		System.out.println("Chrome Browser Version is " + cap.getBrowserVersion());
		System.out.println("Operating PlatForm name  is " + cap.getPlatformName());
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void complogin() throws InterruptedException {
		Complogin cl = new Complogin(driver);
		cl.setCname("Atkgi");
		Thread.sleep(1000);
		cl.setCpass("1234");
		Thread.sleep(1000);
		cl.clogin();
		Thread.sleep(2000);
		
	}
	
	@AfterTest
	public void Close() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}

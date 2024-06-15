package com.baseclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Complogin {
	WebDriver driver;

	By cname = By.id("username");
	By cpass = By.id("password");
	By login = By.id("logmein");

	public Complogin(WebDriver driver) {
		this.driver=driver;
	}

	public String setCname(String username) {
		driver.findElement(cname).sendKeys(username);
		return username;
	}
	
	public String setCpass(String password) {
		driver.findElement(cpass).sendKeys(password);
		return password;
	}
	
	public void clogin() {
		driver.findElement(login).click();
		
	}

}

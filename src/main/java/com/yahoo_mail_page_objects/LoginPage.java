package com.yahoo_mail_page_objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	By usernameInput = By.id("login-username");
	By passwordInput = By.id("login-passwd");
	By nextButton = By.id("login-signin");
	By signinButton = By.id("login-signin");
	
	public AccountPage loginWithValidUsernamePassword(String username,String password) throws InterruptedException{
		
		driver.findElement(usernameInput).clear();
		driver.findElement(usernameInput).sendKeys(username);
		driver.findElement(nextButton).click();
		Thread.sleep(5000);
		driver.findElement(passwordInput).sendKeys(password);
		driver.findElement(signinButton).click();
		Thread.sleep(10000);
		
		return new AccountPage(driver);
		
	}
}

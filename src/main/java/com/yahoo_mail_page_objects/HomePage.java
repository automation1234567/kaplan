package com.yahoo_mail_page_objects;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		driver.get("https://www.yahoo.com/");
	}

	By loginPageLink = By.xpath("//*[@id='uh-mail-link']");

	public LoginPage goToLoginPage(){
		driver.findElement(loginPageLink).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return new LoginPage(driver);
	}
}

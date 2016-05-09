package com.emailcheking;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utilities.ExcelDataReader;
import com.yahoo_mail_page_objects.AccountPage;
import com.yahoo_mail_page_objects.HomePage;
import com.yahoo_mail_page_objects.LoginPage;

public class MailTest {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Develop-Tools\\Browser_drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		Thread.sleep(5000);
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	@Test (dataProvider="excelReader", dataProviderClass=ExcelDataReader.class)
	public void checkMailTest(
			String username, String password,
			String textInSubject, String textInEmailBody)
			throws InterruptedException{
		
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		LoginPage lp = hp.goToLoginPage();
		AccountPage ap = lp.loginWithValidUsernamePassword(username, password);
		ap.checkMail();
		ap.verifyEmailContent(textInSubject, textInEmailBody);
	}
}

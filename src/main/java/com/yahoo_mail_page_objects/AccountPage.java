package com.yahoo_mail_page_objects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AccountPage {

	WebDriver driver;
	
	public AccountPage(WebDriver driver) throws InterruptedException{
		this.driver = driver;
	}
	
	public void checkMail(){
		
		WebElement inbox = driver.findElement(By.xpath("//*[@id='Inbox']/a"));
		String inboxTitleText=inbox.getAttribute("title");
		String inboxLabelText=inbox.getAttribute("aria-label");

		if (Integer.parseInt(inboxTitleText.replaceAll("[^0-9]",""))>0){
		System.out.println("Good day!");
		System.out.println("Dear user, you have "+ inboxTitleText.replaceAll("[^0-9]", "") +" email(s) in your inbox, "+ inboxLabelText.replaceAll("[^0-9]", "")+ " of them - unread.");
		System.out.println("********************************************");
		}
		else if (Integer.parseInt(inboxTitleText.replaceAll("[^0-9]",""))==0){
		System.out.println("Inbox is empty.");
		System.out.println("********************************************");
		}
	}
	
	public void verifyEmailContent(String textInSubject, String textInEmailBody) throws InterruptedException{
	
		List <WebElement> allEmailSubjects = driver.findElements(By.xpath("//*[starts-with(@class, 'list-view-item list-view-item-master')]/div[2]/div[2]/span[1]"));
		
		for (WebElement subjectElement : allEmailSubjects){
			String subjectText = subjectElement.getAttribute("title");
			if (subjectText.contains(textInSubject)){
				subjectElement.click();
				Thread.sleep(5000);
				WebElement senderInfo = driver.findElement(By.xpath(".//*[contains(@class, 'thread-item-header')]/div[1]/a[1]/span[1]"));

				if (driver.findElements(By.xpath("//*[contains(@class, 'body undoreset')]//*[contains(text(), '"+textInEmailBody+"')]")).size()>0){
					
					System.out.println("Following email has fully met search criteria (strings are found in the Subject and in the Body of email):");
					System.out.print("Name: <"+senderInfo.getAttribute("data-name")+">");
					System.out.println("    Email address: <"+senderInfo.getAttribute("data-address")+">");
					System.out.println("********************************************");			
				}
				else {
					
					System.out.println("Following email has partially met search criteria (strings are found in the Subject only):");
					System.out.print("Name: <"+senderInfo.getAttribute("data-name")+">");
					System.out.println("    Email: <"+senderInfo.getAttribute("data-address")+">");
					System.out.println("********************************************");			
				}
			}
		}
	}
}

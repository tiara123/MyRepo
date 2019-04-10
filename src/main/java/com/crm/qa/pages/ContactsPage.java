package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	
	@FindBy(xpath="//h1[@class='private-header__heading']")
	WebElement contactsLabel;
	
	@FindBy(xpath="//span[@data-key='contentToolbar.addContactButton']")
	WebElement createcontactBtn;
	
	@FindBy(xpath="//input[@data-field='email']")
	WebElement contactEmail;
	
	@FindBy(xpath="//input[@data-field='firstname']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@data-field='lastname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@data-field='jobtitle']")
	WebElement jobTitle;
	
	@FindBy(xpath="//li[1][@class='uiListItem private-list__item p-bottom-1']")
	WebElement createBtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel(){
		return contactsLabel.isDisplayed();
	}
	
	public void createNewContact(String email, String ftName, String ltName, String jbTitle) throws InterruptedException{
		createcontactBtn.click();
		
		contactEmail.sendKeys(email);
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		Thread.sleep(5000);
		jobTitle.sendKeys(jbTitle);
		createBtn.click();
		Thread.sleep(7000);
	}
	
}

package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(linkText="Contacts")
	WebElement contactsMenuLink;
	
	@FindBy(xpath="//a[@id='nav-secondary-contacts']")
	WebElement contactsLink;
	
	@FindBy(linkText="Sales")
	WebElement SalesMenuLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContactsLink(){
		contactsMenuLink.click();

		Actions actions = new Actions(driver);
		actions.moveToElement(contactsLink);
		actions.click().build().perform();
		return new ContactsPage();
	}
	
	
}

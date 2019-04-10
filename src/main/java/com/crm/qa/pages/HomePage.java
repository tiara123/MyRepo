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
	
	@FindBy(xpath="//a[@id='nav-secondary-companies']")
	WebElement companyLink;
	
	@FindBy(linkText="Sales")
	WebElement salesMenuLink;
	
	@FindBy(xpath="//a[@id='nav-secondary-deals']")
	WebElement dealsLink;
	
	@FindBy(linkText="Service")
	WebElement serviceMenuLink;
	
	@FindBy(xpath="//a[@id='nav-secondary-tickets']")
	WebElement ticketsLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContactsLink(){
		contactsMenuLink.click();

		Actions actions = new Actions(driver);
		actions.moveToElement(contactsLink).click().build().perform();
		return new ContactsPage();
	}
	
	public CompanyPage clickOnCompaniesLink(){
		contactsMenuLink.click();

		Actions actions = new Actions(driver);
		actions.moveToElement(companyLink).click().build().perform();
		return new CompanyPage();
	}
	
	public DealsPage clickOnDealsLink() {
		salesMenuLink.click();
		
		Actions actions = new Actions(driver);
		actions.moveToElement(dealsLink).click().build().perform();
		return new DealsPage();
		
	}
	
	public TicketsPage clickOnTicketsLink() {
		serviceMenuLink.click();
		
		Actions actions = new Actions(driver);
		actions.moveToElement(ticketsLink).click().build().perform();
		return new TicketsPage();
		
	}
	
}

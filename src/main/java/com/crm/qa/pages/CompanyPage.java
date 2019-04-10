package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CompanyPage extends TestBase{
	
	@FindBy(xpath="//h1[@class='private-header__heading']")
	WebElement companyLabel;
	
	@FindBy(xpath="//span[@data-key='contentToolbar.addCompanyButton']")
	WebElement createcompanyBtn;
	
	@FindBy(xpath="//input[@data-field='domain']")
	WebElement companyDomain;
	
	@FindBy(xpath="//input[@data-field='name']")
	WebElement companyName;
	
	@FindBy(xpath="//li[1][@class='uiListItem private-list__item p-bottom-1']")
	WebElement createComBtn;
	
	public CompanyPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyCompanyLabel(){
		return companyLabel.isDisplayed();
	}
	
	public void createNewCompany(String comDomName) throws InterruptedException {
		createcompanyBtn.click();
		companyDomain.sendKeys(comDomName);
		Thread.sleep(5000);
		System.out.println(companyName);
		createComBtn.click();
		Thread.sleep(7000);
	}
	
	
}

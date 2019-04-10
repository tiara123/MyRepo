package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CompanyPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TicketsPage;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	CompanyPage companyPage;
	DealsPage dealsPage;
	TicketsPage ticketsPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(7000);

	}
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Getting Started | HubSpot","Home page title not matched");
		System.out.println(homePageTitle);
	}
	
	@Test(priority=2)
	public void verifyContactsLinkTest() throws InterruptedException{
		contactsPage = homePage.clickOnContactsLink();
		Thread.sleep(7000);
	}
	
	@Test(priority=3)
	public void verifyCompaniesLinkTest() throws InterruptedException{
		companyPage = homePage.clickOnCompaniesLink();
		Thread.sleep(7000);
	}
	@Test(priority=4)
	public void verifyDealsLinkTest() throws InterruptedException{
		dealsPage = homePage.clickOnDealsLink();
		Thread.sleep(7000);
	}
	
	@Test(priority=5)
	public void verifyTicketsLinkTest() throws InterruptedException{
		ticketsPage = homePage.clickOnTicketsLink();
		Thread.sleep(7000);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}

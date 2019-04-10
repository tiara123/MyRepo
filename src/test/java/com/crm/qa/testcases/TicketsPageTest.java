package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TicketsPage;
import com.crm.qa.util.TestUtil;

public class TicketsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TicketsPage ticketsPage;
	
	String sheetName = "tickets";
	
	public TicketsPageTest() {
		super();
		}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {

		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		ticketsPage = new TicketsPage();
	}
	
	@Test(priority=1)
	public void verifyTicketsPageLabelTest() throws InterruptedException{
		Assert.assertTrue(ticketsPage.verifyTicketsPageLabel(), "Tickets label is missing on the page");
		Thread.sleep(3000);
	} 
	
	@DataProvider
	public Object[][] getHubSpotCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority=2, dataProvider="getHubSpotCRMTestData")
	public void validateCreateNewTicket(String ticketName, String ticketStatus, String ticketDesc, String source, String priority) throws InterruptedException {
		homePage.clickOnTicketsLink();
		ticketsPage.createNewTicket(ticketName, ticketStatus, ticketDesc, source, priority);
	
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}

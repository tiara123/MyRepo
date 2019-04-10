package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DealsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	DealsPage dealsPage;

	String sheetName = "deals";
	public DealsPageTest() {
		super();

	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {

		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		dealsPage = new DealsPage();
	}
	
	@Test(priority=1)
	public void verifyDealsPageLabelTest() throws InterruptedException{
		Assert.assertTrue(dealsPage.verifydealsPageLabel(), "Deals label is missing on the page");
		Thread.sleep(3000);
	} 
	

	@DataProvider
	public Object[][] getHubSpotCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=2, dataProvider="getHubSpotCRMTestData")
	public void validateCreateNewDeal(String dealName, String amount, String date) throws InterruptedException {
		homePage.clickOnDealsLink();
		dealsPage.createNewDeal(dealName,amount,date);

	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}

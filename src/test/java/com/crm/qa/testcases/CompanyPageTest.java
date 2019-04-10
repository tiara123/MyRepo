package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CompanyPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class CompanyPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	CompanyPage companyPage;

	
	String sheetName = "companies";
	
	public CompanyPageTest() {
		super();

	}

	@BeforeMethod
	public void setUp() throws InterruptedException {

		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		companyPage = new CompanyPage();

	}

	@Test(priority=1)
	public void verifyCompanyPageLabelTest(){
		Assert.assertTrue(companyPage.verifyCompanyLabel(), "Company label is missing on the page");
	} 
	
	@DataProvider
	public Object[][] getHubSpotCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority=2, dataProvider="getHubSpotCRMTestData")
	public void validateCreateNewCompany(String companyDomain) throws InterruptedException {
		homePage.clickOnCompaniesLink();
		companyPage.createNewCompany(companyDomain);
	
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}

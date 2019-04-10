package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase {

	public String reqDate;
	@FindBy(xpath = "//h1[@class='private-header__heading']")
	WebElement dealsLabel;

	@FindBy(xpath = "//span[@data-key='contentToolbar.addDealButton']")
	WebElement createDealBtn;

	@FindBy(xpath = "//input[@data-field='dealname']")
	WebElement dealName;

	@FindBy(xpath = "//input[@data-field='amount']")
	WebElement amount;

	@FindBy(xpath = "//div[@class='hs-pickadate private-date-picker']")
	WebElement selectDate;

	@FindBy(xpath = "//div[@class='picker__nav--next']")
	WebElement gotoNext;

	@FindBy(xpath = "//div[@class='picker__nav--prev']")
	WebElement gotoPrevious;
	
	@FindBy(xpath="//li[1][@class='uiListItem private-list__item p-bottom-1']")
	WebElement createBtn;

	@FindBy(className="picker__year")
	WebElement pickerYear;

	@FindBy(className="picker__month")
	WebElement pickerMonth;

	
	public DealsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifydealsPageLabel(){
		return dealsLabel.isDisplayed();
		
	}
	
	public void selectAppointmentDate() {

		String requiredDate = reqDate;
		//System.out.println(requiredDate);
		String date, month, year;
		String calmonth, calyear;
		/*
		 * Split the String into String Array
		 */
		String dateArray[] = requiredDate.split("-");
		date = dateArray[0];
		int resultDate = Integer.parseInt(date);	
		String resultDatetoString=String.valueOf(resultDate);
		month = dateArray[1];
		year = dateArray[2];

		System.out.println("Date to be Selected:" +resultDatetoString+ "/" +month+ "/" +year);
		selectDate.click();
		
		calyear = pickerYear.getText();

		/**
		 * Select the year
		 */
		while (!calyear.equals(year)) {
			gotoNext.click();
			calyear = pickerYear.getText();
			System.out.println("Displayed Year::" + calyear);
		}

		calmonth = pickerMonth.getText();

		/**
		 * Select the Month
		 */
		while (!calmonth.startsWith(month)) {
			gotoNext.click();
			calmonth = pickerMonth.getText();
		}

		/**
		 * Select the Date
		 */
		List<WebElement> dates = driver.findElements(By.xpath("//div[@class='picker__day picker__day--infocus']"));
		int count=dates.size();
		
		System.out.println("Number of dates: " + count);
		
		for(int i=0;i<count;i++) {
			String caldate=dates.get(i).getText();
			System.out.println("Date is:" + i);
			if(caldate.equals(resultDatetoString)) {
				dates.get(i).click();
				//System.out.println("Clicked on the date:" + i);
				break;
			}
		}
	}
		
		//6 rows,7 columns
	/*	List<WebElement> rows, cols;
		rows = cal.findElements(By.tagName("tr"));
		for (int i = 1; i < rows.size(); i++) {
			cols = rows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < cols.size(); j++) {
				caldt = cols.get(j).getText();
				if (caldt.equals(date)) {
					cols.get(j).click();
					break;
				}
			}
		}

	}  */
	
	public void createNewDeal(String dName, String amnt, String date) throws InterruptedException {
		createDealBtn.click();
		
		dealName.sendKeys(dName);
		amount.sendKeys(amnt);
		Thread.sleep(2000);
		reqDate = date;
		selectAppointmentDate();
		Thread.sleep(10000);
		createBtn.click();
		Thread.sleep(7000);
	}

}

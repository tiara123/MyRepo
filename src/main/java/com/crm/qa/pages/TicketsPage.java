package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;


public class TicketsPage extends TestBase {

	@FindBy(xpath = "//h1[@class='private-header__heading']")
	WebElement ticketsLabel;

	@FindBy(xpath = "//span[@data-key='contentToolbar.addTicketButton']")
	WebElement createTicketBtn;

	@FindBy(xpath = "//input[@data-field='subject']")
	WebElement ticketName;

	@FindBy(id = "uid-ctrl-3")
	WebElement ticketStatus;

	@FindBy(xpath = "//li[@role='presentation']")
	List<WebElement> ticketStatusList;

	@FindBy(xpath = "//textarea[@data-field='content']")
	WebElement ticketDesc;

	@FindBy(xpath = "//button[@aria-owns='dropdown-178']")
	WebElement source;

	@FindBy(xpath = "//button[@role='option']")
	List<WebElement> sourceList;

	@FindBy(xpath = "//div[@aria-owns='dropdown-180']")
	WebElement priority;

	@FindBy(xpath = "//div[@role='option']")
	List<WebElement> priorityList;

	@FindBy(xpath = "//li[1][@class='uiListItem private-list__item p-bottom-1']")
	WebElement createBtn;

	public TicketsPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions

	public boolean verifyTicketsPageLabel() {
		return ticketsLabel.isDisplayed();
	}

	public void createNewTicket(String tktName, String tktStatus, String tktDesc, String src, String prty) throws InterruptedException {
		createTicketBtn.click();

		ticketName.sendKeys(tktName);
		ticketStatus.click();
		for (WebElement e : ticketStatusList) {
			if (e.getText().equalsIgnoreCase(tktStatus)) {
				e.click();
				break;
			}
		}
		System.out.println("Status is Selected!");

		ticketDesc.sendKeys(tktDesc);
		source.click();
		for (WebElement e : sourceList) {
			if (e.getText().equalsIgnoreCase(src)) {
				e.click();
				break;
			}
		}
		System.out.println("Source is Selected!");

		priority.click();
		for (WebElement e : priorityList) {
			if (e.getText().equalsIgnoreCase(prty)) {
				e.click();
				break;
			}
		}
		System.out.println("Priority is Selected!");

		createBtn.click();
		Thread.sleep(7000);

	}

}

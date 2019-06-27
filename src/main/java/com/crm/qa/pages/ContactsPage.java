package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class ContactsPage extends TestBase {

	TestUtil util = util = new TestUtil();

	// learn dynamic xpath and the modify these xpaths
	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[1]")
	WebElement contactsLabel;

	@FindBy(xpath = "//button[contains(text(),'New')]")
	WebElement newContactLink;

	@FindBy(name = "first_name")
	WebElement firstname;

	@FindBy(name = "last_name")
	WebElement lastname;

	@FindBy(xpath = "//div[@name='company']//input[@class='search' and @type='text']")
	WebElement company;

	/*
	 * replace by dynamic xpath
	 */
	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]/i")
	WebElement saveBtn;

	public ContactsPage() {
		PageFactory.initElements(driver, this);

	}

	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}

	public void selectContacts() {
		// learn dynamic xpath and the modify these xpaths
		WebElement ele1 = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]/div/input"));
		// util.expectedWait(ele1);
		ele1.click();

	}

	public void createNewContacts(String fname, String lname, String comp) {
		newContactLink.click();
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		company.sendKeys(comp);
		saveBtn.click();

	}

}

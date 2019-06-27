package com.crm.wa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	DealsPage dealspage;
	TasksPage taskspage;
	String sheetname = "contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
		contactspage = new ContactsPage();
		dealspage = new DealsPage();
		taskspage = new TasksPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactspage = homepage.clickOnContactsLink();
	}

	@Test(priority = 1)
	public void verifyContactsPageLabel() {
		String homePageTitle = homepage.validHomePageTitle();
		Assert.assertEquals("Home Page Title not matched", homePageTitle, "CRM");
	}

	// @Test(priority = 2)
	// public void verifySingleContactTest() {
	// boolean userLabel = homepage.verifyCorrectUserName();
	// Assert.assertTrue(userLabel);
	// }

	@DataProvider
	public Object[][] getCRMTestData() {
		Object[][] data = TestUtil.getTestData(sheetname);
		return data;
	}

	@Test(priority = 3, dataProvider = "getCRMTestData")
	public void validateCreateNeContact(String fname, String lname, String comp) {
		contactspage.createNewContacts(fname, lname, comp);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

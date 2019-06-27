package com.crm.wa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	DealsPage dealspage;
	TasksPage taskspage;

	public HomePageTest() {
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
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homepage.validHomePageTitle();
		Assert.assertEquals("Home Page Title not matched", homePageTitle, "CRM");
	}

	@Test(priority = 2)
	public void verifyUserNameTest() {
		boolean userLabel = homepage.verifyCorrectUserName();
		Assert.assertTrue(userLabel);
	}

	@Test(priority = 3)
	public void verifyContactsLinkTest() {
		contactspage = homepage.clickOnContactsLink();

	}

	@Test(priority = 4)
	public void verifyDelasLinkTest() {
		dealspage = homepage.clickOnDealsLink();

	}

	@Test(priority = 5)
	public void verifyTasksPageLinkTest() {
		taskspage = homepage.clickOnTasksLink();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

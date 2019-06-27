package com.crm.wa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;

	LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPgeTtleTest() {
		String title = loginpage.validateLoginPagetitle();
		Assert.assertEquals(title, "Free CRM software for any Business");
	}

	@Test(priority = 2)
	public void crmLogoImageTest() {
		boolean bvalue = loginpage.validateCRMImage();
		Assert.assertTrue(bvalue);
	}

	@Test(priority = 3)
	public void loginTest() {
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

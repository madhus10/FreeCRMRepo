package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath = "//span[contains(text(),'Log In')]")
	WebElement loginBtn;

	@FindBy(name = "email")
	WebElement uname;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = ".//*[@id='ui']/div/div/form/div/div[3]")
	WebElement subLoginBtn;;

	@FindBy(xpath = "//span[contains(text(),'sign up')]")
	WebElement signUpBtn;

	@FindBy(xpath = "//span[contains(text(),'free')] ")
	WebElement crmLogo;;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPagetitle() {
		return driver.getTitle();
	}

	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}

	public HomePage login(String un, String pwd) {
		loginBtn.click();
		uname.sendKeys(un);
		password.sendKeys(pwd);
		subLoginBtn.click();
		return new HomePage();
	}
}

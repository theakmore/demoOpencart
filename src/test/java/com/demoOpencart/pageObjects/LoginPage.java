package com.demoOpencart.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='email']")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(xpath="//input[@name='password']")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@value='Login']")
	@CacheLookup
	WebElement btnLogin;
	
	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLoginBtn() {
		btnLogin.click();
	}
	
	

}

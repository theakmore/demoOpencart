package com.demoOpencart.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	
WebDriver driver;
	
	public RegistrationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	@CacheLookup
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	@CacheLookup
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	@CacheLookup
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	@CacheLookup
	WebElement telephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	@CacheLookup
	WebElement txtConfirmpassword;
	
	@FindBy(xpath="//input[@name='agree']")
	@CacheLookup
	WebElement privacyCheckbox;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	@CacheLookup
	WebElement continueBtn;
	
	
	public void setFirstName(String fname) {
		firstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		lastName.sendKeys(lname);
	}
	
	public void enterEmail(String mail) {
		txtemail.sendKeys(mail);
	}
	
	public void enterPhoneNo(String phno) {
		telephone.sendKeys(phno);
	}
	
	public void enterPassword(String pass) {
		txtpassword.sendKeys(pass);
	}
	
	public void enterConfirmedPassword(String cpass) {
		txtConfirmpassword.sendKeys(cpass);
	}
	
	public void selectPrivacyCheckBox() {
		privacyCheckbox.click();
	}
	
	public void clickContinue() {
		continueBtn.click();
	}
	

}

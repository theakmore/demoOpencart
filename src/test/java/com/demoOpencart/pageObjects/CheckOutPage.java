package com.demoOpencart.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage {
	
	
WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@id='button-payment-address']")
	@CacheLookup
	WebElement continueBtn1;
	
	@FindBy(xpath="//input[@name='shipping_address' and @value='new']")
	@CacheLookup
	WebElement useNewAddressRadioBtn;
	
	@FindBy(xpath="//input[@id='input-shipping-firstname']")
	@CacheLookup
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='input-shipping-lastname']")
	@CacheLookup
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='input-shipping-company']")
	@CacheLookup
	WebElement company;
	
	@FindBy(xpath="//input[@id='input-shipping-address-1']")
	@CacheLookup
	WebElement address;
	
	@FindBy(xpath="//input[@id='input-shipping-city']")
	@CacheLookup
	WebElement city;
	
	@FindBy(xpath="//input[@id='input-shipping-postcode']")
	@CacheLookup
	WebElement postcode;
	
	@FindBy(xpath="//select[@id='input-shipping-country']")
	@CacheLookup
	WebElement country;
	
	@FindBy(xpath="//select[@id='input-shipping-zone']")
	@CacheLookup
	WebElement state;
	
	@FindBy(xpath="//input[@id='button-shipping-address']")
	@CacheLookup
	WebElement continueBtn2;
	
	@FindBy(xpath="//input[@id='button-shipping-method']")
	@CacheLookup
	WebElement continueBtn3;
	
	@FindBy(xpath="//input[@name='agree']")
	@CacheLookup
	WebElement termsAndConditionsCheckBox;
	
	@FindBy(xpath="//input[@id='button-payment-method']")
	@CacheLookup
	WebElement continueBtn4;
	
	@FindBy(xpath="//input[@id='button-confirm']")
	@CacheLookup
	WebElement confirmOrder;
	
	public void clickcontinueBtn1() {
		continueBtn1.click();
	}
	
	public void clickuseNewAddressRadioBtn() {
		useNewAddressRadioBtn.click();
	}
	
	public void setFirstName(String fname) {
		firstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		lastName.sendKeys(lname);
	}
	
	public void enterCompany(String compname) {
		address.sendKeys(compname);
	}
	
	public void enterAddress(String address) {
		company.sendKeys(address);
	}
	
	public void enterCity(String cityname) {
		city.sendKeys(cityname);
	}
	
	public void enterPostCode(String strpostcode) {
		postcode.clear();
		postcode.sendKeys(strpostcode);
	}
	
	public void selectCountry() {
		Select select = new Select(country);
		select.selectByVisibleText("India");
	}
	
	public void selectState() {
		Select select = new Select(state);
		select.selectByVisibleText("Maharashtra");
	}
	
	public void clickcontinueBtn2() {
		continueBtn2.click();
	}
	
	public void clickcontinueBtn3() {
		continueBtn3.click();
	}
	
	public void selecttermsAndConditionsCheckBox() {
		termsAndConditionsCheckBox.click();
	}
	
	public void clickcontinueBtn4() {
		continueBtn4.click();
	}
	
	public void clickconfirmOrder() {
		confirmOrder.click();
	}
	

}

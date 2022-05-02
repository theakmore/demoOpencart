package com.demoOpencart.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	@CacheLookup
	WebElement myAccount;
	
	@FindBy(xpath="//a[text()='Login']")
	@CacheLookup
	WebElement login;
	
	@FindBy(xpath="//a[@class='list-group-item' and text()='Logout']")
	@CacheLookup
	WebElement logout;
	
	@FindBy(xpath="//a[@class='dropdown-toggle' and text()='Desktops']")
	@CacheLookup
	WebElement DesktopsBtn;
	
	@FindBy(xpath="//a[@class='see-all' and text()='Show All Desktops']")
	@CacheLookup
	WebElement showAllDesktopsBtn;
	
	
	@FindBy(xpath="//a[text()='Register']")
	@CacheLookup
	WebElement Register;
	
	
	@FindBy(xpath="//span[@id='cart-total']")
	@CacheLookup
	WebElement items;
	
	@FindBy(xpath="//p[@class='text-right']/child::a/strong[text()=' View Cart']")
	@CacheLookup
	WebElement viewCart;
	
	@FindBy(xpath="//a[@class='btn btn-primary' and text()='Checkout']")
	@CacheLookup
	WebElement checkOut;
	
	@FindBy(xpath="//a[@id='wishlist-total']")
	@CacheLookup
	WebElement wishList;
	
	@FindBy(xpath="//a[@class='dropdown-toggle' and text()='Laptops & Notebooks']")
	@CacheLookup
	WebElement LaptopsNotebooksBtn;
	
	@FindBy(xpath="//a[@class='see-all' and text()='Show All Laptops & Notebooks']")
	@CacheLookup
	WebElement showAllLaptopsNotebooksBtn;
	
	
	
	public void clickMyaccount() {
		myAccount.click();
	}
	public void clickLogin() {
		login.click();
	}
	
	public void clickLogout() {
		logout.click();
	}
	
	public void clickDesktops() {
		DesktopsBtn.click();
	}
	
	public void clickshowAllDesktops() {
		showAllDesktopsBtn.click();
	}
	
	public void clickRegister() {
		Register.click();
	}
	
	public void clickItems() {
		items.click();
	}
	
	
	public void clickviewCart() {
		viewCart.click();
	}
	
	public void clickcheckOut() {
		checkOut.click();
	}
	
	public void clickwishList() {
		wishList.click();
	}
	
	
	public void clickLaptopsNotebooks() {
		LaptopsNotebooksBtn.click();
	}
	
	
	public void clickshowAllLaptopsNotebooks() {
		showAllLaptopsNotebooksBtn.click();
	}	
	

}

package com.demoOpencart.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DesktopsPage {
	
WebDriver driver;
	
	public DesktopsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='caption']/child::h4/child::a[text()='HP LP3065']")
	@CacheLookup
	WebElement hplaptop;

	
	@FindBy(xpath="//button[@id='button-cart']")
	@CacheLookup
	WebElement AddtoCart;
	
	
	@FindBy(xpath="//div[@class='caption']/child::h4/child::a[text()='iPhone']")
	@CacheLookup
	WebElement elementiphone;
	
	@FindBy(xpath="//button[@class='btn btn-default']/child::i[@class='fa fa-heart']")
	@CacheLookup
	WebElement iphoneWishlistBtn;
	
	@FindBy(xpath="//a[text()='iPhone']")
	@CacheLookup
	WebElement iphonetextAfterwishList;

	
	public void clickHPlaptop() {
		hplaptop.click();
	}
	

	
	public void clickAddtoCart() {
		AddtoCart.click();
	}
	
	public void clickiPhone() {
		elementiphone.click();
	}

	
	public void clickiphoneWishlistBtn() {
		iphoneWishlistBtn.click();
	}
	
	//Capturing the Name of the product before adding it to the wishlist. 
	
	public String nameOfProductIphonebeforeAddingToWishList() {
		String str = elementiphone.getText();
		return str;
	}
	
	//Capturing the Name of the product after adding it to the wishlist. 
	
	public String nameOfProductIphoneAfterAddingToWishList() {
		String str = iphonetextAfterwishList.getText();
		return str;
	}
	
	

}

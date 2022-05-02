package com.demoOpencart.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LaptopsAndNoteBooksPage {
	
WebDriver driver;
	
	public LaptopsAndNoteBooksPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//span[@class='price-tax']")
	@CacheLookup
	List<WebElement> beforeFilterPrice;
	
	@FindBy(xpath="//span[@class='price-tax']")
	@CacheLookup
	List<WebElement> afterFilterPrice;
	
	
	@FindBy(xpath="//select[@id='input-sort']")
	@CacheLookup
	WebElement DropdownPrice;
	
	//Before filter capture the prices
	
	public List<Double> beforeFilter() {
		
		List<Double> beforeFilterPriceList = new ArrayList<>();
		
		for(WebElement p : beforeFilterPrice) {
			String str = (p.getText().replace("Ex Tax: $", ""));
			beforeFilterPriceList.add(Double.valueOf(str.replace(",", "")));  // removing the unwanted text and $ symbols
		}                                                                     // from the price and convert the string into double
		
		return beforeFilterPriceList;
		
	}
	
	//filter the price from dropdown
	
	public void sortByPrice() {
		
		Select select = new Select(DropdownPrice);
		select.selectByVisibleText("Price (Low > High)");
		
	}
	
	//After filter capture the prices
	
	public List<Double> afterFilter() {
		
		List<Double> afterFilterPriceList = new ArrayList<>();
		
		for(WebElement p : afterFilterPrice) {
				
			String str = (p.getText().replace("Ex Tax: $", ""));
			afterFilterPriceList.add(Double.valueOf(str.replace(",", "")));
		}
		
		return afterFilterPriceList;
		
	}
	

	
	

}

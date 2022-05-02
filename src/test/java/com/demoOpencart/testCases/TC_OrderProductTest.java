package com.demoOpencart.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoOpencart.pageObjects.CheckOutPage;
import com.demoOpencart.pageObjects.DesktopsPage;
import com.demoOpencart.pageObjects.HomePage;
import com.demoOpencart.pageObjects.LoginPage;

public class TC_OrderProductTest extends BaseClass{
	
	@Test
	public void orderProductTest() throws IOException, InterruptedException {
		
		HomePage hmpg = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		DesktopsPage dpg = new DesktopsPage(driver);
		CheckOutPage cpg = new CheckOutPage(driver);
		
		
		hmpg.clickMyaccount();
		hmpg.clickLogin();
		
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickLoginBtn();
		
		hmpg.clickDesktops();
		hmpg.clickshowAllDesktops();
		
		dpg.clickHPlaptop();
		dpg.clickAddtoCart();
		
		hmpg.clickItems();
		hmpg.clickviewCart();
		
		String title = driver.getTitle();
		
		if(title.equals("Shopping Cart")) {
			
			Assert.assertTrue(true);
			logger.info("Title Shopping Cart displayed");
		}
		else {
			captureScreen(driver , "TC_OrderProductTest");
			Assert.assertTrue(false);
			logger.info("Title Shopping Cart is not displayed");
		}
		
		hmpg.clickcheckOut();
		
		if(driver.getTitle().equals("Checkout")) {
			
			Assert.assertTrue(true);
			logger.info("Successfully landed on Checkout page");
		}
		else {
			captureScreen(driver , "TC_OrderProductTest");
			Assert.assertTrue(false);
			logger.info("Failed to land on Checkout page");
		}
		
		cpg.clickcontinueBtn1();
		Thread.sleep(3000);
		cpg.clickuseNewAddressRadioBtn();
		
		logger.info("filling delivery address details");
		
		cpg.setFirstName("Akshay");
		cpg.setLastName("More");
		cpg.enterCompany("Google");
		cpg.enterAddress("Aurangabad MH");
		cpg.enterCity("Aurangabad");
		cpg.enterPostCode("431005");
		
		cpg.selectCountry();
		cpg.selectState();
		
		cpg.clickcontinueBtn2();
		cpg.clickcontinueBtn3();
		cpg.selecttermsAndConditionsCheckBox();
		cpg.clickcontinueBtn4();
		cpg.clickconfirmOrder();
		
		Thread.sleep(3000);
		
		if(driver.getTitle().equals("Your order has been placed!")) {
			
			Assert.assertTrue(true);
			logger.info("Order a Product  test passed");
		}
		else {
			captureScreen(driver , "orderProductTest");
			Assert.assertTrue(false);
			logger.info("Registration test failed");
		}
		
		
	}

}

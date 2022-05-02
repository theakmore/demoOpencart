package com.demoOpencart.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoOpencart.pageObjects.HomePage;
import com.demoOpencart.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() throws Exception {
		
		
		HomePage hmpg = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		
		hmpg.clickMyaccount();
		hmpg.clickLogin();
		
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickLoginBtn();
		
		Thread.sleep(3000);
		
		if(driver.getTitle().equals("My Account"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else
		{
			captureScreen(driver , "loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		
		
		
	}

}

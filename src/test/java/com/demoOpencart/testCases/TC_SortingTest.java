package com.demoOpencart.testCases;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoOpencart.pageObjects.HomePage;
import com.demoOpencart.pageObjects.LaptopsAndNoteBooksPage;
import com.demoOpencart.pageObjects.LoginPage;

public class TC_SortingTest extends BaseClass{
	
	@Test
	public void sortingTest() throws IOException {
		
		HomePage hmpg = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		LaptopsAndNoteBooksPage lpntbkpg = new LaptopsAndNoteBooksPage(driver);
		
		hmpg.clickMyaccount();
		hmpg.clickLogin();
		
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickLoginBtn();
		
		hmpg.clickLaptopsNotebooks();
		hmpg.clickshowAllLaptopsNotebooks();
		
		logger.info("Before filter capture the prices");
		
		List<Double> before = lpntbkpg.beforeFilter();
		
//		System.out.println(before);
		
		Collections.sort(before);
		
		logger.info("filter the price from dropdown");
		
		lpntbkpg.sortByPrice();
		
		logger.info("After filter capture the prices");
		
		List<Double> after = lpntbkpg.afterFilter();
		
//		System.out.println(after);
		
	
		
		if(before.equals(after))
		{
		  Assert.assertTrue(true);
		  logger.info(" Sorting test passed");
		}
		else {
			captureScreen(driver , "sortingTest");
			Assert.assertTrue(false);
			logger.info(" Sorting test failed");	
		}
		
		
		
	}

}

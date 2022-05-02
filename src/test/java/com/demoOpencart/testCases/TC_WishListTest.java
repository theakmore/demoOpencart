package com.demoOpencart.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoOpencart.pageObjects.DesktopsPage;
import com.demoOpencart.pageObjects.HomePage;
import com.demoOpencart.pageObjects.LoginPage;

public class TC_WishListTest extends BaseClass{
	
	@Test
	public void wishListTest() throws IOException {
		
		HomePage hmpg = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		DesktopsPage dpg = new DesktopsPage(driver);
		
		hmpg.clickMyaccount();
		hmpg.clickLogin();
		
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickLoginBtn();
		
		hmpg.clickDesktops();
		hmpg.clickshowAllDesktops();
		
	    logger.info("Capturing the Name of the product before adding it to the wishlist. ");
		
		String expected = dpg.nameOfProductIphonebeforeAddingToWishList();
//		System.out.println(expected);
		
		dpg.clickiPhone();
		dpg.clickiphoneWishlistBtn();
		
		hmpg.clickwishList();
		
		logger.info("Capturing the Name of the product after adding it to the wishlist. ");
		
		String actual = dpg.nameOfProductIphoneAfterAddingToWishList();
//		System.out.println(actual);
		
		if(expected.equals(actual)) {
			Assert.assertTrue(true);
			logger.info("WishList test passed");
		}
		else {
			captureScreen(driver , "wishListTest");
			Assert.assertTrue(false);
			logger.info("WishList test failed");
		}
		
		
		
		
	}

}

package com.demoOpencart.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoOpencart.pageObjects.HomePage;
import com.demoOpencart.pageObjects.RegistrationPage;

public class TC_RegistrationTest extends BaseClass{
	
	
	@Test
	public void registrationTest() throws IOException {

		HomePage hmpg = new HomePage(driver);
		RegistrationPage rpg = new RegistrationPage(driver);
		
		hmpg.clickMyaccount();
		hmpg.clickRegister();
		
		rpg.setFirstName("Akshay");
		rpg.setLastName("More");
		
		logger.info("Entering the randomly generated email");
		String email=randomestring()+"@gmail.com";
		rpg.enterEmail(email);
		
		rpg.enterPhoneNo("12345678");
		
		logger.info("Entering the randomly generated password");
		String password = randomeNum()+"@Pass";
		rpg.enterPassword(password);
		rpg.enterConfirmedPassword(password);
		
		rpg.selectPrivacyCheckBox();
		rpg.clickContinue();
		
		//validation of registration test case started
		
		String title = driver.getTitle();
		
		if(title.equals("Your Account Has Been Created!")) {
			
			Assert.assertTrue(true);
			logger.info("Registration test passed");
		}
		else {
			captureScreen(driver , "registrationTest");
			Assert.assertTrue(false);
			logger.info("Registration test failed");
		}
		
		
		
		
	}

}

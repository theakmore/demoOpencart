package com.demoOpencart.testCases;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demoOpencart.pageObjects.HomePage;
import com.demoOpencart.pageObjects.LoginPage;
import com.demoOpencart.utilities.XLUtility;

public class TC_LoginDDT_002 extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user , String pwd) throws Exception {
		
		
		HomePage hmpg = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		
		hmpg.clickMyaccount();
		hmpg.clickLogin();
		
		lp.setUserName(user);
		logger.info("user name provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickLoginBtn();
		
		Thread.sleep(3000);
		
		if(driver.getTitle().equals("My Account"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
			hmpg.clickLogout();
			Thread.sleep(3000);
		}
		else
		{
			captureScreen(driver , "loginDDT"); // capturing the screenshot when Test Case is failed
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		
		
	}
	
	
	
	@DataProvider(name="LoginData")                 
	public String [][] getdata() throws Exception
	{                          
		
		String path = System.getProperty("user.dir")+"/src/test/java/com/demoOpencart/testData/LoginData.xlsx";
		
		XLUtility xlutil = new XLUtility(path);
		
		int totalrows = xlutil.getRowCount("Sheet1");
//		System.out.println(totalrows);
		int totalcolumns = xlutil.getCellCount("Sheet1", 1); 
//		System.out.println(totalcolumns);
		
		String logindata[][] = new String [totalrows][totalcolumns]; // 2d array
		
		for(int i=1;i<=totalrows;i++ ) // here we will start from 2nd row(index 1) as 1st row is having headers
		{
			for(int j=0;j<totalcolumns;j++)
			{
				logindata[i-1][j] = xlutil.getCellData("Sheet1", i, j);   // i-1 as ..we will start from [0][0], [0][1]....
			}
		}
		
		return logindata;
		
	}
	

}

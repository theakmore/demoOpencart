package com.demoOpencart.testCases;

import java.io.File;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.demoOpencart.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		//Logger steps
		logger=Logger.getLogger("demoOpencart");
		PropertyConfigurator.configure("log4j.properties");
		
		//Check if parameter passed from TestNG is 'chrome'
		if(br.equals("chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver=new ChromeDriver();
			
		}
		//Check if parameter passed from TestNG is 'firefox'
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(baseURL);
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	// Created for capturing the screenshot and storing the screenshot under Screenshots folder 
	public void captureScreen(WebDriver driver, String tname) throws IOException { // tname is name of method
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	
	// Created for generating random String for unique email
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(6);
		return(generatedstring);
	}
	
	// Created for generating random String for unique password
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(6);
		return (generatedString2);
	}
	


}

package com.testPack.SampleProject4;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGClass {

	  public static WebDriver driver;
	  Properties prop;
	  
	  
  @BeforeTest	
  public void driverSetUp() {
		try {
			
		 File filePath = new File(System.getProperty("user.dir")+"\\config.properties");
		 FileReader fr = new FileReader(filePath);
		 prop = new Properties();
	  	 prop.load(fr);
	  
	  	 WebDriverManager.chromedriver().setup();
	  	 driver = new ChromeDriver();
	  	 //driver.get("http://www.google.com"); 
	  	 driver.get(prop.getProperty("url"));
	  	 driver.manage().window().maximize();
		}catch(Exception e) {
			System.out.println(e);
		}
 }
  
  @Test
  public void verifyTitle() {
  
	  //Javascript js = (JavaScriptExecutor)driver;
	  
	  
//	  String eTitle = "Googlee";
//	  String aTitle= driver.getTitle();
//	 
//	  Assert.assertEquals(eTitle, aTitle);
	  System.out.println("===============================================================================================================");
	  System.out.println("Title is: "+driver.getTitle());
	  System.out.println("===============================================================================================================");
}

  
  public void verifyURL() {
  
  System.out.println(driver.getCurrentUrl());
}

  @AfterTest
  public void tearDown() {
	  
  driver.quit();
}
  
}




  
  
  
package com.testPack.SampleProject4;

import java.io.FileInputStream;
import java.io.FileReader;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleHomePage {
	
	public static WebDriver driver;
	  private Map<String, Object> vars;
	  
	By gmailLink = By.linkText("Gmail");
	By imagesLink = By.linkText("Images");
	By searchTextBox = By.id("APjFqb");
	By searchButton = By.name("btnK");
	
	FileReader filePath;
	FileInputStream fis;
	Properties prop;
	
	  @BeforeTest
	  public void driverSetUp() {
		  
		  try {
		  filePath=new FileReader("\\Selenium-Workspace\\SampleProject4\\config.properties");
		  prop = new Properties();
		  prop.load(filePath);
		  //WebDriver driver = new ChromeDriver();
		  //WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  
		  driver.get("https://www.zigwheels.com");
		  driver.get(prop.getProperty("url"));
		  //driver.manage().window().maximize();

		    vars = new HashMap<String, Object>();

		  }catch(Exception e) {
			  System.out.println(e);
		  }
	  }

	
//  @Test(enabled=false)
//  public void verifyGmailLink() {
//	  
//	  if(driver.findElement(gmailLink).isDisplayed()){
//		  driver.findElement(gmailLink).click();
//	  }
//	  //driver.navigate().back();
//  }
//  
//  @Test
//  public void verifyImagesLink() {
//	  
//	  
////	  if(driver.findElement(imagesLink).isDisplayed()) {
////		  driver.findElement(imagesLink).click();
////	  }
////	  driver.navigate().back();
//  }
//
//  @Test
//  public void enterTextToSearch() {
//	  driver.findElement(searchTextBox).sendKeys("Selenium Books");
//	  driver.findElement(searchButton).click();
//	  	  
//	  ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,450)");
//	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//  }
  

	  @Test
	   public String waitForWindow(int timeout) {
			    try {
			      Thread.sleep(timeout);
			    } catch (InterruptedException e) {
			      e.printStackTrace();
			    }

			    Set<String> windowhandleNow = driver.getWindowHandles();
			    Set<String> windowhandleThen = (Set<String>) vars.get("window_handles");
			    if (windowhandleNow.size() > windowhandleThen.size()) {
			      windowhandleNow.removeAll(windowhandleThen);
			    }
			    return windowhandleNow.iterator().next();
			  }
		
		  @Test
			  public void zipwheels() {
			    driver.get("https://www.zigwheels.com/");
			    driver.manage().window().setSize(new Dimension(1536, 816));
			    driver.findElement(By.id("des_lIcon")).click();
			    vars.put("window_handles", driver.getWindowHandles());
			    driver.findElement(By.cssSelector(".googleSignIn > .fnt-14")).click();
			    vars.put("win8780", waitForWindow(2000));
			    vars.put("root", driver.getWindowHandle());
			    driver.switchTo().window(vars.get("win8780").toString());
			    driver.findElement(By.cssSelector(".Svhjgc")).click();
			    driver.findElement(By.id("identifierId")).sendKeys("Test@gmail.com");
			    driver.findElement(By.cssSelector(".VfPpkd-LgbsSe-OWXEXe-k8QpJ > .VfPpkd-vQzf8d")).click();
			    driver.switchTo().window(vars.get("root").toString());
			  }
			

	  
	  
  @AfterTest
  public void tearDown() {
	  //driver.quit();
  }

}

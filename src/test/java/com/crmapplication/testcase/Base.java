package com.crmapplication.testcase;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import com.crmapplication.utilities.ReadConfiguration;


public class Base 
{
	public static WebDriver driver;
	ReadConfiguration r = new ReadConfiguration();
	String url = r.getUrl();
	String browser = r.getBrowser();
	
	@BeforeTest
	void BrowserSetup() {
		
		switch (browser) {
			case "chrome" :
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				break;
			
			case "edge" :
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				break;
				
			case "firefox" :
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				break;
	
			default:
				driver=null;
				
			}
		
		}

	
	public void screenshot() throws Exception 
	{
		
		TakesScreenshot tc = (TakesScreenshot)driver;
		File f1 = tc.getScreenshotAs(OutputType.FILE);
		File f2 = new File(System.getProperty("user.dir") + "/screenshot/login.png");
		FileUtils.copyFile(f1, f2);
		
	}
}

package com.crmapplication.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logout 
{
public WebDriver ldriver;
	
	public Logout(WebDriver rdriver) {
		ldriver = rdriver;
	}
	
	// Locate
	
	By logout = By.linkText("Log out");
	
	//action/ method
	
	public void getLogout() {
		ldriver.findElement(logout).click();
	}
}

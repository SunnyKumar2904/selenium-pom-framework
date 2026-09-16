package com.crmapplication.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login 
{
public WebDriver ldriver;
	
	public Login(WebDriver rdriver) {
		ldriver = rdriver;
	}
	
	// Locate
	
	By usermane = By.id("username");
	By password = By.id("password");
	By submit = By.id("submit"); 
	
	//Action/ Methods
	
	public void getUsename(String user) {
		ldriver.findElement(usermane).sendKeys(user);;
	}
	
	
	public void getPassword(String pass) {
		ldriver.findElement(password).sendKeys(pass);
	}
	
	public void getSubmit () {
		ldriver.findElement(submit).click();
	}
}

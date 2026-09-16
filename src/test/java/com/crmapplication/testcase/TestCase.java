package com.crmapplication.testcase;

import org.testng.annotations.Test;
import com.crmapplication.pageobject.Login;
import com.crmapplication.pageobject.Logout;

public class TestCase extends Base 
{
	@Test(priority = 0)
	void login() 
	{	
		driver.get(url);
		Login login = new Login(driver);
		
		login.getUsename("student");
		login.getPassword("Password123");
		login.getSubmit();
	}
	
	@Test(priority = 1)
	void logout() {
		Logout logout = new Logout(driver);
		logout.getLogout();
	}
	
}

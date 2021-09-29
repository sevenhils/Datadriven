package Datadriventest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.base.Baseclass;

public class Datadriventest extends Baseclass {
	@Test(dataProvider="logincredentials")
	
	
	
	public void logintest(String Username,String pswd) {
		driver.findElement(By.id("txtUsername")).sendKeys(Username);
		driver.findElement(By.id("txtPassword")).sendKeys(pswd);
		driver.findElement(By.id("btnLogin")).click();
		
		/*
		 * Assert.assertTrue(driver.getTitle().contains("dashboard")
		 * ,"User not able to login-invalid credential");
		 * System.out.println("Page Title verified-User able to login Successfully");
		 */		
		
		  String actualurl=driver.getCurrentUrl(); String
		  exepectdurl="https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		  Assert.assertEquals(actualurl,
		  exepectdurl,"user not able to login-invalid credentials");
		 
		
	}
	

}

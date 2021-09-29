package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.utilites.Excellibrary;
  
public class Baseclass {
	public WebDriver driver;
	 Excellibrary obj= new Excellibrary("C:\\Users\\ADMIN\\git\\Datadriven\\Datadriven\\Testdata\\user.xlsx");

@BeforeMethod
	public void setup() {
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "E:\\Chrome driver\\chromedriver.exe"); driver=new ChromeDriver();
		 */
	System.setProperty("webdriver.gecko.driver","E:\\firefox\\geckodriver.exe");
	driver=new FirefoxDriver();	

	driver.manage().window().maximize();
	driver.get("https://opensource-demo.orangehrmlive.com/");
	
		
	}
@AfterMethod
	
public void teardown() {
	driver.quit();
}
	@DataProvider(name ="logincredentials")
	 public Object[][] getExcelData() {
	  //Totals rows count
	  int rows=obj.getRowCount("data");
	  //Total Columns
	  int column=obj.getColumnCount("data");
	  int actRows=rows-1;
	  
	  Object[][] data= new Object[actRows][column];
	  
	  for(int i=0;i<actRows;i++) {
	   for(int j=0; j<column;j++) {
	    data[i][j]=obj.getCellData("data", j, i+2);
	   }
	  }
	  return data;
}
 	}
		
		
	

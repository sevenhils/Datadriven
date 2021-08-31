package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.utilites.Excellibrary;
  
public class Baseclass {
	public WebDriver driver;
	Excellibrary obj=new Excellibrary("C:\\Users\\ADMIN\\eclipse-workspace\\Datadriven\\Testdata\\user.xlsx");
@BeforeMethod
	public void setup() {
	System.setProperty("webdriver.chrome.driver", "E:\\Chrome driver\\chromedriver.exe");
	 driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://opensource-demo.orangehrmlive.com/");
	
		
	}
	
public void teardown() {
	driver.quit();
	
}
@DataProvider(name="Credentials")
	public Object[][] getdata() {
		Object[][] data=new Object[3][2];
		
		data[0][0]="Admin";
		data[0][1]="admin123";

		data[1][0]="Admin1";
		data[1][1]="admin123";

		data[2][0]="Admin";
		data[2][1]="admin143";
		return data;
		}
 @DataProvider(name="logincredentials")
			public Object[][] getexceldata() {
	 //total Row count
			int rows	=obj.getRowCount("data");
			// total column count
			int coloumns=obj.getColumnCount("data");
			int actrows=rows-1;
			Object[][] data=new Object[actrows][coloumns];
			
			for(int i=0;i<actrows;i++) {
				for(int j=0;j<coloumns;j++) {
					data[i][j]=obj.getCellData("data", j, i+2);
				}
			}
			return data;
			
			}
	}
		
		
	

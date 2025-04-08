package regression;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.UtilKit;

public class ValidateLoginExcelDataDriven extends BaseTest {
	@Test(description="To validate valid login details",dataProvider="getData")
	public void validateLoginTest1(HashMap<String, String> testDataMap) {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(testDataMap.get("Username"));
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(testDataMap.get("Password"));
		driver.findElement(By.xpath("//input[@id='login']")).click();
		Assert.assertEquals(driver.getTitle(), testDataMap.get("ExpTitle"));
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data=new Object[1][1];
		data[0][0]=UtilKit.getExcelData("TC_1");
		
		return data;
		
	}

}

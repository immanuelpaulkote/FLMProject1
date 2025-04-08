package regression;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.UtilKit;

public class ValidateCheckOutDataDriven extends BaseTest {
	@Test(description="To validate check out details",dataProvider="getData")
	public void validateLoginTest1(HashMap<String, String> testDataMap) {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(testDataMap.get("Username"));
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(testDataMap.get("Password"));
		driver.findElement(By.xpath("//input[@id='login']")).click();
		Select s=new Select(driver.findElement(By.xpath("//select[@id='location']")));
		s.selectByVisibleText(testDataMap.get("Location"));
		new Select(driver.findElement(By.xpath("//select[@id='hotels']"))).selectByVisibleText(testDataMap.get("Hotel"));
		new Select(driver.findElement(By.xpath("//select[@id='room_type']"))).selectByVisibleText(testDataMap.get("RoomType"));
		new Select(driver.findElement(By.xpath("//select[@id='room_nos']"))).selectByVisibleText(testDataMap.get("No.of Rooms"));
		driver.findElement(By.xpath("//input[@id='datepick_in']")).clear();
		driver.findElement(By.xpath("//input[@id='datepick_in']")).sendKeys(testDataMap.get("Check-in"));
		driver.findElement(By.xpath("//input[@id='Submit']")).click();	
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@id='checkin_span']"))));
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='checkin_span']")).getText(), testDataMap.get("ExpMsg"));
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data=new Object[1][1];
		data[0][0]=UtilKit.getExcelData("TC_2");
		
		return data;
		
	}

}

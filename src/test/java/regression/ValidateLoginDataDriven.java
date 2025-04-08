package regression;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;

public class ValidateLoginDataDriven extends BaseTest {
	@Test(description="To validate login",dataProvider="getData")
	public void validateLoginTest1(String uname, String password, String expTitle) {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='login']")).click();
		Assert.assertEquals(driver.getTitle(), expTitle);
	}
	@DataProvider
	public Object[][] getData(){
		Object[][] obj=new Object[4][3];
		
		obj[0][0]="reyaz0806";
		obj[0][1]="reyaz123";
		obj[0][2]="Adactin.com - Search Hotel";
		
		obj[1][0]="reyaz080";
		obj[1][1]="reyaz123";
		obj[1][2]="Adactin.com - Hotel Reservation System";
		
		obj[2][0]="reyaz0806";
		obj[2][1]="reyaz12";
		obj[2][2]="Adactin.com - Hotel Reservation System";
		
		obj[3][0]="reyaz080";
		obj[3][1]="reyaz12";
		obj[3][2]="Adactin.com - Hotel Reservation System";
		
		return obj;
		
	}

}

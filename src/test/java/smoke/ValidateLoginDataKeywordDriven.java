package smoke;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest2;
import keywords.ApplicationKeywords;
import utils.UtilKit;

public class ValidateLoginDataKeywordDriven extends BaseTest2 {
	@Test(dataProvider="getData")
	public void validateLoginTest1(HashMap<String, String> testDataMap) {
		ApplicationKeywords app=new ApplicationKeywords();
		app.startBrowser();
		app.launchApp();
		app.loginWithDefaultData();
		app.verifyTitle(testDataMap.get("ExpTitle"));
		
	}
	@DataProvider
	public Object[][] getData(){
		Object[][] data=new Object[1][1];
		data[0][0]=UtilKit.getExcelData("TC_3");
		
		return data;
		
	}

}

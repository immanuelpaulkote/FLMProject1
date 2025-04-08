package smoke;

import org.testng.annotations.Test;

import base.BaseTest2;
import keywords.ApplicationKeywords;

public class ValidateLoginKeywordDriven extends BaseTest2 {
	@Test
	public void validateLoginTest1() {
		ApplicationKeywords app=new ApplicationKeywords();
		app.startBrowser();
		app.launchApp();
		app.loginWithDefaultData();
		app.verifyTitle("Adactin.com - Search Hotel");
		
	}

}

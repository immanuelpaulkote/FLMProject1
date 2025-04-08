package smoke;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest2;
import keywords.ApplicationKeywords;

public class ValidateCheckOut extends BaseTest2 {
	@Test
	public void validateCheckOutTest() {
		ApplicationKeywords app=new ApplicationKeywords();
		app.startBrowser();
		app.launchApp();
		app.loginWithDefaultData();
		app.selectFromDropdown("location", prop2.getProperty("location_data"));
		app.selectFromDropdown("hotels", prop2.getProperty("hotels_data"));
		app.selectFromDropdown("roomType", prop2.getProperty("roomType_data"));
		app.selectFromDropdown("noRooms", prop2.getProperty("noRooms_data"));
		app.clear("checkIn");
		app.type("checkIn", prop2.getProperty("checkIn_data"));
		app.click("submit");
		Assert.assertEquals(app.getText("error"), prop2.getProperty("error_data"));
		
	}

}

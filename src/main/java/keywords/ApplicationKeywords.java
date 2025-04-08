package keywords;

public class ApplicationKeywords extends ValidationKeywords{
	public void loginWithDefaultData() {
		type("username",prop2.getProperty("username_data"));
		type("password",prop2.getProperty("password_data"));
		click("login");
	}

}

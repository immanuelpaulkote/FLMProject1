package keywords;

import org.testng.Assert;

public class ValidationKeywords extends GenericKeywords{
	public void verifyTitle(String expTitle) {
		Assert.assertEquals(getTitle(), expTitle);
	}

}

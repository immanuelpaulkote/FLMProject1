package keywords;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest2;

public class GenericKeywords extends BaseTest2{
	public void startBrowser() {
		String bName=prop.getProperty("browser");
		switch (bName) {
		case "chrome":
			driver=new ChromeDriver();
			
			break;
		case "edge":
			driver=new EdgeDriver();
			
			break;

		default:
			
		}
		
	}
	public void launchApp() {
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(prop.getProperty("implicitWait"))));
		wait=new WebDriverWait(driver,Duration.ofSeconds(Long.parseLong(prop.getProperty("explicitWait"))));
		
	}
	public void clear(String locatorKey) {
		getElement(locatorKey).clear();
	}
	public void type(String locatorKey, String text) {
		//driver.findElement(By.xpath(prop2.getProperty(locatorKey))).sendKeys(text);
		getElement(locatorKey).sendKeys(text);
		
	}
	public void click(String locatorKey) {
		//driver.findElement(By.xpath(prop2.getProperty(locatorKey))).sendKeys(text);
		getElement(locatorKey).click();
		
	}
	public void selectFromDropdown(String locatorKey,String option) {
		new Select(getElement(locatorKey)).selectByVisibleText(option);
	}
	public String getTitle() {
		
		return driver.getTitle();
		
	}
	public String getText(String locatorKey) {
		
		return getElement(locatorKey).getText();
		
	}
	
	private WebElement getElement(String locatorKey) {
		WebElement element =null;
		wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));
		element=driver.findElement(getLocator(locatorKey));
		
		return element;
		
		
	}
	private By getLocator(String locatorKey) {
		By by=null;
		
		if(locatorKey.endsWith("_id")) {
			by=By.id(prop2.getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("_name")) {
			by=By.name(prop2.getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("_linktext")) {
			by=By.linkText(prop2.getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("_xpath")) {
			by=By.xpath(prop2.getProperty(locatorKey));
		}
		else {
			by=By.xpath(prop2.getProperty(locatorKey));
		}
		return by;
		
	}

}

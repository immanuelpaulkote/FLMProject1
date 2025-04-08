package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	public FileInputStream fis1;
	public Properties prop;
	public WebDriver driver;
	public WebDriverWait wait;
	
	@BeforeTest
	public void beforeTest() {
		try {
			fis1=new FileInputStream("C:\\Users\\imman\\eclipse-FLM\\DataAndKeywordDrivenFramework\\Properties\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prop=new Properties();
		try {
			prop.load(fis1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@BeforeMethod
	public void setUp() {
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
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(prop.getProperty("implicitWait"))));
		wait=new WebDriverWait(driver,Duration.ofSeconds(Long.parseLong(prop.getProperty("explicitWait"))));
		
	}
	@AfterMethod
	public void teardown() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
	

}

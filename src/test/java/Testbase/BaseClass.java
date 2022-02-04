package Testbase;


import java.util.concurrent.TimeUnit;

import Utils.ConfigReader;
import Utils.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseClass {

	protected static WebDriver driver;

	public static void setUp() {
		ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		switch (ConfigReader.getPropertyValue("browser")) {

		case "chrome":
			// System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new ChromeDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new FirefoxDriver();
				break;
			default:
				throw  new RuntimeException("Invalid browser");
		}
		driver.get(ConfigReader.getPropertyValue("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		PageInitializer.initializePageObjects();
	}

	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
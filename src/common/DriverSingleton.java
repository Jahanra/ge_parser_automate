package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSingleton {
	private static DriverSingleton driverSingleton;
	private WebDriver driver;

	/**
	 * Create private constructor
	 */
	private DriverSingleton() {
		String key = "webdriver.chrome.driver";
		String Value = "./Software/chromedriver.exe";
		System.setProperty(key, Value);
		driver = new ChromeDriver();
	}

	/**
	 * Create a static method to get instance.
	 */
	public static DriverSingleton getInstance() {
		if (driverSingleton == null) {
			driverSingleton = new DriverSingleton();
		}
		return driverSingleton;
	}
	
	public WebDriver getWebDriver() {
		return driver;
	}
}

package LoginCredentials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginAngel 
{
	public void  loginAngel()
	{
	String key="webdriver.chrome.driver";
	String Value="./Software/chromedriver.exe";
	System.setProperty(key, Value);
	WebDriver driver=new ChromeDriver();
	WebDriverWait wait=new WebDriverWait(driver,40);

	String user_name="jahanra_munshi@yahoo.com";
	String password="jahan11$7";

	
		driver.get("https://angel.co/login");
		driver.findElement(By.id("user_email")).sendKeys(user_name);
		driver.findElement(By.id("user_password")).sendKeys(password);
		
		
		driver.findElement(By.xpath("//input[@type='submit']")).submit();
		
        driver.get("https://angel.co/facebook");//data from excel sheet
	}
}

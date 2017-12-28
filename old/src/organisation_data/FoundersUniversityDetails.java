package organisation_data;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FoundersUniversityDetails  {

	
	    public void founderUniversaryDetails()
	    {
		// TODO Auto-generated method stub
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
				
	            driver.get("https://angel.co/facebook");
	    	
			  try {
			  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='founders section']//div[@class='name']/a")));
       	  driver.findElement(By.xpath("//div[@class='founders section']//div[@class='name']/a")).click();
       	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='js-list-container s-grid']//div[@class='u-colorGray6 u-uppercase school']/a")));
       	  String universityNamePath="//div[@class='js-list-container s-grid']//div[@class='u-colorGray6 u-uppercase school']/a";
       	  List<WebElement> universityName=driver.findElements(By.xpath(universityNamePath));
       	  System.out.println("University Name Size---->"+universityName.size());
       	  Iterator<WebElement> itr_University=universityName.iterator();
       	  if(universityName.size()>0)
       	  {
       		  while(itr_University.hasNext())
       		  {
       			  System.out.println(itr_University.next().getText());
       		  }
       	  }
       	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='js-list-container s-grid']//div[@class='u-colorGray6 u-uppercase school']/a")));
         }
         
         catch(IndexOutOfBoundsException e)
         {
       	  e.printStackTrace();
         }
		  finally
		  {
				driver.quit();
		}

	}
}



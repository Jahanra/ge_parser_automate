package organisation_data;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.CommonUtility;
import common.DriverSingleton;

public class FounderDetails
{
	WebDriver driver = DriverSingleton.getInstance().getWebDriver();
	WebDriverWait wait = CommonUtility.getDriverWait();
	WebElement waitTrue;
	public void getFoundersDetails ()throws InterruptedException
	{
		String foundersLinkPath;
		List<WebElement> foundersLink;
	    Iterator<WebElement> itrFounder;
	    String universityNamePath;
		List<WebElement> universityName;
		Iterator<WebElement> itrUniversity;
		foundersLinkPath = "//div[@class='founders section']//div[@class='g-lockup top larger']//div[@class='name']//a";
		foundersLink = driver.findElements(By.xpath(foundersLinkPath));
		System.out.println("Founders Link Size---->" + foundersLink.size());
		for(int i=0;i<foundersLink.size();i++)
		{
		try {
		itrFounder=foundersLink.iterator();
		
		while(itrFounder.hasNext())
		{
			driver.switchTo().window(itrFounder.next().getAttribute("href"));
			driver.get(itrFounder.next().getAttribute("href"));
			//System.out.println(itrFounder.next().getAttribute("href"));	
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='u-colorGrayB u-uppercase']")));
		universityNamePath = "//div[@class='js-list-container s-grid']//div[@class='u-colorGray6 u-uppercase school']/a";
		universityName = driver.findElements(By.xpath(universityNamePath));
		System.out.println("University Name Size---->" + universityName.size());
		itrUniversity = universityName.iterator();
		if (universityName.size() > 0) {
			while (itrUniversity.hasNext()) {
				
				System.out.println("University Name:----->" + itrUniversity.next().getText());
			}
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[@class='u-colorGrayB u-uppercase']")));

		}

		waitTrue = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='u-colorGrayB u-uppercase']")));

		if (waitTrue.isDisplayed()) {
			
			driver.close(); 
			
		}
		}
		}
		catch(IndexOutOfBoundsException e)
		{
			e.printStackTrace();
		}
}
}
	  
}
	

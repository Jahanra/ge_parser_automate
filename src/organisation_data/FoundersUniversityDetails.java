package organisation_data;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.CommonUtility;
import common.DriverSingleton;

public class FoundersUniversityDetails {

	public void getFounderUniversaryDetails() throws InterruptedException, AWTException {
		String universityNamePath;
		List<WebElement> universityName;
		Iterator<WebElement> itrUniversity;
		WebElement waitTrue;
		String foundersLinkPath;
		List<WebElement> foundersLink;
		String foundersDegreePath;
		List<WebElement> foundersDegree;
		Iterator<WebElement> itrDegree;
		String foundersExperienceXpath;
        List<WebElement> foundersExperienceCompanyName;
        Iterator<WebElement> itrExpCompanyName;
		WebElement itrFounder;
		String parenthandle = null;
		WebDriver driver = DriverSingleton.getInstance().getWebDriver();
		WebDriverWait wait = CommonUtility.getDriverWait();
		Actions actions = new Actions(driver);
		parenthandle = driver.getWindowHandle();
		foundersLinkPath = "//div[@class='founders section']//div[@class='g-lockup top larger']//div[@class='name']//a";
		foundersLink = driver.findElements(By.xpath(foundersLinkPath));
		for (int i = 0; i < foundersLink.size(); i++)
		{
			try {
				itrFounder = foundersLink.get(i);
				actions.contextClick(itrFounder).build().perform();
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyRelease(KeyEvent.VK_DOWN);

				
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				try {
					Thread.sleep(3000L);
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}   
				for (String childhandle : driver.getWindowHandles()) 
				{
					if (!(parenthandle.equals(childhandle)))
					{
						driver.switchTo().window(childhandle);
						try {
							Thread.sleep(6000L);
						} 
						catch (InterruptedException e) {
							e.printStackTrace();
						}   
						wait.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("//div[@class='u-colorGrayB u-uppercase']")));
						universityNamePath = "//div[@class='js-list-container s-grid']//div[@class='u-colorGray6 u-uppercase school']/a";
						universityName = driver.findElements(By.xpath(universityNamePath));
						
						itrUniversity = universityName.iterator();
						if (universityName.size() > 0)
						{
							while (itrUniversity.hasNext())
							{

								System.out.println("University Name:----->" + itrUniversity.next().getText());
							}
							wait.until(ExpectedConditions.visibilityOfElementLocated(
									By.xpath("//div[@class='u-colorGrayB u-uppercase']")));
							foundersDegreePath="//div[@class='degree u-colorGray3']";
							try {
							foundersDegree=driver.findElements(By.xpath(foundersDegreePath));
							 //System.out.println(foundersDegree);
							 itrDegree = foundersDegree.iterator();
							 //System.out.println("Degree Size------>"+foundersDegree.size());
							if(foundersDegree.size()>0)
							{
								while(itrDegree.hasNext())
								{
							System.out.println("Degree Name----->"+itrDegree.next().getText());

						     }
							}
							}

							catch(StaleElementReferenceException e){
								System.out.println("stale element");
							}catch (InvalidSelectorException e) {
								System.out.println("No valid selector found");
							}
							
							
							try {
								foundersExperienceXpath="//a[@class='u-unstyledLink']";
								foundersExperienceCompanyName=driver.findElements(By.xpath(foundersExperienceXpath));
								itrExpCompanyName=foundersExperienceCompanyName.iterator();
								if(foundersExperienceCompanyName.size()>0)
								{
									while(itrExpCompanyName.hasNext())
									{
										System.out.println("Experience Company Name---->"+itrExpCompanyName.next().getText());
									}
								}
								
							}
							catch (NoSuchSessionException e) {
								System.out.println("No such Session to find for....");
							}catch (WebDriverException e) {
								System.out.println("web driver problem");
							}
							 
						waitTrue = wait.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("//div[@class='degree u-colorGray3']")));

						if (waitTrue.isDisplayed()) {

							driver.close(); 
							driver.switchTo().window(parenthandle);
						}
					}
				}

				}
			}
				



			catch(IndexOutOfBoundsException e)
			{

				e.printStackTrace();
			}

			catch (Exception e)
			{

				e.printStackTrace();
				driver.quit();
			}

			/*
			 * finally {
			 * 
			 * driver.quit(); }
			 */
		}
	}
}
			

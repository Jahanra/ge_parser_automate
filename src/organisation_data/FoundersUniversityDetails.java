package organisation_data;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
		List<WebElement> foundersLink;
		String foundersLinkPath;
		WebElement itrFounder;
		String parenthandle = null;
		Set<String> childWindows = new HashSet<String>();
		WebDriver driver = DriverSingleton.getInstance().getWebDriver();
		WebDriverWait wait = CommonUtility.getDriverWait();
		Actions actions = new Actions(driver);

		foundersLinkPath = "//div[@class='founders section']//div[@class='g-lockup top larger']//div[@class='name']//a";
		foundersLink = driver.findElements(By.xpath(foundersLinkPath));
		System.out.println("Founders Link Size---->" + foundersLink.size());

		parenthandle = driver.getWindowHandle();
		System.out.println("parenthandle --> " + parenthandle);
		for (int i = 0; i < foundersLink.size(); i++) {
			try {
				itrFounder = foundersLink.get(i);
				actions.contextClick(itrFounder).build().perform();
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyRelease(KeyEvent.VK_DOWN);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(5000);

				childWindows = driver.getWindowHandles();
				System.out.println("windows size---" + childWindows.size());
				System.out.println("child windows" + childWindows.toString());
				int counter = 0;
				for (String childhandle : childWindows) {

					if (counter > 0) {
						System.out.println("childhandle --> " + childhandle);
						if (childhandle != parenthandle) {
							driver.switchTo().window(childhandle);

							wait.until(ExpectedConditions
									.visibilityOfElementLocated(By.xpath("//div[@class='u-colorGrayB u-uppercase']")));
/*							universityNamePath = "//div[@class='js-list-container s-grid']//div[@class='u-colorGray6 u-uppercase school']/a";
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
*/
							waitTrue = wait.until(ExpectedConditions
									.visibilityOfElementLocated(By.xpath("//div[@class='u-colorGrayB u-uppercase']")));

							if (waitTrue.isDisplayed()) {
								Thread.sleep(5000);
								driver.close(); 
								driver.switchTo().window(parenthandle);
							}
						}
					}
				}
				counter++;
			}

			catch (Exception e) {

				e.printStackTrace();
				driver.quit();
			}
		}

		/*
		 * finally {
		 * 
		 * driver.quit(); }
		 */
	}
}

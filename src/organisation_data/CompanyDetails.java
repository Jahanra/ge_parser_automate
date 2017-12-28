package organisation_data;

import java.awt.AWTException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.CommonUtility;
import common.DriverSingleton;
/**
 * @author Jahanra
 *
 */
public class CompanyDetails {

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver = DriverSingleton.getInstance().getWebDriver();
		WebDriverWait wait = CommonUtility.getDriverWait();
		driver.manage().window().maximize();
		String user_name = "jahanra_munshi@yahoo.com";
		String password = "jahan11$7";

		driver.get("https://angel.co/login");
		driver.findElement(By.id("user_email")).sendKeys(user_name);
		driver.findElement(By.id("user_password")).sendKeys(password);

		driver.findElement(By.xpath("//input[@type='submit']")).submit();

		driver.get("https://angel.co/paperspace");// data from excel sheet
		FoundersUniversityDetails foundersUniversityObj = new FoundersUniversityDetails();

		// get company name
		try {
			String companyName = driver.findElement(By.cssSelector("h1[class='u-fontWeight500 s-vgBottom0_5']"))
					.getText();
			System.out.println("Company Name is : " + companyName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// get company short description
		try {

			String companyShortDesc = driver.findElement(
					By.cssSelector("h2[class='js-startup_high_concept u-fontSize15 u-fontWeight400 u-colorGray3']"))
					.getText();

			System.out.println("Company Short Description  is : " + companyShortDesc);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			String companyLocation = driver.findElement(By.cssSelector("span[class='js-location_tags']")).getText();

			System.out.println("Company Location is :" + companyLocation);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			String companyCategories = driver.findElement(By.cssSelector("span[class='js-market_tags']")).getText();
			System.out.println("Company Categories is :" + companyCategories);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String companySize = driver.findElement(By.cssSelector("span[class='js-company_size']")).getText();
			System.out.println("Company Size is :" + companySize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String companyLink = driver.findElement(By.xpath("//a[contains(@class,'u-uncoloredLink company_url')]"))
					.getText();
			System.out.println("Company Link is :" + companyLink);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			String twitterUrl = "//a[@class='fontello-twitter u-uncoloredLink twitter_url']";
			WebElement companyTwitterUrlElement = driver.findElement(By.xpath(twitterUrl));

			String companyTwitterUrl = companyTwitterUrlElement.getAttribute("href");

			System.out.println("Company Twitter Url:" + companyTwitterUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String facebookUrl = "//a[@class='fontello-facebook u-uncoloredLink facebook_url']";
			WebElement companyFacebookUrlElement = driver.findElement(By.xpath(facebookUrl));
			String companyFacebookUrl = companyFacebookUrlElement.getAttribute("href");
			System.out.println("Company Facebook Url:" + companyFacebookUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			String linkedinUrl = "//a[@class='fontello-linkedin u-uncoloredLink linkedin_url']";
			WebElement companyLinkedUrlElement = driver.findElement(By.xpath(linkedinUrl));
			String companyLinkedUrl = companyLinkedUrlElement.getAttribute("href");
			System.out.println("Company Linked In Url :" + companyLinkedUrl);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String blogUrl = "//a[@class='fontello-rss u-uncoloredLink blog_url']";
			WebElement companyBlogUrlElement = driver.findElement(By.xpath(blogUrl));
			String companyBlogUrl = companyBlogUrlElement.getAttribute("href");
			System.out.println("Company Blog Url is :" + companyBlogUrl);

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			String productUrl = "//a[@class='fontello-product-hunt u-uncoloredLink producthunt_url']";
			WebElement companyproductUrlElement = driver.findElement(By.xpath(productUrl));
			String companyProductUrl = companyproductUrlElement.getAttribute("href");
			System.out.println("Company Product Url :" + companyProductUrl);

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {

			String founderNamePath = "//div[@class='founders section']//div[@class='name']//a[@class='profile-link']";
			List<WebElement> foundersName = driver.findElements(By.xpath(founderNamePath));
			System.out.println("Founders name size ----" + foundersName.size());
			Iterator<WebElement> itr_name = foundersName.iterator();
			if (foundersName.size() > 0) {
				while (itr_name.hasNext()) {
					System.out.println("Founders Name : " + itr_name.next().getText());

				}
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='header past_financing']")));
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}

		try {
			String founderUrl = "//div[@class='founders section']//div[@class='g-lockup top larger']//div[@class='name']//a";
			List<WebElement> foundersLink = driver.findElements(By.xpath(founderUrl));
			System.out.println("founders url Size is " + foundersLink.size());
			// Set<String> founderUniqueDetails = new HashSet<String>();
			Iterator<WebElement> itr_url = foundersLink.iterator();
			if (foundersLink.size() > 0) {
				while (itr_url.hasNext())

				{
					System.out.println("Founder Details URL" + itr_url.next().getAttribute("href"));


				}
			}
			// System.out.println("Founder Details URL"+founderUniqueDetails);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='header past_financing']")));
		}

		catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}

		try {
			String founderRole = "//div[@class='founders section']//div[@class='bio']/p";
			List<WebElement> foundersRoleTitle = driver.findElements(By.xpath(founderRole));
			System.out.println("Founders Role Size---->" + foundersRoleTitle.size());
			Iterator<WebElement> itr_role = foundersRoleTitle.iterator();
			if (foundersRoleTitle.size() > 0) {
				while (itr_role.hasNext()) {
					System.out.println("Founders Role---->" + itr_role.next().getText());
				}
			}
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@id='root_footer']")));
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		foundersUniversityObj.getFounderUniversaryDetails();


	}
}

package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import WebUtils.BrowserUtils;
import WebUtils.ElementUtils;

public class UnorderedListTest {
	static WebDriver  driver;

	public static void main(String[] args) throws InterruptedException {
		BrowserUtils br = new BrowserUtils();
		String url = "https://www.google.com/";
		driver = br.initDriver("chrome");
		br.launchURL(url);

		System.out.println("Title: " + br.getPageTitle());
		
		
		By searchBox = By.name("q");
		By suggestion = By.className("sbct");
		ElementUtils elementUtils = new ElementUtils(driver);
		
		elementUtils.searchAndSelectValueFromSuggestion(searchBox, suggestion, "selenium", "selenium webdriver");
		System.out.println(elementUtils.getElement(searchBox).getAttribute("value"));
		
		
	}
	public static boolean searchAndSelectValueFromSuggestion(By search, String key, String value) throws InterruptedException {
		
//		driver.get("http://automationpractice.com/");
		
		driver.findElement(search).sendKeys(key);
		Thread.sleep(2000);

		List<WebElement> suggestions = driver.findElements(By.xpath(
				"//span[contains(text(), \""+value+"\")]"));
		if(suggestions.isEmpty())
			return false;
		else
		{
			suggestions.get(0).click();
			return true;
		}
	}

}

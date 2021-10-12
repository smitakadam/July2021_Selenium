package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PaginationCarousel {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		
		By section = By.xpath("//span[text()='Top Beauty & Personal Care products']");
		By nextFeed = By.xpath("//span[text()='Top Beauty & Personal Care products']"
				+ "/parent::h2/parent::div/following-sibling::div"
				+ "/a[contains(@aria-label, 'next slide') and contains(@class, 'feed-right')]");
		
//		By prodList = By.xpath("//span[text()='Top Beauty & Personal Care products']"
//				+ "/parent::h2/parent::div/following-sibling::div/div/ul/li/span/a/img");
		By prodList = By.xpath("//span[text()='Top Beauty & Personal Care products']"
				+ "/parent::h2/parent::div/following-sibling::div/div");
		
		//span[text()='Top Beauty & Personal Care products']/parent::h2/parent::div/following-sibling::div/div/ul/li
		
		//span[text()='Top Beauty & Personal Care products']/parent::h2/parent::div/following-sibling::div
//		a-link-normal feed-carousel-control feed-right feed-control-disabled
		//a[contains(@aria-label, 'next slide') and contains(@class, 'feed-right')]
		
		WebElement next =driver.findElement(nextFeed);
		List<WebElement> productList = driver.findElements(prodList);
		int i=0;
		Thread.sleep(3000);
			
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(section));
		Thread.sleep(500);
		
		System.out.println(productList.size());
		
		while(!next.getAttribute("class").contains("feed-control-disabled"))
		{
			System.out.println(productList.get(i).getAttribute("alt"));
//			Dove Beauty Bar Gentle Cleanser for Softer and Smoother Skin with 1/4 Moisturizing Cream White More Moisturizing than...
			System.out.println("");
			
			next.click();
			productList = driver.findElements(prodList);
			i++;
		}
		
	}

}

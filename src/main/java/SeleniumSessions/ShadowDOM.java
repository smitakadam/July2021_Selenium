package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDOM {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://books-pwakit.appspot.com/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;

//		WebElement ele = (WebElement) js
//				.executeScript("return document."
//						+ "querySelector('body>book-app')."
//						+ "shadowRoot.querySelector('#input')");
//		ele.sendKeys("option");
		System.out.println("Title: "+ driver.getTitle());
				
		js.executeScript("return document." + "querySelector('body>book-app')."
				+ "shadowRoot.querySelector('#input').value = 'option'");
		
		driver.findElement(By.tagName("body")).click();
		
		System.out.println("Title: "+ driver.getTitle());
		
		
		
	}

}

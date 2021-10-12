package WebUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Smita Kadam
*/

public class BrowserUtils {

	WebDriver driver;

	
	/**
	 * This method initiates the driver based on the given browser name.
	 * 
	 * @param browserName - name of the browser to be launched
	 * 
	 * @param url - my url
	 * @return the driver object
	 **/
	public WebDriver initDriver(String browserName) 
	{
		switch (browserName.toLowerCase()) 
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		case "edge":
			WebDriverManager.chromedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("please pass the right browser..." + browserName);
			break;
		}
		return driver;
	}

	public void launchURL(String url) 
	{
		if(url==null || url.isEmpty())
		{
			System.out.println("Given url is incorrect.");
			return;
		}
		driver.manage().window().maximize();
		driver.get(url);
	}
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}
	public String getPageTitle() 
	{
		return driver.getTitle();
	}
	public void closeBrowser() 
	{
		driver.close();
	}
	public void quitBrowser() 
	{
		driver.quit();
	}
}

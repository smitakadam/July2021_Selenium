package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseVsQuit {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Smita\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		
		System.out.println("Title: "+ driver.getTitle());
		
		driver.close();
		driver = new ChromeDriver();
		
		System.out.println("Title: "+ driver.getTitle());
		

		driver.quit();
	}

}

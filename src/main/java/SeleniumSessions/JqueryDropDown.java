package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import WebUtils.BrowserUtils;
import WebUtils.ElementUtils;

public class JqueryDropDown {
	static WebDriver  driver;

	public static void main(String[] args) {
		BrowserUtils br = new BrowserUtils();
		String url = "https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/";
		driver = br.initDriver("chrome");
		br.launchURL(url);

		System.out.println("Title: " + br.getPageTitle());
		
		By justAnotherInputBox = By.id("justAnotherInputBox");
		
		ElementUtils elementUtils = new ElementUtils(driver);
		
		elementUtils.getElement(justAnotherInputBox).click();
		
//		
	}

}

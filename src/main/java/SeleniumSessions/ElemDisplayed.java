package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import WebUtils.BrowserUtils;
import WebUtils.ElementUtils;

public class ElemDisplayed {
	static WebDriver  driver;

	public static void main(String[] args) throws InterruptedException {
		BrowserUtils br = new BrowserUtils();
		String url = "https://classic.freecrm.com/register/";
		driver = br.initDriver("chrome");
		br.launchURL(url);

		System.out.println("Title: " + br.getPageTitle());
		By submit = By.id("submitButton");
		By agreeTerms = By.name("agreeTerms");
		
		
		ElementUtils elementUtils = new ElementUtils(driver);
		if(elementUtils.getElement(submit).isDisplayed())
			System.out.println("Element is displayed.");
		else
			System.out.println("Element is Not displayed.");
		
		if(elementUtils.getElement(submit).isEnabled())
			System.out.println("Element is Enabled.");
		else
			System.out.println("Element is Not Enabled.");
		
		if(elementUtils.getElement(agreeTerms).isSelected())
			System.out.println("Element is Selected.");
		else
			System.out.println("Element is Not Selected.");
		
		
		
	}

}

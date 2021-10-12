package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import WebUtils.BrowserUtils;
import WebUtils.ElementUtils;

public class DropdownTest {
	static WebDriver  driver;

	public static void main(String[] args) {
		BrowserUtils br = new BrowserUtils();
		String url = "https://www.orangehrm.com/orangehrm-30-day-trial/";
		driver = br.initDriver("chrome");
		br.launchURL(url);

		System.out.println("Title: " + br.getPageTitle());
		
		By country = By.id("Form_submitForm_Country");
		
		
		ElementUtils elementUtils = new ElementUtils(driver);
		String value  = "India";
		if(elementUtils.dropdownSelectByValue(country, value))
			System.out.println(value + " is selected.");
		else
			System.out.println(value + " is NOT selected.");
		value = "India12";
		
		if(elementUtils.dropdownCheckAndSelectByValue(country, value))
			System.out.println(value + " is selected.");
		else
			System.out.println(value + " is NOT selected.");
		
		
		int index = 5;
		if(elementUtils.dropdownSelectByIndex(country, index))
			System.out.println("Index "+ index + " is selected.");
		else
			System.out.println("Index "+ index + " is NOT selected.");
//		System.out.println("size = "+ elementUtils.getDropDownOptions(country).size());
//		
//		elementUtils.dropdownSelectByIndex(country, elementUtils.getDropDownOptions(country).size()+1);
//		index = 232;
//		if(elementUtils.dropdownSelectByIndex(country, index))
//			System.out.println("Index "+ index + " is selected.");
//		else
//			System.out.println("Index "+ index + " is NOT selected.");
//		
		
		System.out.println("Script ends....");
//		if()
//			System.out.println(value + " is selected.");
//		else
//			System.out.println(value + " is NOT selected.");
		
		
	}
	
	
	

}

package OpenCartTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import WebUtils.BrowserUtils;
import WebUtils.ElementUtils;

public class TestBrowserUtils {
	static WebDriver  driver;

	public static void main(String[] args) {
		BrowserUtils br = new BrowserUtils();
		String url = "https://demo.opencart.com/index.php?route=account/register";
		driver = br.initDriver("chrome");
		br.launchURL(url);

		System.out.println("Title: " + br.getPageTitle());
		
		By fname = By.id("input-firstname");
		By lname = By.id("input-lastname");
		By email = By.id("input-email");
		By telephone = By.id("input-telephone");
		By password = By.id("input-password");
		By confirm = By.id("input-confirm");
		By agree = By.name("agree");
		By btnContinue = By.xpath("//*[@type=\"submit\" and @value=\"Continue\"]");
		
		ElementUtils elementUtils = new ElementUtils(driver);
		int count =2; 
		if(elementUtils.chkIfElementPresent(email,count))
			System.out.println("Element 'email' is present.");
		else
			System.out.println("Element 'email' is not present '"+ count +"' times.");
//		
//		elementUtils.doSendKeys(fname, "Smita");
//		elementUtils.doSendKeys(lname, "Smita");
//		elementUtils.doSendKeys(email, "Smita");
//		elementUtils.doSendKeys(telephone, "Smita");
//		elementUtils.doSendKeys(password, "Smita");
//		elementUtils.doSendKeys(confirm, "Smita");
//		elementUtils.doClick(agree);
//		
//		elementUtils.doClick(btnContinue);
		//*[@id="account-register"]/div[contains(text()," Warning: You must agree to the Privacy Policy!")]
		
//		By inputs = By.tagName("input");
//		List<WebElement> inputList = driver.findElements(inputs);
//		for(WebElement ele: inputList)
//		{
//			if(ele.getAttribute("type").equals("text"))
//				System.out.println("PlaceHolder: "+ ele.getAttribute("placeholder"));
//		}
		br.closeBrowser();
		
	}

}

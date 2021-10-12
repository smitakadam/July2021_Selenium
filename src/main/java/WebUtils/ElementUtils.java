package WebUtils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Quotes;
import org.openqa.selenium.support.ui.Select;

public class ElementUtils {

	WebDriver driver;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	/**
	 * This method is used to click on WebElement defined by 'By locator', when
	 * there are multiple WebElements being located by given parameter'locator' and
	 * having given 'text'.
	 * 
	 * @param locator - By locator object to locate the WebElements text - to locate
	 *                unique WebElement to click
	 */
	public void doClick(By locator, String text) {
		List<WebElement> LinksList = getElements(locator);
		for (WebElement ele : LinksList) {
			String eleText = ele.getText();
			System.out.println(eleText);
			if (eleText.equals(text)) {
				ele.click();
			}
		}
	}

	/**
	 * This method is used to check if WebElement is present on web page.
	 * 
	 * @param locator - By locator object to locate the WebElement
	 * @return - true if WebElement is present otherwise false
	 */
	public boolean chkIfElementPresent(By locator) {
		if (getElementCount(locator) == 1)
			return true;
		return false;
	}

	/**
	 * This method is used to check if WebElement is present on web page for given
	 * number of times.
	 * 
	 * @param locator - By locator object to locate the WebElements
	 * @return - true if WebElement is present for given number of times, otherwise
	 *         false
	 */
	public boolean chkIfElementPresent(By locator, int count) {
		System.out.println(getElementCount(locator));
		System.out.println(count);
		if (getElementCount(locator) == count)
			return true;
		return false;
	}

	public int getElementCount(By locator) {
		return getElements(locator).size();
	}

	/******************** Dropdown methods ********************/

	/**
	 * This method is used to select option from drop down by value attribute.
	 * 
	 * @param locator - By locator object to locate the WebElements 
	 * 	@param	value - string that is equal to 'value' attribute's value
	 * @return - true if WebElement is present for given number of times, otherwise
	 *         false
	 */

	public boolean dropdownSelectByValue(By locator, String value) {
		WebElement dropdown = getElement(locator);
		Select select = new Select(dropdown);
		select.selectByValue(value);
		if (select.getFirstSelectedOption().getAttribute("value").equals(value))
			return true;
		return false;
	}

	public boolean dropdownCheckAndSelectByValue(By locator, String value) {
		if (dropdownCheckIfItemExistsByValue(locator, value)) {
			WebElement dropdown = getElement(locator);
			Select select = new Select(dropdown);
			select.selectByValue(value);
			if (select.getFirstSelectedOption().getAttribute("value").contains(value))
				return true;
		}
		return false;

	}

	public boolean dropdownSelectByIndex(By locator, int index) {
		WebElement dropdown = getElement(locator);
		Select select = new Select(dropdown);
		select.selectByIndex(index);
		if (select.getFirstSelectedOption().getAttribute("index").equals(String.valueOf(index)))
			return true;
		return false;
	}

	public void dropdownSelectByVisibleText(By locator, String value) {
		WebElement dropdown = getElement(locator);

		Select select = new Select(dropdown);
		select.selectByVisibleText(value);
	}

	public boolean dropdownSelectContainsVisibleText(By locator, String value) {

		List<WebElement> options = getDropDownOptions(locator);
		for (WebElement option : options) {
			if (option.getText().toLowerCase().contains(value.toLowerCase())) {
				option.click();
				return true;
			}
		}
		return false;
	}

	public boolean dropdownCheckIfItemExists(By locator, String value) {
		List<WebElement> options = getDropDownOptionsByText(locator, value);
		if (options.isEmpty())
			return false;
		return true;
	}

	public boolean dropdownCheckIfItemExistsByValue(By locator, String value) {
		List<WebElement> options = getDropDownOptionsByValue(locator, value);

		if (options.isEmpty())
			return false;
		return true;
	}

	public List<WebElement> getDropDownOptions(By locator) {
		WebElement dropdown = getElement(locator);
		Select select = new Select(dropdown);
		return select.getOptions();

	}

	public List<WebElement> getDropDownOptionsByText(By locator, String text) {

		WebElement dropdown = getElement(locator);
		return dropdown.findElements(By.xpath(".//option[normalize-space(.) = " + Quotes.escape(text) + "]"));

	}

	public List<WebElement> getDropDownOptionsByValue(By locator, String value) {

		WebElement dropdown = getElement(locator);
		return dropdown.findElements(By.xpath(".//option[@value = " + Quotes.escape(value) + "]"));

	}

	/********************
	 * Select value from suggestion/unordered list (
	 * <ul>
	 * ). HTML tags
	 * <ul>
	 * <li>
	 * @param 	search - By locator to send keys for search
	 * @param	suggest - By locator to select given value from suggestion list
	 * 	@param	key - String to send keys in search field
	 * 	@param 	value - exact value to select from suggestion list
	 *   
	 * @throws InterruptedException
	 ********************/

	public void searchAndSelectValueFromSuggestion(By search, By suggest, String key, String value) throws InterruptedException {
		getElement(search).sendKeys(key);
		Thread.sleep(2000);

		List<WebElement> suggestions = getElements(suggest);
		for (WebElement li : suggestions) {
			if (li.getText().equalsIgnoreCase(value)) {
				li.click();
				break;
			}
		}
	}
	/********************
	 * Select value from suggestion/unordered list (
	 * <ul>
	 * ). HTML tags
	 * <ul>
	 * <li>
	 * @param 	search - By locator to send keys for search
	 * 	@param	key - String to send keys in search field
	 * 	@param 	value - exact value to select from suggestion list
	 *   
	 * @throws InterruptedException
	 */
	public boolean searchAndSelectValueFromSuggestion(By search, String key, String value) throws InterruptedException {
		getElement(search).sendKeys(key);
		Thread.sleep(2000);

		List<WebElement> suggestions = getElements(By.xpath(
				"//li[contains(text(), '" + value + "')]"));
		if(suggestions.isEmpty())
			return false;
		else
		{
			suggestions.get(0).click();
			return true;
		}
	}

}

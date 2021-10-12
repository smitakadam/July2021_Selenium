package timeAppWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import WebUtils.BrowserUtils;
import WebUtils.ElementUtils;

public class BookAppointment {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		BrowserUtils br = new BrowserUtils();
		ElementUtils element;
		By mobile = By.xpath("//button[contains(text(), \"Find doctor\")]/parent::form/div/input[@id=\"mobile\"]");
		By findDoctor = By.xpath("//button[contains(text(), \"Find doctor\")]");
		By selectDoctor = By.xpath("//select[@id=\"uid\"]");
		By appointment_for = By.id("appointment_for");
		By appointment_purpose = By.id("appointment_purpose");

//		String url = "https://demo.opencart.com/index.php?route=account/register";
		String url = "https://instaheal.co/";
		driver = br.initDriver("chrome");

		br.launchURL(url);
		element = new ElementUtils(driver);

		String value = "8080229592";
		element.doSendKeys(mobile, value);
		element.doClick(findDoctor);

		if (br.getPageTitle().equalsIgnoreCase("wellness clinic - timeapp"))
			System.out.println(br.getPageTitle() + "PASS");
		else
			System.out.println(br.getPageTitle() + "FAIL");
		element.dropdownSelectByVisibleText(selectDoctor, "Dr Rajiv Mishra, Rahatani");

		element.dropdownSelectContainsVisibleText(appointment_for, "checkup");

		element.doSendKeys(appointment_purpose, "head ache");
//		element.doSendKeys(By.id("datepicker"), "7-Sep-2021");
		element.doSendKeys(By.id("datepicker"),"");

		String date_ent = "9-Sep-2021";
		String date_ent1[] = date_ent.split("-");
		String shipFDay = date_ent1[0];
		String shipFMonth = date_ent1[1];
		String shipFYear = date_ent1[2];
		WebElement month = element.getElement(By.xpath("//button[@aria-label=\"Choose month and year\"]/span/span"));
		String date_pres = month.getText();
		System.out.println(date_pres);

		String dp[] = date_pres.split(" ");
		String month_pres = dp[0];
		String year_pres = dp[1];
		
		if (year_pres.equals(shipFYear)) {
			month.click();

			element.getElement(By.xpath("//span[contains(.,'" + shipFMonth + "')]")).click();
		    Thread.sleep(5000);

		} else if (Integer.parseInt(year_pres) > Integer.parseInt(shipFYear)) {
			element.getElement(By.xpath("//th[@title='Select Month']")).click();

		    while (2 > 1) {
		        year_pres = element.getElement(By.xpath("//th[@title='Select Year']")).getText();
		        if (year_pres.equalsIgnoreCase(shipFYear)) {

		        	element.getElement(By.xpath("//span[contains(.,'" + shipFMonth + "')]")).click();
		            Thread.sleep(5000);
		            break;
		        }
		        element.getElement(By.xpath("//span[@title='Previous Year']")).click();
		    }

		} else {
			element.getElement(By.xpath("//th[@title='Select Month']")).click();
		    while (2 > 1) {
		        year_pres = driver.findElement(By.xpath("//th[@title='Select Year']")).getText();
		        if (year_pres.equalsIgnoreCase(shipFYear)) {

		            driver.findElement(By.xpath("//span[contains(.,'" + shipFMonth + "')]")).click();

		            Thread.sleep(5000);
		            break;
		        }
		        element.getElement(By.xpath("//span[@title='Next Year']")).click();
		    }
		}

switch (shipFMonth) {
case "Jan": {
    driver.findElement(By.xpath("//td[@data-day='01/" + shipFDay + "/" + shipFYear + "']")).click();
    System.out.println("Date Selected");
    break;
}

case "Feb": {
    driver.findElement(By.xpath("//td[@data-day='02/" + shipFDay + "/" + shipFYear + "']")).click();
    System.out.println("Date Selected");
    break;
}
case "Mar": {
    driver.findElement(By.xpath("//td[@data-day='03/" + shipFDay + "/" + shipFYear + "']")).click();
    System.out.println("Date Selected");
    break;
}
case "Apr": {
    driver.findElement(By.xpath("//td[@data-day='04/" + shipFDay + "/" + shipFYear + "']")).click();
    System.out.println("Date Selected");
    break;
}
case "May": {
    driver.findElement(By.xpath("//td[@data-day='05/" + shipFDay + "/" + shipFYear + "']")).click();
    System.out.println("Date Selected");
    break;
}
case "Jun": {
    driver.findElement(By.xpath("//td[@data-day='06/" + shipFDay + "/" + shipFYear + "']")).click();
    System.out.println("Date Selected");
    break;
}
case "Jul": {
    driver.findElement(By.xpath("//td[@data-day='07/" + shipFDay + "/" + shipFYear + "']")).click();
    System.out.println("Date Selected");
    break;
}
case "Aug": {
    driver.findElement(By.xpath("//td[@data-day='08/" + shipFDay + "/" + shipFYear + "']")).click();
    System.out.println("Date Selected");
    break;
}
case "Sep": {
    driver.findElement(By.xpath("//td[@data-day='09/" + shipFDay + "/" + shipFYear + "']")).click();
    System.out.println("Date Selected");
    break;
}
case "Oct": {
    driver.findElement(By.xpath("//td[@data-day='10/" + shipFDay + "/" + shipFYear + "']")).click();
    System.out.println("Date Selected");
    break;
}
case "Nov": {
    driver.findElement(By.xpath("//td[@data-day='11/" + shipFDay + "/" + shipFYear + "']")).click();
    System.out.println("Date Selected");
    break;
}
case "Dec": {
    driver.findElement(By.xpath("//td[@data-day='12/" + shipFDay + "/" + shipFYear + "']")).click();
    System.out.println("Date Selected");
    break;
}
default: {
    System.out.println("Please enter the date in the standard format like DD-MMM-yyyy");
 break;
}
}
//		br.quitBrowser();
	}

}

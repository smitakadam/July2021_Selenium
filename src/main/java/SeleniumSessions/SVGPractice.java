package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGPractice {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://emicalculator.net/");
		driver.manage().window().maximize();
		
		//*[local-name()='svg' and @class='highcharts-root']
		//*[local-name()='svg']//*[name()='g' and @class='highcharts-series-group']//*[name()='path' and contains(@class, 'highcharts-point highcharts-color-')]
		//*[local-name()='svg' and contains(@class,'highcharts-root')]
		//*[local-name()='svg' and @class='highcharts-root' ]//*[name()='g' and contains(@class, 'tooltip')]
		//*[local-name()='svg' and contains(@class,'highcharts-root')]//*[name()='text' ]//*[name() = 'tspan' and  contains(text() , "Break-up of Total")]

		List<WebElement> pie = driver.findElements(By.xpath("//*[local-name()='svg']"
				+ "//*[name()='g' and contains(@class,'highcharts-series-group')]"
				+ "//*[name()='path' and contains(@class, 'highcharts-point highcharts')]"));
		By tooltip = By.xpath("//*[local-name()='svg' and @class='highcharts-root' ]"
				+ "//*[name()='g' and contains(@class, 'tooltip')]");
		Actions act = new Actions(driver);
		System.out.println(pie.size());
		for(WebElement e: pie)
		{
			act.moveToElement(e).perform();
			System.out.println(driver.findElement(tooltip).getText());
			
		}
		
	}

}

package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class WebConnector {
	private final static long DEFAULT_TIMEOUT = 2000;
	WebDriver driver = new FirefoxDriver();

	@Before
	public void initSelenium() throws Exception {
	}

	@After
	public void destroySelenium() {
		driver.close();
	}

	public void fillInData(String selector, String keyword) {
		WebElement element = driver.findElement(By.id(selector));
		element.sendKeys(keyword);
	}

	public void clickAndWait(String selector) {
		WebElement element = driver.findElement(By.id(selector));
		element.click();
		driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS);
	}

	public void openAndWait(String location) {
		driver.get(location);
		// driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT,
		// TimeUnit.MILLISECONDS);
	}

	public boolean isTextPresent(String text) {
		return driver.getPageSource().contains(text);
	}
}

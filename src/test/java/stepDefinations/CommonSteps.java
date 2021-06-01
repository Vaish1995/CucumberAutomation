package stepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CommonSteps {

	WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Global before got executed");
	}
	
	@After
	public void teardown() throws Exception  {
		driver.quit();
		Thread.sleep(1000);
	}
	
	@Before("@setCookies")
	public void setCookies() {
		System.out.println("Scenario specific hook - setCookies executed");
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}

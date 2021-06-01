package stepDefinations;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Ebay_Home_Steps {

	WebDriver driver;

	public Ebay_Home_Steps(CommonSteps comn_steps) {
		this.driver = comn_steps.getDriver();
	}
	
	
	
	@When("Search for {string}")
	public void search_for(String str1) throws Exception {
	   driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys(str1);
	   driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
	   Thread.sleep(2000);
	}

	@Then("Validate that Save this search option is present")
	public void validate_that_Save_this_search_option_is_present() {
	   String strng = driver.findElement(By.xpath("//span[contains(text(),'Save this search')]")).getText();
	   System.out.println(strng);
	   Assert.assertEquals("Save this search", strng);
	   
	}
	
	@When("Search for {string} in {string} category")
	public void search_for_in_category(String string, String string2) throws Exception {
	    driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys(string);
	    driver.findElement(By.xpath("//select[@id='gh-cat']")).click();
	    List<WebElement> cat = driver.findElements(By.xpath("//select[@id='gh-cat']/option"));
	    Thread.sleep(3000);
	    for(WebElement x: cat) {
	    	if(x.getText().equals(string2)) {
	    		x.click();
	    		Thread.sleep(3000);
	    		break;
	    	}
	    	
	    }
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
	    Thread.sleep(2000);
	}
	
	@When("I click on {string}")
	public void i_click_on(String string) {
	    driver.findElement(By.linkText(string)).click();
	}

	@Then("I validate page navigate to {string} and title contains {string}")
	public void i_validate_page_navigate_to_and_title_contains(String url, String title) {
	    String actUrl = driver.getCurrentUrl();
	    String actTitle = driver.getTitle();
	    if(!actUrl.equals(url)) {
	    	fail("Page does not match with expected url:" + url);
	    }
	    if(!actTitle.contains(title)) {
	    	fail("Title not matching");
	    }
	}
}

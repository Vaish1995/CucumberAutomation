package stepDefinations;

import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Ebay_Advanced_Steps {

	WebDriver driver;

	public Ebay_Advanced_Steps(CommonSteps comn_steps) {
		this.driver = comn_steps.getDriver();
	}
	
	@Given("I am on Ebay homepage")
	public void i_am_on_ebay_homepage() {
		
		driver.get("https://www.ebay.com/");
	}

	@When("I click on Advanced link")
	public void i_click_on_advanced_link() {
	    driver.findElement(By.linkText("Advanced")).click();
	}

	@Then("I navigate to Advanced search page")
	public void i_navigate_to_advanced_search_page() {
	    String expUrl = "https://www.ebay.com/sch/ebayadvsearch";
	    String actUrl = driver.getCurrentUrl();
	    if(!expUrl.equals(actUrl)) {
	    	fail("Page does not match");
	    }
	    
	    
	}
	
	@Given("I am on Ebay Advanced page")
	public void i_am_on_ebay_advanced_page() {
		driver.get("https://www.ebay.com/");
		driver.findElement(By.xpath("//a[@id='gh-as-a']")).click();
	}
	
	@When("I advanced search an item")
	public void i_advanced_search_an_item(DataTable dataTable) throws Exception {
		driver.findElement(By.xpath("//input[@id='_nkw']")).sendKeys(dataTable.cell(1, 0));
		driver.findElement(By.xpath("//input[@id='_ex_kw']")).sendKeys(dataTable.cell(1, 1));
		driver.findElement(By.xpath("//body/div[@id='Body']//fieldset[3]/input[2]")).sendKeys(dataTable.cell(1, 2));
		driver.findElement(By.xpath("//body/div[@id='Body']//fieldset[3]/input[3]")).sendKeys(dataTable.cell(1, 3));
		driver.findElement(By.xpath("//button[@id='searchBtnLowerLnk']")).click();
		Thread.sleep(3000);
	}
}

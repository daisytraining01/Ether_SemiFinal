package com.ether.steps;

import java.sql.ResultSet;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ether.base.SeleniumDriver;
import com.ether.base.TestUtil;
import com.ether.pages.actions.LoginAction;
import com.ether.pages.locators.AddEditPage;
import com.ether.pages.locators.HomePageLocators;
import com.ether.pages.locators.LoginPageLocators;

//import com.ether.pages.locators.loginPageLocators;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SampleTestLogin {
	TestUtil util = new TestUtil();
	LoginPageLocators locator = new LoginPageLocators();
	HomePageLocators locatorHome=new HomePageLocators();
	AddEditPage locatorAddEdit=new AddEditPage();
	ResultSet result;

	
	@And("^login with myuserName and mypassword$")
	public void loginWithusername() throws Exception {
		String userName = null;
		String password = null;
		util.setUpDBConnection();
		String query = "Select * from User_Details";
		result = util.getDataFromDB(query);

		while (result.next()) {
			userName = result.getString("Username");
			password = result.getString("Password");
		}
		locator.username.sendKeys(userName);
		locator.password.sendKeys(password);
		util.closeDBConnection();

	}
	
	@Given("^enable rememberme option$")
	public void enable_rememberme_option() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		locator.rememberMeCheckBox.click();
		locator.signIn.click();
	   
	}

	@Then("^verify the Home Page$")
	public void verify_the_Home_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		boolean b=locatorHome.homeButton.isDisplayed();
		Assert.assertEquals(b, true);
		
	    
	}

	@When("^user logout from the Home page$")
	public void user_logout_from_the_Home_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		locatorHome.userDetails.click();
		locatorHome.logout.click();
		
	    
	}

	@Then("^verify the login page$")
	public void verify_the_login_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		boolean b=locator.username.isDisplayed();
		Assert.assertEquals(b, true);
		
	    
	}

	@Then("^verify default username content in the username textbox$")
	public void verify_default_username_content_in_the_username_textbox() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement us=locator.username;
		if (us.getAttribute("value").isEmpty()) {
		    //Do something if the text field is empty
			Assert.fail();
		}
		else {
		    //Store the value
		    String usernamevalue=us.getAttribute("value");
		    String expected=result.getString("Username");
		    System.out.println(usernamevalue);
		    Assert.assertEquals(usernamevalue, expected);
		}
		
	    
	}
	
	@When("^user clicks the Transfer tab AddEdit Reciepient option$")
	public void user_clicks_the_Transfer_tab_AddEdit_Reciepient_option() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//locatorHome.transfer.click();
		
		SeleniumDriver.getDriver().findElement(By.xpath("//a[contains(text(),'Transfer')]")).click();
		locatorHome.addRecipient.click();
		
	    
	}

	@Then("^verify Recipient Information page$")
	public void verify_Recipient_Information_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		boolean d=locatorAddEdit.name.isDisplayed();
		Assert.assertEquals(d, true);
		JavascriptExecutor js = (JavascriptExecutor) SeleniumDriver.getDriver();
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		
	    
	}

	@Then("^user clicks on delete button$")
	public void user_clicks_on_delete_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//locatorAddEdit.deleteButton.click();
		SeleniumDriver.getDriver().findElement(By.xpath("//tr[6]//td[6]//a[1]")).click();
		Thread.sleep(3000);
		
	}

	
	
	@When("^I enter Username as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void i_enter_Username_as_and_Password_as(String username, String password) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		locator.username.sendKeys(username);
		locator.password.sendKeys(password);
		
	    
	}

	@Then("^login should be unsuccessful$")
	public void login_should_be_unsuccessful() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		locator.rememberMeCheckBox.click();
		locator.signIn.click();
		//boolean value=locator.invalidusertext.isDisplayed();
		boolean value=SeleniumDriver.getDriver().findElement(By.xpath("//div[@class='bg-danger']")).isDisplayed();
		Assert.assertEquals(value, true);
		
	    
	}

}

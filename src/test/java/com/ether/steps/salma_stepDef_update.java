package com.ether.steps;

import java.sql.ResultSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ether.base.SeleniumDriver;
import com.ether.base.TestUtil;
import com.ether.pages.actions.LoginAction;
import com.ether.pages.locators.HomePageLocators;
import com.ether.pages.locators.LoginPageLocators;
import com.ether.pages.locators.RegisterPageLocators;

import cucumber.api.PendingException;
//import com.ether.pages.locators.loginPageLocators;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class salma_stepDef_update {
	TestUtil util = new TestUtil();
	LoginPageLocators locator = new LoginPageLocators();
	RegisterPageLocators locatorss = new RegisterPageLocators();
	HomePageLocators locators = new HomePageLocators();

	@Given("^Launch the url$")
	public void loginToUrl() {
		SeleniumDriver.openPage("http://elastic.rapidtestpro.com:8086/index");
	}

	@And("^login with userName1 and password1$")
	public void loginWithusername() throws Exception {

		String userName = null;
		String password = null;
		util.setUpDBConnection();
		String query = "Select * from user_details ";

		ResultSet result = util.getDataFromDB(query);
		// result.next();
		// result.next();
		// result.next();
		result.next();

		userName = result.getString("username");
		password = result.getString("password");
		// util.closeDBConnection();
		locatorss.username.sendKeys(userName);
		locatorss.password.sendKeys(password);
		locator.signIn.click();
		util.closeDBConnection();
	}

	@When("^Click on me$")
	public void click_on_me() throws Throwable {

		System.out.println("you are on home page");

	}

	@When("^you are in home page$")
	public void you_are_in_home_page() throws Throwable {

		locators.userDetails.click();
	}

	@Then("^Click on profile$")
	public void click_on_profile() throws Throwable {

		locators.userProfile.click();

	}

	@Then("^validate firstName$")
	public void validate_firstName() throws Throwable {

		String firstname = null;
		String first = locatorss.firstName.getAttribute("value");
		util.setUpDBConnection();
		String query = "Select firstName from profile_validation";
		ResultSet result = util.getDataFromDB(query);
if(result.next())
		firstname = result.getString("firstName");
		Assert.assertEquals(first, firstname);
		if (first.equals(firstname)) {
			System.out.println("firstname is matched!!");
		}
		util.closeDBConnection();

	}

	@Then("^validate lastName$")
	public void validate_lastName() throws Throwable {

		String lastname = null;
		String last = locatorss.lastName.getAttribute("value");
		util.setUpDBConnection();
		String query = "Select lastName from profile_validation";
		ResultSet result = util.getDataFromDB(query);
if(result.next())
		lastname = result.getString("lastName");
Assert.assertEquals(last, lastname);

		if (last.equals(lastname)) {
			System.out.println("lastname is matched!!");
		}
		util.closeDBConnection();

	}

	@Then("^Validate phone number$")
	public void validate_phone_number() throws Throwable {

		String phone1 = null;
		String phone2 = locatorss.phone.getAttribute("value");
		util.setUpDBConnection();
		String query = "Select phone from profile_validation";
		ResultSet result = util.getDataFromDB(query);
		if(result.next())
		phone1 = result.getString("phone");
		Assert.assertEquals(phone1, phone2);

		if (phone2.equals(phone1)) {
			System.out.println("phone number is matched!!");
		}
		util.closeDBConnection();
	}

	@Then("^Validate email$")
	public void validate_email() throws Throwable {

		String email = null;
		String email1 = locatorss.email.getAttribute("value");
		util.setUpDBConnection();
		String query = "Select yourEmail from profile_validation";
		ResultSet result = util.getDataFromDB(query);
		if(result.next())
		email = result.getString("yourEmail");
		Assert.assertEquals(email, email1);

		if (email1.equals(email)) {
			System.out.println("email is matched!!");
		}
		util.closeDBConnection();

	}

	@Then("^validate userName$")
	public void validate_userName() throws Throwable {

		String user = null;
		String user1 = locatorss.username.getAttribute("value");
		util.setUpDBConnection();
		String query = "Select userName from profile_validation";
		ResultSet result = util.getDataFromDB(query);
		if(result.next())
		user = result.getString("userName");
		Assert.assertEquals(user, user1);

		if (user1.equals(user)) {
			System.out.println("username is matched!!");
		}
		util.closeDBConnection();
	}

	/*
	 * public salma_stepDef() { this.locators = new HomePageLocators();
	 * this.locatorss=new RegisterPageLocators();
	 * PageFactory.initElements(SeleniumDriver.getDriver(), locators);
	 * PageFactory.initElements(SeleniumDriver.getDriver(), locatorss); }
	 */

}

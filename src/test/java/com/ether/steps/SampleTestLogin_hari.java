package com.ether.steps;

import java.sql.ResultSet;

import org.openqa.selenium.WebElement;



import com.codoid.products.fillo.Select;
import com.ether.base.SeleniumDriver;
import com.ether.base.TestUtil;
import com.ether.pages.actions.LoginAction;
import com.ether.pages.locators.HomePageLocators;
import com.ether.pages.locators.LoginPageLocators;
import com.ether.pages.locators.SavingPageLocators;


//import com.ether.pages.locators.loginPageLocators;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SampleTestLogin_hari
{
	TestUtil util = new TestUtil();
	LoginPageLocators locator = new LoginPageLocators();
	HomePageLocators Homelocator = new HomePageLocators();
	SavingPageLocators Savinglocator = new SavingPageLocators();

	@When("^Click the Deposit option and Select the Saving option from the drop down$")
	public void ClickDepositSelectSaving() throws Exception
	{
		Homelocator.deposit.click();
		Savinglocator.Savingoption.selectByVisibleText("Savings");
		Thread.sleep(30000);
//		WebElement  s = Savinglocator.Savingoption;
//		Select selectaccount = new Select(Savinglocator.Savingoption);
//        selectaccount.selectByVisibleText("Savings");
        
	}
	@When("^Click the Deposit option and Select the Primary option from the drop down$")
	public void click_the_Deposit_option_and_Select_the_Primary_option_from_the_drop_down() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
	}

	@Then("^Click Savings balance option$")
	public void click_Savings_balance_option() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new PendingException();
	}

	@Then("^Input the amount to be deposited and Click Deposit button$")
	public void DepositInputAndClick() throws Exception
	{
		String DepositAmount = null;
		util.setUpDBConnection();
		String query = "SELECT * FROM `TRANSFER_AMOUNT";
		ResultSet result1 = util.getDataFromDB(query);

		while (result1.next()) 
		{
			DepositAmount = result1.getString("amount");
			
	    }
		
				
        SeleniumDriver.inputValuesInElement(Savinglocator.SavingAmount, DepositAmount);
        Savinglocator.DepositClick.click();
        util.closeDBConnection();
	 }


	
	
		
		
	}


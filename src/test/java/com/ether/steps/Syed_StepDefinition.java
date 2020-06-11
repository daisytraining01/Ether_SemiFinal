package com.ether.steps;

import static org.testng.Assert.assertEquals;

import java.sql.ResultSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ether.base.SeleniumDriver;
import com.ether.base.TestUtil;
import com.ether.pages.locators.HomePageLocators;
import com.ether.pages.locators.LoginPageLocators;
import com.ether.pages.locators.Primarypagelocators;
import com.ether.pages.locators.TransferPageBetweenAcct;
import com.ether.pages.locators.TransferSomeone;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Syed_StepDefinition {
	LoginPageLocators loginPagelocators = new LoginPageLocators();
	HomePageLocators homepageLocators = new HomePageLocators();
	TransferPageBetweenAcct transferBetween = new TransferPageBetweenAcct();
	Primarypagelocators primarypagelocators = new Primarypagelocators();
	TransferSomeone transferSomeone = new TransferSomeone();
	TestUtil util = new TestUtil();

	@Given("^logged with the  \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\" in Browser$")
	public void logged_with_the_something_something_and_something_in_browser(String url, String username,
			String password) throws Throwable {
		SeleniumDriver.openPage(url);
		SeleniumDriver.inputValuesInElement(loginPagelocators.username, username);
		SeleniumDriver.inputValuesInElement(loginPagelocators.password, password);
		SeleniumDriver.clickOnTheElement(loginPagelocators.signIn);
	}

	@And("^A fund transer of rupees \"([^\"]*)\" has been done betweeb the same account$")
	public void a_fund_transer_of_rupees_something_has_been_done_betweeb_the_same_account(String amount)
			throws Throwable {
		// need to be added in POM
		/*
		 * while (result.next()) { userName = result.getString("Username"); password =
		 * result.getString("Password"); }
		 */
		SeleniumDriver.clickOnTheElement(
				SeleniumDriver.getDriver().findElement(By.xpath("//a[contains(text(),'Transfer')]")));
		SeleniumDriver.clickOnTheElement(homepageLocators.betweenAccounts);

		Select selectFromAccount = new Select(transferBetween.selFromAcct);
		selectFromAccount.selectByValue("Primary");// .selectByVisibleText("primary");

		Select selectToAccount = new Select(transferBetween.selToAcct);
		selectToAccount.selectByValue("Savings");// .selectByVisibleText("primary");

		SeleniumDriver.inputValuesInElement(transferBetween.amount, amount);
		SeleniumDriver.clickOnTheElement(transferBetween.transfer);

	}

	@When("^The user opens the primary statement page$")
	public void the_user_opens_the_primary_statement_page() throws Throwable {
		SeleniumDriver.clickOnTheElement(homepageLocators.accounts);
		SeleniumDriver.clickOnTheElement(homepageLocators.primaryAccount);

	}

	@Then("^User verifies that the last transaction \"([^\"]*)\"$")
	public void user_verifies_that_the_last_transaction_something(String amount) throws Throwable {
		SeleniumDriver.clickOnTheElement(SeleniumDriver.getDriver()
				.findElement(By.xpath("//th[@class='sorting_asc' and contains(.,'Post Date')]")));
		String[] amounts = primarypagelocators.Amount.getText().split("\\.");
		System.out.println("amount array is " + amounts);
		// System.out.println("amount is "+amounts[1]);
		// int amount1 =Integer.parseInt(amounts[1]);
		// int amount1 =Double.parseDouble(arg0)
		Double amount1 = Double
				.parseDouble(SeleniumDriver.getDriver().findElement(By.xpath("//tr[1]//td[5]")).getText());
		System.out.println("amount is "+amount1);
		Double expectedAmount = Double.parseDouble(amount);
		System.out.println("amount is "+expectedAmount);
		System.out.println(amount1 == expectedAmount);
		//assertEquals(true, (amount1 == expectedAmount));
	}

	@And("^The Statement is sorted in the descending order$")
	public void the_statement_is_sorted_in_the_descending_order() throws Throwable {
		/*
		 * int currentBalance = Integer.parseInt(
		 * primarypagelocators.AvailableBalance.getText().split("\\.")[0]); int
		 * oldBalance =
		 * Integer.parseInt(SeleniumDriver.getDriver().findElement(By.xpath(
		 * "//tbody/tr[2]/td[6]")).getText().split("\\.")[0]); int transeredAmount =
		 * Integer.parseInt( primarypagelocators.Amount.getText().split("\\.")[0]);
		 * assertEquals(true, (currentBalance==oldBalance-transeredAmount));
		 */
		System.out.println("verify account balance");
	}

	@And("^Logs out of the application$")
	public void logs_out_of_the_application() throws Throwable {
		SeleniumDriver.clickOnTheElement(homepageLocators.userDetails);
		SeleniumDriver.clickOnTheElement(homepageLocators.logout);
		Thread.sleep(3000);
	}

	@When("^The user opens the secondary statement page$")
	public void the_user_opens_the_secondary_statement_page() throws Throwable {
		SeleniumDriver.clickOnTheElement(homepageLocators.accounts);
		SeleniumDriver.clickOnTheElement(homepageLocators.savingsAccount);

	}

	@And("^A fund transer of rupees \"([^\"]*)\" has been done betweeb the recipient account$")
	public void a_fund_transer_of_rupees_something_has_been_done_betweeb_the_recipient_account(String amount)
			throws Throwable {
		// need to be added in POM
		String amount1 = null;
		util.setUpDBConnection();
		String query = "SELECT * FROM TRANSFER_AMOUNT order by amount LIMIT "+ amount +",1";
		ResultSet result = util.getDataFromDB(query);
		
		 while (result.next()) { 
			 	amount1 = result.getString("amount");
			 	break;
			  }
		 
		
		/*List amountList = (List) util.getDataFromDB(query);
		String amount1 = (String) amountList.get(0);*/
		SeleniumDriver.clickOnTheElement(
				SeleniumDriver.getDriver().findElement(By.xpath("//a[contains(text(),'Transfer')]")));
		SeleniumDriver.clickOnTheElement(homepageLocators.toSomeoneElseAccount);

		Select selectFromAccount = new Select(transferSomeone.selREcipient);
		selectFromAccount.selectByIndex(1);// .selectByVisibleText("primary");

		Select selectToAccount = new Select(transferSomeone.selTransferFrom);
		selectToAccount.selectByIndex(1);// .selectByVisibleText("primary");
		// SeleniumDriver.getDriver().findElement(By.xpath("//button[@class='btn btn-lg
		// btn-primary btn-block']")).sendKeys(amount);
		SeleniumDriver.inputValuesInElement(transferSomeone.amount, amount);
		Thread.sleep(3000);
		
		WebDriverWait wait = new WebDriverWait (SeleniumDriver.getDriver(), 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-lg btn-primary btn-block']"))).click();
		//Actions builder = new Actions(SeleniumDriver.getDriver());
        //builder.moveToElement(transferSomeone.transfer).click(transferSomeone.transfer);
        //builder.perform();
		//transferSomeone.transfer.sendKeys(Keys.ENTER);
		//JavascriptExecutor executor = (JavascriptExecutor)SeleniumDriver.getDriver();
		//executor.executeScript("arguments[0].click();", transferSomeone.transfer);
		//SeleniumDriver.clickOnTheElement(transferSomeone.transfer);
		Thread.sleep(3000);
		//SeleniumDriver.getDriver().findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block']")).click();
		;
	}

}

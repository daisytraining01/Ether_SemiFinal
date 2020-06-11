package com.ether.steps;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.ether.base.SeleniumDriver;
import com.ether.base.TestUtil;
import com.ether.pages.locators.HomePageLocators;
import com.ether.pages.locators.LoginPageLocators;
import com.ether.pages.locators.Primarypagelocators;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PrimaryAccount_Pagination_Search_Sort_Anjana {

	LoginPageLocators login_locator = new LoginPageLocators();
	HomePageLocators home_locator = new HomePageLocators();
	Primarypagelocators primary_locator = new Primarypagelocators();
	TestUtil util = new TestUtil();
	public String userName = null;
	public String password = null;

	@Given("^Launch the url \"([^\"]*)\"$")
	public void launch_the_url(String url) throws Throwable {
		SeleniumDriver.openPage(url);
	}

	@And("^login using the USERNAME and PASSWORD$")
	public void login_using_the_USERNAME_and_PASSWORD() throws Throwable {
		String query = "Select * from User_Details where ID=1";
		util.setUpDBConnection();
		ResultSet result = util.getDataFromDB(query);
		while (result.next()) {
			userName = result.getString("Username");
			password = result.getString("Password");
		}
		SeleniumDriver.inputValuesInElement(login_locator.username, userName);
		SeleniumDriver.inputValuesInElement(login_locator.password, password);
		SeleniumDriver.clickOnTheElement(login_locator.signIn);
		util.closeDBConnection();
	}

	@When("^navigate to the primary account page$")
	public void navigate_to_the_primary_account_page() throws Throwable {
		SeleniumDriver.clickOnTheElement(home_locator.accounts);
		SeleniumDriver.clickOnTheElement(home_locator.primaryAccount);
	}

	@And("^verify if the page has been navigated to the primary account$")
	public void verify_if_the_page_has_been_navigated_to_the_primary_account() throws Throwable {
		boolean assertion = false;
		if (primary_locator.PrimaryBalance.isDisplayed()) {
			System.out.println("The page was navigated to the primary account");
			assertion = true;
		} else {
			System.out.println("The page was not navigated to the primary account");
			assertion = false;
		}
		Assert.assertTrue(assertion);
	}

	@Then("^verify if pagination is working$")
	public void verify_if_pagination_is_working() throws Throwable {
		boolean assertion = false;
		SeleniumDriver.scrollUsingCoordinates(500, 500);
		Select select = new Select(
				SeleniumDriver.getDriver().findElement(By.xpath("//select[@name='example_length']")));
		select.selectByVisibleText("10");
		SeleniumDriver.scrollUsingCoordinates(500, 900);
		if (SeleniumDriver.getDriver().findElement(By.xpath("//div[@id='example_info']")).getText().contains("10")) {
			System.out
					.println(SeleniumDriver.getDriver().findElement(By.xpath(" //div[@id='example_info']")).getText());
			assertion = true;
		} else
			assertion = false;
		Assert.assertTrue(assertion);

		String records = SeleniumDriver.getDriver().findElement(By.xpath("//div[@id='example_info']")).getText();
		String rec[] = records.split(" ");
		int totalRec = Integer.parseInt(rec[5]);
		WebElement next = SeleniumDriver.getDriver().findElement(By.xpath("//a[text()='Next']"));
		WebElement previous = SeleniumDriver.getDriver().findElement(By.xpath("//a[text()='Previous']"));
		for (int i = 0; i <= (totalRec / 10) - 1; i++) {
			next = SeleniumDriver.getDriver().findElement(By.xpath("//a[text()='Next']"));
			/*
			 * if (i == 0) { Assert.assertTrue(!previous.isEnabled()); }
			 */
			String record1 = Integer.toString((i * 10) + 1);

			if (next.isEnabled()) {
				next = SeleniumDriver.getDriver().findElement(By.xpath("//a[text()='Next']"));

				if (SeleniumDriver.getDriver().findElement(By.xpath("//div[@id='example_info']")).getText()
						.contains(record1))
					System.out.println("FirstRec =" + record1);
				else
					Assert.assertTrue(false);
				next.click();
			}
			System.out.println("Navigated to page " + i);

		}
		util.captureScreenshot();
		previous = SeleniumDriver.getDriver().findElement(By.xpath("//a[text()='Previous']"));
		for (int i = 0; i <= (totalRec / 10) - 1; i++) {
			if (previous.isEnabled()) {
				previous.click();
				previous = SeleniumDriver.getDriver().findElement(By.xpath("//a[text()='Previous']"));
			}
		}
		util.captureScreenshot();

	}

	@When("^enter a search value \"([^\"]*)\"$")
	public void enter_a_search_value(String searchValue) throws Throwable {
		SeleniumDriver.inputValuesInElement(SeleniumDriver.getDriver().findElement(By.xpath("//input[@type='search']")),
				searchValue);

	}

	@Then("^verify if the expected record \"([^\"]*)\" is displayed$")
	public void verify_if_the_expected_record_is_displayed(String searchValue) throws Throwable {
		Thread.sleep(3000);
		List<WebElement> eles = SeleniumDriver.getDriver().findElements(By.xpath("//*[@id=\"example\"]/tbody//td"));
		for (int i = 0; i <= eles.size(); i++) {
			if (eles.get(i).getText().contains(searchValue)) {
				System.out.println("Search was successful");
				break;
			}
			if (i == eles.size())
				Assert.assertTrue(false);
		}
	}

	@Then("^verify the sort option$")
	public void verify_the_sort_option() throws Throwable {
		String amount;
		String min = "";
		String max = "";
		util.setUpDBConnection();
		String query1 = "Select * from PrimaryAccount_Amount";
		ResultSet result1 = util.getDataFromDB(query1);
		while (result1.next()) {
			min = result1.getString("MinimumAmt");
			max = result1.getString("MaxAmount");
		}
		util.closeDBConnection();
		for (int j = 0; j < 2; j++) {
			SeleniumDriver.getDriver().findElement(By.xpath("//th[contains(text(),'Amount')]")).click();
			String Postdate = SeleniumDriver.getDriver().findElement(By.xpath("//table//tr[1]//td[1]")).getText();

			System.out.println(Postdate);
			if (Postdate.contains(min))
				System.out.println("Records sorted in ascending order");
			else if (Postdate.contains(max))
				System.out.println("Records sorted in descending order");
			else
				Assert.assertFalse(true);

		}
	}

}

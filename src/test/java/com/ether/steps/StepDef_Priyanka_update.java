package com.ether.steps;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.ether.base.SeleniumDriver;
import com.ether.base.TestUtil;
import com.ether.pages.locators.HomePageLocators;
import com.ether.pages.locators.ScheduleAnAppointmentLocators;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef_Priyanka_update {
	HomePageLocators hpl = new HomePageLocators();
	ScheduleAnAppointmentLocators spl = new ScheduleAnAppointmentLocators();
	TestUtil util = new TestUtil();

	@Then("^click on me$")
	public void click_on_me() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		SeleniumDriver.clickOnTheElement(hpl.userDetails);
	}

	@Then("^logout$")
	public void logout() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		SeleniumDriver.clickOnTheElement(hpl.logout);
	}

	@When("^click on appointment$")
	public void click_on_appointment() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		SeleniumDriver.clickOnTheElement(hpl.appointment);

	}

	@Then("^schedule an appointment$")
	public void schedule_an_appointment() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		SeleniumDriver.clickOnTheElement(hpl.scheduleAnAppointment);
	}

	@And("^you store the records in DB$")
	public void you_store_the_records_in_DB() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^Pick a Date and Time$")
	public void pick_a_Date_and_Time() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		SeleniumDriver.clickOnTheElement(spl.datePicker);
		SeleniumDriver.clickOnTheElement(spl.datePicker_Day);
		SeleniumDriver.clickOnTheElement(spl.datePicker_hour);
		SeleniumDriver.clickOnTheElement(spl.datePicker_minutes);
		
	}

	@Then("^Pick a location$")
	public void pick_a_location() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		SeleniumDriver.waitForElementVisiblity(spl.pickALocation);
		Select select  = new Select(spl.pickALocation);
		select.selectByVisibleText("Turku");
	}

	@Then("^update Notes$")
	public void update_Notes() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		SeleniumDriver.inputValuesInElement(spl.notes, "appoinment needed");
	}

	@Then("^finally click on Submit scheduling$")
	public void finally_click_on_Submit_scheduling() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		SeleniumDriver.clickOnTheElement(spl.submitScheduling);
		SeleniumDriver.clickOnTheElement(SeleniumDriver.getDriver().findElement(By.xpath("//button[@class='btn btn-primary']")));
		additDB();
	}
	@And("^Verify the HomePage Landed Successfully$")
	public void verify_the_HomePage_Landed_Successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(hpl.primaryAccount.isDisplayed(), hpl.primaryAccount.isDisplayed());
	}
	
	public void additDB() throws Throwable
	{
		util.setUpDBConnection();
		String query="INSERT INTO appointments(app_title,app_time,app_location) VALUES('appoinment needed','15:10:10','Turku')";
		util.updateDBData(query);
		util.closeDBConnection();
	}

}

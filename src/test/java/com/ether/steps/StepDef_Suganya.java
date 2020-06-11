package com.ether.steps;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ether.base.TestUtil;
import com.ether.pages.locators.AddEditPage;
import com.ether.pages.locators.HomePageLocators;
import com.mysql.cj.protocol.Resultset;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.ether.base.SeleniumDriver;

public class StepDef_Suganya {
	TestUtil util = new TestUtil();
	HomePageLocators homePagelocator = new HomePageLocators();
	AddEditPage addEditPagelocator= new AddEditPage();
	


@When("^Home Page has Launched - Deposit Options are only available in Home Page$")
public void home_Page_has_Launched_Deposit_Options_are_only_available_in_Home_Page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	
	//String assertionText = homePagelocator.deposit.getText();	
	//Assert.assertEquals(assertionText, "Go to Deposit");
}


@And("^Click on Transfer Menu$")
	public void Click_on_Transfer_Menu() throws Throwable {
		SeleniumDriver.clickOnTheElement(SeleniumDriver.getDriver().findElement(By.xpath("//a[contains(text(),'Transfer')]")));
	}



@Then("^Click Add/Edit Recipient from Transfer Menu$")
public void click_Add_Edit_Recipient() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
//	homePagelocator.addRecipient.
	SeleniumDriver.clickOnTheElement(homePagelocator.addRecipient);

}



@Then("^Enter all the inputs$")
public void enter_all_the_inputs() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	String name = null;
	String email = null;
	String phone = null;
	String acc_num = null;
	String desc = null;
	
	util.setUpDBConnection();
		
	String query="Select * from Recipient_Table Where id =1";
	ResultSet result=util.getDataFromDB(query);
	if (result.next()) {
		name = result.getString("Name");
		email = result.getString("Email");
		phone = result.getString("phone");
		acc_num = result.getString("Account_Number");
		desc = result.getString("Description");
	}
	
	   int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 5;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
    
	SeleniumDriver.inputValuesInElement(addEditPagelocator.name,name+generatedString);
	SeleniumDriver.inputValuesInElement(addEditPagelocator.email,email);
	SeleniumDriver.inputValuesInElement(addEditPagelocator.phone,phone);
	SeleniumDriver.inputValuesInElement(addEditPagelocator.acctNum,acc_num);
	SeleniumDriver.inputValuesInElement(addEditPagelocator.description,desc);	
	
	String query1="insert into Recipient_Table(Name,Email,phone,Account_Number,Description) values('"+name+generatedString+"','"+email+"','"+phone+"','"+acc_num+"','"+desc+"')";
	util.updateDBData(query1);
	util.captureScreenshot();
}

@Then("^Click the First Entry$")
public void click_the_First_Entry() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
   // throw new PendingException();
	SeleniumDriver.clickOnTheElement(SeleniumDriver.getDriver().findElement(By.xpath("//table[@class='table table-bordered table-hover table-striped']/tbody/tr/td[1]/a")));
	SeleniumDriver.inputValuesInElement(addEditPagelocator.name, "");
	util.captureScreenshot();
}

@And("^Click on Add/Edit Recipient$")
public void click_on_Add_Edit_Recipient() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	SeleniumDriver.clickOnTheElement(addEditPagelocator.addEditButton);	
}

@Then("^Verify the added Recipient$")
public void verify_the_added_Recipient() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	
	List<WebElement> tableElements = SeleniumDriver.getDriver().findElements(By.xpath("//table[@class=\"table table-bordered table-hover table-striped\"]/tbody/tr/td[1]"));
	util.captureScreenshot();
	for (WebElement tdVal:tableElements) {
		if(tdVal.equals("test"))
		Assert.assertEquals(tdVal, "test");
	}
}
@Then("^Verify the Edited Recipient$")
public void verify_the_Edited_Recipient() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	
	List<WebElement> tableElements = SeleniumDriver.getDriver().findElements(By.xpath("//table[@class=\"table table-bordered table-hover table-striped\"]/tbody/tr/td[1]"));
	util.captureScreenshot();
	for (WebElement tdVal:tableElements) {
		if(tdVal.equals("test"))
		Assert.assertEquals(tdVal, "test");
	}
}
}

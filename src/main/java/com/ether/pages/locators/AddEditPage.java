package com.ether.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ether.base.SeleniumDriver;

public class AddEditPage {

	@FindBy(how = How.XPATH, using = " //input[@id='recipientName']")
	public WebElement name;

	@FindBy(how = How.XPATH, using = "//input[@id='recipientEmail']")
	public WebElement email;

	@FindBy(how = How.XPATH, using = "//input[@id='recipientPhone']")
	public WebElement phone;

	@FindBy(how = How.XPATH, using = " //input[@id='recipientAccountNumber']")
	public WebElement acctNum;

	@FindBy(how = How.XPATH, using = "//textarea[@id='recipientDescription']")
	public WebElement description;

	@FindBy(how = How.XPATH, using = " //button[@class='btn btn-primary']")
	public WebElement addEditButton;

	public AddEditPage() {

		PageFactory.initElements(SeleniumDriver.getDriver(), this);
	}
}

package com.ether.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ether.base.SeleniumDriver;

public class TransferSomeone {

	@FindBy(how = How.XPATH, using = "//select[@id='recipientName']")
	public WebElement selREcipient;

	@FindBy(how = How.XPATH, using = "//select[@id='accountType']")
	public WebElement selTransferFrom;

	@FindBy(how = How.XPATH, using = "//input[@id='amount']]")
	public WebElement amount;

	@FindBy(how = How.XPATH, using = " //button[@class='btn btn-lg btn-primary btn-block']")
	public WebElement transfer;

	public TransferSomeone() {

		PageFactory.initElements(SeleniumDriver.getDriver(), this);
	}

}

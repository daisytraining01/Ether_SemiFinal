package com.ether.pages.locators;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ether.base.SeleniumDriver;

public class TransferPageBetweenAcct {
	
	
	@FindBy(how=How.XPATH,using="//select[@id='transferFrom']")
	public WebElement selFromAcct;
	
	@FindBy(how=How.XPATH,using="//select[@id='transferTo']")
	public WebElement selToAcct;
	
	@FindBy(how=How.XPATH,using="//input[@id='amount']")
	public WebElement amount;
	
	@FindBy(how=How.XPATH,using="//button[@class='btn btn-lg btn-primary btn-block']")
	public WebElement transfer;
	
	public TransferPageBetweenAcct() {
		PageFactory.initElements(SeleniumDriver.getDriver(), this);
	}

}

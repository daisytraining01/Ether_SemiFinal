package com.ether.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ether.base.SeleniumDriver;

public class SavingPageLocators {

	@FindBy(how = How.XPATH, using = "//i[@class='fa fa-usd']")
	public WebElement SavingAccBalance;
	// td should be checked
	@FindBy(how = How.XPATH, using = "//table [@class=\"table table-bordered table-hover table-striped\"]/tbody/tr")
	public WebElement LastSavingTransaction;
	

@FindBy(how = How.XPATH, using = "//*[@id='accountType']")
public Select Savingoption;
@FindBy(how = How.XPATH, using = "//*[@id=\"accountType\"]/option[2]")
public WebElement PrimaryAcc;
@FindBy(how = How.XPATH, using = "//*[@id=\"accountType\"]")
public WebElement SavingAcc;
@FindBy(how = How.XPATH, using = "//*[@id=\"accountType\"]/option[3]")
public WebElement SavingAmount;
@FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div/form/button")
public WebElement DepositClick;
@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div[1]/div[2]/a/div/span[1]")
public WebElement SavingsBalanceClick;
@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div[2]/div/div[1]/div/div[2]/h1/span")
public WebElement SavingsBalanceDisplay;


	public SavingPageLocators() {

		PageFactory.initElements(SeleniumDriver.getDriver(), this);
	}

}

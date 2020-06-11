package com.ether.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ether.base.SeleniumDriver;

public class Primarypagelocators {
	@FindBy(how = How.XPATH, using = "//a[@href='#'][contains(text(),'Accounts')]")
	public WebElement Accounts;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Primary')]")
	public WebElement Primary1;

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Primary Balance: ')]")
	public WebElement PrimaryBalance;

	@FindBy(how = How.XPATH, using = "// i[@class='fa fa-usd']")
	public WebElement PrimaryBalanceAmount;

	@FindBy(how = How.XPATH, using = "//*select[@name='example_length']")
	public WebElement Show;

	@FindBy(how = How.XPATH, using = "//*[@id=\"example\"]/thead/tr/th[1]")
	public WebElement PostDate;

	@FindBy(how = How.XPATH, using = "//*[@id=\"example\"]/thead/tr/th[2]")
	public WebElement Description;

	@FindBy(how = How.XPATH, using = "//*[@id=\"example\"]/thead/tr/th[3")
	public WebElement Type;

	@FindBy(how = How.XPATH, using = "//*[@id=\"example\"]/thead/tr/th[4]")
	public WebElement Status;

	@FindBy(how = How.XPATH, using = "//*[@id=\"example\"]/thead/tr/th[5]")
	public WebElement Amount;

	@FindBy(how = How.XPATH, using = "//*[@id=\"example\"]/thead/tr/th[6]")
	public WebElement AvailableBalance;

	@FindBy(how = How.XPATH, using = "//*[@id=\"example\"]/tbody/tr[1]/td[1]")
	public WebElement tabledesc1;

	@FindBy(how = How.XPATH, using = "//*[@id=\"example\"]/tbody/tr[1]/td[2]")
	public WebElement tabledesc2;

	@FindBy(how = How.XPATH, using = "//*[@id=\"example\"]/tbody/tr[1]/td[3]")
	public WebElement tabledesc3;

	@FindBy(how = How.XPATH, using = "//*[@id=\"example\"]/tbody/tr[1]/td[4]")
	public WebElement tabledesc4;

	@FindBy(how = How.XPATH, using = "//*[@id=\"example\"]/tbody/tr[1]/td[5]")
	public WebElement tabledesc5;

	@FindBy(how = How.XPATH, using = "//*[@id=\"example\"]/tbody/tr[1]/td[6]")
	public WebElement tabledesc6;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Previous')]")
	public WebElement previous;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Next')]")
	public WebElement next;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Savings')]")
	public WebElement Savings;

	public Primarypagelocators() {

		PageFactory.initElements(SeleniumDriver.getDriver(), this);
	}
}
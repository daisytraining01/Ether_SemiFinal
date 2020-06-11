package com.ether.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ether.base.SeleniumDriver;

public class HomePageLocators {
	@FindBy(how = How.XPATH, using = "//a[@class='navbar-brand page-scroll']")
	public WebElement homeButton;

	@FindBy(how = How.XPATH, using = "//a[@class='dropdown-toggle'][contains(text(),'Accounts')]")
	public WebElement accounts;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Primary')]")
	public WebElement primaryAccount;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Savings')]")
	public WebElement savingsAccount;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Between Accounts')]")
	public WebElement betweenAccounts;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'To Someone Else')]")
	public WebElement toSomeoneElseAccount;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Add')]")
	public WebElement addRecipient;

	@FindBy(how = How.XPATH, using = "//a[@class='dropdown-toggle'][contains(text(),'Appointment')]")
	public WebElement appointment;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Schedule an Appointment')]")
	public WebElement scheduleAnAppointment;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Me')]")
	public WebElement userDetails;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Profile')]")
	public WebElement userProfile;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Logout')]")
	public WebElement logout;

	// div[@class='panel
	// panel-info']//span[@class='pull-left'][contains(text(),'View Details')]
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Go to Deposit')]")
	public WebElement deposit;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Go to Withdrawal')]")
	public WebElement withdrawl;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/h1[1]/span[1]")
	public WebElement primaryAccountBalance;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/h1[1]/span[1]")
	public WebElement savingsAccountBalance;

	public HomePageLocators() {

		PageFactory.initElements(SeleniumDriver.getDriver(), this);
	}
}

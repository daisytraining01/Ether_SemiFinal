package com.ether.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ether.base.SeleniumDriver;

public class RegisterPageLocators {
	@FindBy(how = How.XPATH, using = "//input[@name='firstName']")
	public WebElement firstName;

	@FindBy(how = How.XPATH, using = "//input[@id='lastName']")
	public WebElement lastName;

	@FindBy(how = How.XPATH, using = "//input[@id='phone']")
	public WebElement phone;

	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	public WebElement email;

	@FindBy(how = How.XPATH, using = "//input[@id='username']")
	public WebElement username;

	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	public WebElement password;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary btn-lg btn-block login-button']")
	public WebElement signUp;

	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-info btn-lg btn-block login-button']")
	public WebElement cancelSignUp;

	public RegisterPageLocators() {

		PageFactory.initElements(SeleniumDriver.getDriver(), this);
	}
}

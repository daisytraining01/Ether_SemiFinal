package com.ether.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ether.base.SeleniumDriver;

public class LoginPageLocators {
	@FindBy(how = How.XPATH, using = "//input[@id='username']")
	public WebElement username;

	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	public WebElement password;

	@FindBy(how = How.XPATH, using = "//input[@id='remember-me']")
	public WebElement rememberMeCheckBox;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-lg btn-primary btn-block']")
	public WebElement signIn;

	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-info btn-lg btn-block login-button']")
	public WebElement signUp;

	public LoginPageLocators() {

		PageFactory.initElements(SeleniumDriver.getDriver(), this);
	}
}

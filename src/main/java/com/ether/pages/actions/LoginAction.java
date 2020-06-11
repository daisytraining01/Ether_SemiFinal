package com.ether.pages.actions;

import java.io.File;
import java.sql.ResultSet;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ether.base.SeleniumDriver;
import com.ether.base.TestUtil;
import com.ether.pages.locators.LoginPageLocators;

public class LoginAction extends TestUtil {
	LoginPageLocators loginPageLocator = null;

	public LoginAction() {
		this.loginPageLocator = new LoginPageLocators();
		PageFactory.initElements(SeleniumDriver.getDriver(), loginPageLocator);
	}

	public void fetch_UserDetails() throws Exception {
		LoginAction loginAction = new LoginAction();
		String userName = null;
		String password = null;
		setUpDBConnection();
		String query = "Select * from User_Details";
		ResultSet result = getDataFromDB(query);

		while (result.next()) {
			userName = result.getString("Username");
			password = result.getString("Password");
		}
		loginAction.loginPageLocator.username.sendKeys(userName);
		loginAction.loginPageLocator.password.sendKeys(password);
		loginAction.loginPageLocator.signIn.click();
		closeDBConnection();

	}
	
	
}

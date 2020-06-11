package com.ether.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ether.base.SeleniumDriver;

public class ScheduleAnAppointmentLocators {
	
	@FindBy(how = How.XPATH, using = "//*[@id='appointmentForm']/div[1]/div")
	public WebElement pickADateAndTime;
	
	
	@FindBy(xpath="//span[@class='input-group-addon'][2]")
	public WebElement datePicker;
	
	@FindBy(xpath="//div[contains(@class,'datetimepicker-days')]/table//tr//td[text()='15']")
	public WebElement datePicker_Day;
	
	@FindBy(xpath="//div[contains(@class,'datetimepicker-hours')]/table//tr//span[text()='10:00']")
	public WebElement datePicker_hour;
	
	@FindBy(xpath="//div[contains(@class,'datetimepicker-minutes')]/table//tr//span[text()='10:00']")
	public WebElement datePicker_minutes;
	
	//@FindBy(how = How.XPATH, using = "//span[text() = ‘15.00’]")
	//public WebElement 
	
	@FindBy(how = How.XPATH, using = "//*[@id='location']" )
	public WebElement pickALocation;
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='description']")
	public WebElement  notes;
	
	@FindBy(how = How.XPATH, using = "//a[@id='submitAppointment']")
	public WebElement submitScheduling;
	
	
	
	
	
	
	
	
	
	public ScheduleAnAppointmentLocators() {

		PageFactory.initElements(SeleniumDriver.getDriver(), this);
}
}
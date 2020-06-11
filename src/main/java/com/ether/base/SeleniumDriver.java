package com.ether.base;



import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumDriver {

    private static SeleniumDriver seleniumDriver;
 
    //initialize webdriver
    private static WebDriver driver;
    
    //initialize timeouts
    private static WebDriverWait waitDriver;
    public final static int TIMEOUT = 30;
    public final static int PAGE_LOAD_TIMEOUT = 50;

    private  SeleniumDriver() {
    	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\resources\\driver\\chromedriver.exe");
    	driver = new ChromeDriver();
        driver.manage().window().maximize();

        waitDriver = new WebDriverWait(driver, TIMEOUT);
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        String window=driver.getWindowHandle();
        System.out.println("Window ->"+window);
       
    }

    public static void openPage(String url) {
    	System.out.println(url);
    	System.out.println(driver);
        driver.get(url);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setUpDriver() {
       if (seleniumDriver == null)
            seleniumDriver = new SeleniumDriver();
      
    }

    public static void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
        seleniumDriver = null;
    }
    public static void waitForPageToLoad()
    {
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void inputValuesInElement(WebElement element, String value) {
		try {
			element.clear();
			element.sendKeys(value);
		} catch (NoSuchElementException e) {
			e.getCause();
			e.printStackTrace();
			System.out.println(value + " couldnt be entered");
		}

	}
	public static void clickOnTheElement(WebElement element) {

		try {

			element.click();

		} catch (Exception e) {

			System.out.println("Couldnt be clicked");
		}

	}
	public static void waitForElementVisiblity(WebElement element) throws Exception {
		try {
			WebDriverWait wb = new WebDriverWait(SeleniumDriver.getDriver(), 30);
			wb.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Element couldnt be found");
		}
	}
	public static String getttingTextFromElement(WebElement element) {

		String s = element.getText();

		return s;

	}
	public static void mouseOver(WebElement element) {

		try {

			Actions ac = new Actions(SeleniumDriver.getDriver());
			ac.moveToElement(element);

		} catch (Exception e) {

			System.out.println("Not moved to element");
		}
	}
	
	public static void switchToFrame(WebElement element) {
		try {

			SeleniumDriver.getDriver().switchTo().frame(element);

		} catch (Exception e) {

			System.out.println("Frame couldnt be detected");
		}
		

	}
	public static void switchToDefaultContent() {
		try {

			SeleniumDriver.getDriver().switchTo().defaultContent();

		} catch (Exception e) {

			System.out.println("Couldnt switch to default content");
		}
		

	}
	public static void rightClickOnElement(WebElement element) {
		try {
			Actions ac = new Actions(SeleniumDriver.getDriver());
			ac.contextClick(element);
		} catch (Exception e) {
			System.out.println("Element couldnt be right clicked");
		}

	}
	public static void scrollUsingCoordinates(int width, int height) throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) SeleniumDriver.getDriver();
			js.executeScript("window.scrollBy(" + width + "," + height + ")");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}
	public static File takeScreenShot(String filename) throws Throwable {
		File des=null;
		try {
			TakesScreenshot ts = (TakesScreenshot) SeleniumDriver.getDriver();
			File temp = ts.getScreenshotAs(OutputType.FILE);
		 des = new File(
					"Screenshots/" + filename + ".png");
			FileUtils.copyFile(temp, des);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return des;

	}
}

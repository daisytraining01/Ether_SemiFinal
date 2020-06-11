package com.ether.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class TestUtil {

	public static String screenshotPath;
	public static String screenshotName;
	public static Fillo fillo;
	public static java.sql.Connection dBconnection;
	public static Recordset recorset;
	public static String JDBC_DRIVER = null;
	public static String DB_URL = "";
	public static Statement statement = null;
	public static ResultSet results;

	public static void captureScreenshot() throws IOException {

		File scrFile = ((TakesScreenshot) SeleniumDriver.getDriver()).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\target\\" + screenshotName));

	}

	public static String readFromFile_Fillo(int rowNum, String field) throws Exception {
		String value = "";
		try {

			fillo = new Fillo();
			Connection connection = fillo.getConnection(System.getProperty("user.dir") + "\\TestData.xlsx");
			String strSelectQuery = "Select * from sheet1 where RowNum=" + rowNum;
			Recordset recordset = connection.executeQuery(strSelectQuery);
			while (recordset.next()) {
				value = recordset.getField(field);
			}
			connection.close();
			recordset.close();
		} catch (Exception e) {
			throw new Exception("Problem in getting data from Excel");
		}

		return value;
	}

	public static void writeToFile_Fillo(int rowNum, String field, String value) throws FilloException {
		fillo = new Fillo();
		Connection connection = fillo.getConnection(System.getProperty("user.dir") + "\\TestData.xlsx");
		String query = "UPDATE sheet1 Set " + field + "=" + value + " where RowNum=" + rowNum;
		System.out.println(query);
		connection.executeUpdate(query);
		connection.close();

	}

	public static void setUpDBConnection() throws Exception {
		
		FileInputStream finputstream = new FileInputStream(System.getProperty("user.dir") + "/config.properties");
		Properties prop = new Properties();
		prop.load(finputstream);
		JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		Class.forName(JDBC_DRIVER);
		String DB_URL = "jdbc:mysql://elastic.rapidtestpro.com:2777/Ether";
		
		dBconnection = DriverManager.getConnection(DB_URL, prop.getProperty("DB_UserName"),
				prop.getProperty("DB_Password"));

	}

	public static void closeDBConnection() throws SQLException {
		dBconnection.close();
	}

	public static void updateDBData(String query) throws Exception {
		statement = dBconnection.createStatement();
		{
			statement.executeUpdate(query);
		}
	}

	public static ResultSet getDataFromDB(String query) throws SQLException {
		return dBconnection.createStatement().executeQuery(query);
	}

}

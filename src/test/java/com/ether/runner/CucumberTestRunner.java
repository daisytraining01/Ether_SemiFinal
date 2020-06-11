package com.ether.runner;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import com.cucumber.listener.ExtentCucumberFormatter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
@CucumberOptions(
		plugin = {"json:target/positive/cucumber.json", "pretty", "html:target/positive/cucumber.html","com.cucumber.listener.ExtentCucumberFormatter"},
        features = {"src/test/java/Feature_Files/"},
        glue = "com.ether.steps",
        dryRun=false,
     //  tags = {"@karthik,@Priyanka,@Sugan_Samp,@Anjana,@Salma,@Ajay,@Vineeth,@Syed"}	
    //tags = {"@karthik"}
		tags = {"@Salma"}
        )

public class CucumberTestRunner extends AbstractTestNGCucumberTests {
	@BeforeClass
    public static void setup() {
        // Initiates the extent report and generates the output in the output/Run_<unique timestamp>/report.html file by default.
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_hhmmss");
		Date curDate = new Date();
		String strDate = sdf.format(curDate);
		String fileName = System.getProperty("user.dir")+"\\target\\Extent_Reports\\" + strDate+".html";
		File newFile = new File(fileName);
		ExtentCucumberFormatter.initiateExtentCucumberFormatter(newFile,false);
        // Loads the extent config xml to customize on the report.
        ExtentCucumberFormatter.loadConfig(new File("src/test/extent-config.xml"));

        // User can add the system information as follows
        ExtentCucumberFormatter.addSystemInfo("Browser Name", "chrome");
        ExtentCucumberFormatter.addSystemInfo("Browser version", "v81.0.4044.138");
        ExtentCucumberFormatter.addSystemInfo("Selenium version", "v3.142");

        // Also you can add system information using a hash map
        Map<String, String> systemInfo = new HashMap<String, String>();
        systemInfo.put("Cucumber version", "v1.2.4");
        systemInfo.put("Extent Cucumber Reporter version", "v1.1.0");
        ExtentCucumberFormatter.addSystemInfo(systemInfo);
    }

}

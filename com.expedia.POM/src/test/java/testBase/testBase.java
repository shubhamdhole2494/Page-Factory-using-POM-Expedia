package testBase;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import excelReader.ExcelReader;
import excelReader.Excel_Reader;

public class testBase {
	
	public WebDriver driver;
	public static final Logger log = Logger.getLogger(testBase.class.getName());
	String baseurl = "https://www.expedia.co.in";
	String browsers = "firefox";
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"/src/main/java/data/TestData.xlsx");
	
	public void init() {
		selectBrowser(browsers);
		getURL(baseurl);
		String log4jConfig = "log4j.properties";
		PropertyConfigurator.configure(log4jConfig);
	}
	
	public void selectBrowser(String browser) {
		if(browser.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
			log.info("Creating Object for " +browser);
		}
		else if (browser.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			log.info("Creating Object for " +browser);
		}
	}
	
	public void getURL(String url) {
		
		log.info("Navigating to URL" +url);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	
	
	//com.expedia.POM/src/main/java/data/TestData.xlsx
	public String[][] getData(String excelName, String sheetName){
		String path = System.getProperty("user.dir") + "/src/main/java/data/TestData.xlsx" +excelName ;
		Excel_Reader excel = new Excel_Reader(path);
		String [][] data = excel.getDataFromSheet(sheetName, excelName);
		return data;
	}

}

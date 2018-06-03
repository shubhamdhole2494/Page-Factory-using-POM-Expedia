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
	String browsers = "chrome";
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "/src/main/java/data/TestData.xlsx");

	public void init() {

		selectBrowser(browsers);
		getURL(baseurl);
		String log4jConfig = "log4j.properties";
		PropertyConfigurator.configure(log4jConfig);
	}

	public void selectBrowser(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
			log.info("Creating Object for " + browser);
		} else if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			log.info("Creating Object for " + browser);
		}
	}

	public void getURL(String url) {

		log.info("Navigating to URL" + url);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	// com.expedia.POM/src/main/java/data/TestData.xlsx
	public String[][] getData(String excelName, String sheetName) {
		String path = System.getProperty("user.dir") + "/src/main/java/data/TestData.xlsx" + excelName;
		Excel_Reader excel = new Excel_Reader(path);
		String[][] data = excel.getDataFromSheet(sheetName, excelName);
		return data;
	}

	// check if testcase in executable or not
	public static boolean isExecutable(String tcid) {

		for (int rownum = 2; rownum <= excel.getRowCount("testSuite"); rownum++) {
			if (excel.getCellData("testSuite", "TCID", rownum).equals(tcid)) {
				if (excel.getCellData("testSuite", "Runmode", rownum).equalsIgnoreCase("y")) {
					return true;
				} else {
					return false;
				}

			}
		}
		return false;

	}

	public static Object[][] getData(String sheetName) {

		int rows = excel.getRowCount(sheetName); // Get Row Count
		int cols = excel.getColumnCount(sheetName); // Get Col Count
		Object data[][] = new Object[rows - 1][cols]; // -1

		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2

			for (int colNum = 0; colNum < cols; colNum++) {

				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum); // -2
			}
		}

		return data;

	}

}

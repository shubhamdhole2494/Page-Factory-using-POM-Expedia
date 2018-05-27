package testBase;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testBase {
	
	public WebDriver driver;
	public static final Logger log = Logger.getLogger(testBase.class.getName());
	String baseurl = "https://www.expedia.co.in";
	String browsers = "chrome";
	
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

}

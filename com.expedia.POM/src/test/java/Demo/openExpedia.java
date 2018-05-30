package Demo;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import loginPage.singInPageObject;
import testBase.testBase;


public class openExpedia extends testBase {
	
	//WebDriver driver;
	public static final Logger log = Logger.getLogger(openExpedia.class.getName());

	singInPageObject signIn;
	//public static String baseurl = "https://www.expedia.co.in";
	@BeforeTest
	public void guestLogin() {
		
		
		init();
		//driver = new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver","D:\\Shubham\\Software\\Selenium_Jars\\chromedriver\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		//driver = new ChromeDriver();
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.get(baseurl);
		
	}
	
	@Test
	public void invalidLogin() throws InterruptedException {
		
		signIn = new singInPageObject(driver);
		signIn.loginToApplication("test@gmail.com", "123456");
		
	}
	@AfterClass
	public void endTest() {
		driver.close();
	}
	
	
	
	

}

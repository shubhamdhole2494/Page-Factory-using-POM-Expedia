package objectPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class singInPageObject {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@id='signin-loginid']")
	WebElement loginEmailAddress;
	
	@FindBy(xpath="//input[@id='signin-password']")
	WebElement loginPassword;
	
	@FindBy(xpath="//button[@id='submitButton']")
	WebElement signInButton;

	@FindBy(xpath="//button[@id='header-account-menu']")
	WebElement accountLink;
	
	@FindBy(xpath="//a[@id='account-signin']")
	WebElement signLink;
	
	public singInPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginToApplication(String username, String password) throws InterruptedException{
		
		accountLink.click();
		Thread.sleep(5000);
		signLink.click();
		loginEmailAddress.sendKeys(username);
		loginPassword.sendKeys(password);
		signInButton.click();
	}
}

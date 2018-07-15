package loginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class hotelsPageObject {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[@id='primary-header-hotel']")
	WebElement HotelsTabLink;
	
	@FindBy(xpath="//button[@id='tab-hotel-tab-hlp']")
	WebElement HotelsOnly;
	
	@FindBy(xpath="//input[@id='hotel-destination-hlp']")
	WebElement GoingToDestination;
	
	@FindBy(xpath="//input[@id='hotel-checkin-hlp']")
	WebElement CheckInDate;
	
	@FindBy(xpath="//input[@id='hotel-checkout-hlp']")
	WebElement CheckOutDate;
	
	@FindBy(xpath="//select[@id='hotel-rooms-hlp']")
	WebElement Rooms;
	
	@FindBy(xpath="//select[@id='hotel-1-adults-hlp']")
	WebElement Adults;
	
	@FindBy(xpath="//select[@id='hotel-1-children-hlp']")
	WebElement Children;
	
	@FindBy(xpath="//input[@id='hotel-add-flight-checkbox-hlp']")
	WebElement AddFlight;
	
	@FindBy(xpath="//form[@id='gcw-hotel-form-hlp']//div[@class='cols-nested ab25184-submit']//label[@class='col search-btn-col']//button[@type='submit']")
	WebElement SearchButton;
	
	public hotelsPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void demoTest() {
		
		HotelsTabLink.click();
	}
	
	public void clickOnRooms() {
		Rooms.click();
	}
	
	public void selectDropdownRooms(String roomNo) {
		
		Select Drop = new Select(Rooms);
		Drop.selectByValue(roomNo);	
	}
	
	/*public void selectDropdownAdult(String adultNo) {
		
		Select Drop = new Select(Adults);
		Drop.selectByValue(adultNo);
		
	}*/
	
	/*public void clickOnSearchButton() {
		
		SearchButton.click();
		
	}*/
	



}

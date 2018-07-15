package uiAction;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import loginPage.hotelsPageObject;
import testBase.testBase;

public class HotelsTabActions extends testBase {

	hotelsPageObject hotelspage;
	@Test(dataProvider="getData")
	public void test(String roomNo) throws Exception {
		
		init();
		hotelspage = new hotelsPageObject(driver);
		hotelspage.demoTest();
		
		hotelspage.selectDropdownRooms(roomNo);
		
		//hotelspage.selectDropdownAdult("1");
		//hotelspage.clickOnSearchButton();
	}
	
	@DataProvider
	public Object[][] getData(){
		
		return testBase.getData("HotelsTabActions");
	}
}

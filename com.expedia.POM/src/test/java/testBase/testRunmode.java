package testBase;


public class testRunmode extends testBase {
	
	//public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"/src/main/java/data/TestData.xlsx");

	public static boolean isExecutable() {
	
		for(int rownum=2;rownum<=excel.getRowCount("testSuite"); rownum++) {
			if(excel.getCellData("testSuite","TCID", rownum).equals("openExpedia")) {
				if(excel.getCellData("testSuite", "Runmode", rownum).equalsIgnoreCase("y")) {
					return true;
				}
				else {
					return false;
				}
				
			}
		}
		return false;
			
	}
	
	public static void getTestcase() {
		for(int rownum=2;rownum<=excel.getRowCount("testSuite"); rownum++) {
			
		}
	}
	

	public static void main(String[] args) {
		
		System.out.println(isExecutable());
	}

}

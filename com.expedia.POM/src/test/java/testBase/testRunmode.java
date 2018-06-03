package testBase;

public class testRunmode extends testBase {
	
	public static boolean isExecutable() {
	
		for(int rownum=2;rownum<=excel.getRowCount("testSuite"); rownum++) {
			if(excel.getCellData("testSuite","TCID", rownum).equals("openExpedia")) {
				if(excel.getCellData("testSuite", "Runmoed", rownum).equals("Y")) {
					return true;
				}
				else {
					return false;
				}
				
			}
		}
		return false;
			
	}
	

	public static void main(String[] args) {
		
		isExecutable();
	}

}

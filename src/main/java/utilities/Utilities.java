package utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import base.Page;

public class Utilities extends Page {

	public static String screenshotName;

	public static void captureScreenshot() throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));

	}
//	-------------------
//	 Note: KPI1
//	 Data Provider with parameters>> Need to define all colomn headers as parameters in test case. for more than 4 or 5 columns its difficult
//	 Solution: Use Hashtable and create each data set as a table with header values as key.
//	 Implemented in the below data provider code block
//	 -------------------

//	@DataProvider(name="dp")
//	public Object[][] getData(Method m) {
//		
//		//SheetName and Test case name are set the same
//		String sheetName = m.getName();
//		
//		//String sheetName = "AddCustomerTest";
//		log.debug("SheetName is  :  " + excel.getWorkSheetName(0));
//		int rows = excel.getRowCount(sheetName);
//		log.debug(rows);
//		//System.out.println(rows);
//		int cols = excel.getColumnCount(sheetName);
//		//System.out.println(cols);
//		log.debug(cols);
//		Object[][] data = new Object[rows - 1][cols];
//
//		for (int rowNum = 2; rowNum <= rows; rowNum++) {
//
//			for (int colNum = 0; colNum < cols; colNum++) {
//
//				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
//
//			}
//		}
//		return data;

	@DataProvider(name="dp")
	public Object[][] getData(Method m) {

		// SheetName and Test case name are set the same
		String sheetName = m.getName();

		// String sheetName = "AddCustomerTest";
		log.debug("SheetName is  :  " + excel.getWorkSheetName(0));
		int rows = excel.getRowCount(sheetName);
		log.debug(rows);
		// System.out.println(rows);
		int cols = excel.getColumnCount(sheetName);
		// System.out.println(cols);
		log.debug(cols);
		
		
		Object[][] data = new Object[rows - 1][1];
		
		Hashtable<String,String> table= null;	 
		

		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			
			table=new Hashtable<String, String>();
			for (int colNum = 0; colNum < cols; colNum++) {
				
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				//data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
				data[rowNum - 2][0] = table;

			}
		}
		return data;
	}

	public static boolean isTestRunnable(String testName) {

		String sheetName = "test_suite";
		int rows = excel.getRowCount(sheetName);

		for (int rNum = 2; rNum <= rows; rNum++) {

			String testCase = excel.getCellData(sheetName, "TCID", rNum);
			if (testCase.equalsIgnoreCase(testName)) {
				String runMode = excel.getCellData(sheetName, "Runmode", rNum);
				if (runMode.equalsIgnoreCase("Y")) {
					return true;

				} else {
					return false;

				}
			}
		}
		return false;
	}
}

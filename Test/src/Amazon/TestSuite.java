package Amazon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;

public class TestSuite {
	public static void main(String[] args) throws Exception {

		// AutomationScripts.launchTheAmazonApplication();
		// AutomationScripts.verifyDropDownOptionAfterIphoneIsTypedInSearch();
		// AutomationScripts.clickOnSearchButtonAfterIphoneIsEntered();
		// AutomationScripts.verifyShowResultsForCellPhonesAndAccessories();
		// AutomationScripts.verifyShowResultsForColumnOnTheLeftComputersAndAccessories();
		// AutomationScripts.verifyShowResultsForColumnOnTheLeftElectronics();
		// AutomationScripts.verifyShowResultsForColumnOnTheLeftRefineby();
		// AutomationScripts.checkMainTab();
		// AutomationScripts.validatedepartmentDropdownList();
		// AutomationScripts.validateyourAccountDropdownList();
		//AutomationScripts.validateTryPrimeDropdownList();
		// AutomationScripts.validateListsDropdownList();

		String automationScript;
		String runNorun;
		File xLFile = new File("C:/Users/glory/Desktop/Test/Amazon_Testcases.xls");
		HSSFWorkbook wb = null;
		try {
			FileInputStream xlDoc = new FileInputStream(xLFile);
			wb = new HSSFWorkbook(xlDoc);
			HSSFSheet sheet1 = wb.getSheet("Sheet1");
			for (int i = 1; i < sheet1.getPhysicalNumberOfRows(); i++) {
				runNorun = sheet1.getRow(i).getCell(1).getStringCellValue();
				if (runNorun.equalsIgnoreCase("Y")) {
					automationScript = sheet1.getRow(i).getCell(2).getStringCellValue();
					boolean testpassed = AutomationScripts.runTest(automationScript);
					HSSFCell resultCell = sheet1.getRow(i).getCell(3);
					HSSFCellStyle cellStyle = wb.createCellStyle();
					if (testpassed) {
						resultCell.setCellValue("Pass");
						cellStyle.setFillForegroundColor(new HSSFColor.GREEN().getIndex());

					} else {

						resultCell.setCellValue("Fail");
						cellStyle.setFillForegroundColor(new HSSFColor.RED().getIndex());
					}
					cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
					resultCell.setCellStyle(cellStyle);

				}
			} 
		} finally {
			// TODO: handle finally clause
		
		FileOutputStream outFile = new FileOutputStream(xLFile);
		wb.write(outFile);
		wb.close();
		outFile.flush();
		outFile.close();
		}
	}

}

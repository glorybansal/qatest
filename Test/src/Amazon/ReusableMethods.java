package Amazon;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;




public class ReusableMethods {
	
	static BufferedWriter bw = null;
	static BufferedWriter bw1 = null;
	static String htmlname;
	static String objType;
	static String objName;
	static String TestData;
	static String rootPath;
	static int report;


	static Date cur_dt = null;
	static String filenamer;
	static String TestReport;
	int rowcnt;
	static String exeStatus = "True";
	static int iflag = 0;
	static int j = 1;

	static String fireFoxBrowser;
	static String chromeBrowser;

	static String result;

	static int intRowCount = 0;
	static String dataTablePath;
	static int i;
	static String browserName;
	
	protected static boolean testPassed=true;
	
	/*Name of Method:enterText
	 * Brief Description:Enter textvalue to text boxes
	 * Arguments: obj-->WebElement obj,textVal-->text to be entered,objName-->Object name
	 * Created By:Tech Pirates
	 * Creation Date:6/29/2016
	 * Last Modified:6/29/2016
	 */

	public static void enterText (WebElement obj,String textVal,String objName) throws IOException{
		if(obj.isDisplayed()){
			obj.clear();
			   obj.sendKeys(textVal);
			   obj.getAttribute("value");
			   if(obj.getAttribute("value").equals(textVal)){
			   Update_Report("Pass","enterText",textVal+ " is entered in "+objName+" field");
			  }else{
			   Update_Report("Fail","enterText", objName+" is not displayed please check your application");
			}}
	}
	
	/*Name of Method:clickElement
	 * Brief Description:Click on a web Element
	 * Arguments: obj-->WebElement obj,objName-->Object name
	 * Created By:Tech Pirates
	 * Creation Date:6/29/2016
	 * Last Modified:6/29/2016
	 */
public static void clickElement(WebElement obj,String objName) throws IOException{
	if(obj.isDisplayed()){
	obj.click();
	Update_Report("Pass","clickElement",objName+" is clicked");
	}else{
		Update_Report("Fail", "clickElement",objName+" is not displayed please check your application ");
	}
}



/*Name of Method:validateTextMessage
 * Brief Description:Validate Text messsage
 * Arguments: obj-->WebElement obj,expectedErrorMsg-->expected error message,objName-->Object name
 * Created By:Tech Pirates
 * Creation Date:6/29/2016
 * Last Modified:6/29/2016
 */
public static void validateTextMessage(WebElement obj,String expectedErrorMsg,String objName) throws IOException{
	if(obj.isDisplayed()){
		String actualErrorMsg=obj.getText();
		if(actualErrorMsg.equals(expectedErrorMsg)){
			Update_Report("Pass","validateTextMessage","Expected message matched with actual message"+ expectedErrorMsg);
		}else{
			Update_Report("Fail", "validateTextMessage", "Expected message: "+ expectedErrorMsg +"did not match actual message"+ actualErrorMsg);
		}
	}else{
		Update_Report("Fail","validateTextMessage",objName+" is not displayed please check your application ");
	}
}


/*Name of Method:selectCheckBox
 * Brief Description:Select Text Box
 * Arguments: obj-->WebElement obj,objName-->Object name
 * Created By:Tech Pirates
 * Creation Date:6/29/2016
 * Last Modified:6/29/2016
 */

public static void selectCheckBox(WebElement obj,String objName) throws IOException{
	if(obj.isDisplayed()){
		if(!(obj.isSelected())){
		obj.click();
	   Update_Report("Pass", "selectCheckBox",objName+ "checkbox is selected");
		}else{
		Update_Report("Pass","selectCheckBox",objName+" checkbox is already selected" );
	}
}else{
	Update_Report("Fail", "selectCheckBox",objName+" is not displayed please check your application ");
}
}	


/*Name of Method:deselectCheckBox
 * Brief Description:Deselect Text Box
 * Arguments: obj-->WebElement obj,objName-->Object name
 * Created By:Tech Pirates
 * Creation Date:6/29/2016
 * Last Modified:6/29/2016
 */
public static void deselectCheckBox(WebElement obj,String objName) throws IOException{
	if(obj.isDisplayed()){
		if((obj.isSelected())){
		obj.click();
	    Update_Report("Pass", "deselectCheckBox",objName+ "checkbox is deselected");
			}else{
		Update_Report("Pass","deselectCheckBox",objName+" checkbox is already deselected" );
	}
	}
else{
	Update_Report("Fail", "deselectCheckBox",objName+" is not displayed please check your application ");
}
}	


/*Name of Method:checkElementDisplayedAndUnchecked
 * Brief Description:check if particular webelement is displayed and check box is unchecked
 * Arguments: obj-->WebElement obj,objName-->Object name
 * Created By:Tech Pirates
 * Creation Date:7/2/2016
 * Last Modified:7/2/2016
 */
public static void checkElementDisplayedAndUnchecked(WebElement obj,String objName) throws IOException{
	if(obj.isDisplayed()){
		
		if((obj.getAttribute("src").contains("checkbox_unselected_enabled"))){
	   Update_Report("Pass", "ElementDisplayedAndCheckBoxUnchecked",objName+ "checkbox is Unchecked");
		}else{
		Update_Report("Fail","ElementDisplayedAndCheckBoxUnchecked",objName+" checkbox is Checked" );
	}
}else{
	Update_Report("Fail", "ElementDisplayedAndCheckBoxUnchecked",objName+" is not displayed please check your application ");
}
}
/*Name of Method:checkElementsDisplayedAndUnchecked
 * Brief Description:check if webelements are displayed and check box is unchecked
 * Arguments: parentElmt-->WebElement obj,objName-->Object name,
 * Created By:Tech Pirates
 * Creation Date:7/2/2016
 * Last Modified:7/2/2016
 */
public static void checkElementsDisplayedAndUnchecked(WebElement parentElmt,String[] expectedItem) throws IOException{
List<WebElement> brands1 = parentElmt.findElements(By.tagName("li"));
for (int i = 0; i < expectedItem.length; i++) {
	checkElementDisplayedAndUnchecked(brands1.get(i).findElement(By.tagName("img")),
			"Checkbox of: " + expectedItem[i]);
	checkEquals(expectedItem[i], brands1.get(i).getText());
}
}

/*Name of Method:checkElementDisplayed
 * Brief Description:check if particular webpage is displayed
 * Arguments: obj-->WebElement obj,objName-->Object name
 * Created By:Tech Pirates
 * Creation Date:7/2/2016
 * Last Modified:7/2/2016
 */
public static void checkElementDisplayed(WebElement obj,String objName) throws IOException{
	if (obj.isDisplayed()){
		Update_Report("Pass","checkElementDisplayed",objName+" is displayed");
	}else{
		Update_Report("Fail","checkElementDisplayed",objName+" is not displayed please check your application");
	}
}


/*Name of Method:Wait
 * Brief Description:Wait for the page to load
 * Arguments: seconds-->time for wait
 * Created By:Tech Pirates
 * Creation Date:7/2/2016
 * Last Modified:7/2/2016
 */

public static void sleep(int seconds){
	try {
		Thread.sleep(seconds*1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}



/*Name of Method:CheckBox Selected
 * Brief Description:To verify if checkbox is selected
 * Arguments: obj-->WebElement obj,objName-->Object name
 * Created By:Tech Pirates
 * Creation Date:7/2/2016
 * Last Modified:7/2/2016
 */
public static void CheckBoxSelected(WebElement obj,String objName) throws IOException{
	if(obj.isDisplayed()){
		if(obj.isSelected()){
	   Update_Report("Pass", "CheckBoxselected",objName+ "checkbox is selected");
		}else{
		Update_Report("Fail","CheckBoxselected",objName+" checkbox is not selected" );
	}
}else{
	Update_Report("Fail", "CheckBoxSelected",objName+" is not displayed please check your application ");
}
}	

/*Name of Method:CheckTextEqual
 * Brief Description:To check two texts are equal
 * Arguments: obj-->WebElement obj,expectedTex-->expectedTex,objName-->Object name
 * Created By:Tech Pirates
 * Creation Date:7/2/2016
 * Last Modified:7/2/2016
 */

public static void checktextequal(WebElement obj,String expectedText,String objName)throws IOException{
	if(obj.isDisplayed()){
	String actualText=obj.getText();
	if(expectedText.equals(actualText)){
		Update_Report("Pass","checktextequal",expectedText+" matches actual text"+actualText);
	}else{
		Update_Report("Fail","checktextequal",expectedText+"did not match actual text"+actualText);
	}
	}else{
		Update_Report("Fail", "CheckBoxSelected",objName+" is not displayed please check your application ");
	}
}

/*Name of Method:Validate text in drop down menu 
 * Brief Description:To validate drop down menu text
 * Arguments: driver-->WebElement driver,expectedMenu-->expectedMenu,objName-->Object name
 * Created By:Tech Pirates
 * Creation Date:7/6/2016
 * Last Modified:7/6/2016
 */

public static void validateTextInDropDown(WebDriver driver ,String objName,String a, String[] expectedMenu)throws IOException{
	
		for (int i = 1; i <= expectedMenu.length; i++) {
		
			WebElement menuOption = driver.findElement(By.xpath(".//*[@id='"+objName+"']/div[2]/div[2]/div[1]/ul/li["+ a +"]/ul/li["+ i +"]/*"));
			//menuOption = menuOption.findElement(By.xpath(".//*"));
			checkElementDisplayed(menuOption, expectedMenu[i-1]);
			
}
	}

/* Name of the Method: validateTextInDropdn
 * Brief description: validate drop down menu text 
 * Arguments: obj --> webelement Object,objName --> Object Name
 * Created By: TechPirates 
 * Creation Date: July 4 2016
 * Last Modified: July 4 2016
 * */
public static void validateTextInDropdn(WebElement obj, String[] expMenuItemes, String objname) throws IOException{
	String[] actualStr = obj.getText().split("[\\r\\n]+");
	if(obj.isDisplayed()){
		for(int i = 0; i < expMenuItemes.length; i++){

			if(actualStr[i].equals(expMenuItemes[i])){
				Update_Report("Pass", "validateTextInDropdn",  "Expected menu item is: "  +expMenuItemes[i]+ " is matched to actual item: "+actualStr[i]);

			}
			else{
				Update_Report("Fail", "validateTextInDropdn",  "Expected menu item is: "  +expMenuItemes[i]+ " is not matched to actual item: "+actualStr[i]);

			}

		}

	}
	else{
		Update_Report("Fail", "validateTextInDropdn",  objname + " DropDown menu is not displayed please check your application");

	}
}

/*Name of Method:Select Radio Button 
 * Brief Description:To Select Radio Button 
 * Arguments: driver-->WebElement driver,id-->id,value-->value,objName-->Object Name
 * Created By:Tech Pirates
 * Creation Date:7/6/2016
 * Last Modified:7/6/2016
 */
public static void selectRadioButton(WebDriver driver,String id,String value,String objName) throws IOException{
	List<WebElement>objs=driver.findElements(By.id(id));
	for(WebElement obj:objs){
	if(obj.getAttribute("value").equalsIgnoreCase(value)){
	obj.click();
	Update_Report("Pass", "RadioButtonselected",objName+ "Radio Button is selected");
	} else {
	Update_Report("Fail","RadioButtonselected",objName+"Radio Button is not selected" );
}}}

/*Name of Method:CheckEquals
 * Brief Description:To check two texts are equal
 * Arguments: expectedText-->expectedText,actualText-->actualText
 * Created By:Tech Pirates
 * Creation Date:7/2/2016
 * Last Modified:7/2/2016
 */

public static void checkEquals(String expectedText,String actualText)throws IOException{
	if(expectedText.equals(actualText)){
		Update_Report("Pass","checkEquals",expectedText+" matches actual text "+actualText);
	}else{
		Update_Report("Fail","checkEquals",expectedText+" did not match actual text "+actualText);
	}
	}

		
/*Name of Method:Select Menu One Item
 * Brief Description:selectMenuOneItem
 * Arguments: expectedText-->expectedText,actualText-->actualText
 * Created By:Tech Pirates
 * Creation Date:7/2/2016
 * Last Modified:7/2/2016
 */

public static void selectMenuOneItem(WebElement obj,String objName,String expectedItems) throws IOException{
	if(obj.isDisplayed()){
		Select options=new Select(obj);
		List<WebElement>elementOptions=options.getOptions();
		int iSize=elementOptions.size();
		for(int i=0;i<iSize;i++){
			if(options.getOptions().get(i).getText().equalsIgnoreCase(expectedItems)){
			Update_Report("Pass", "selectMenuOneItem",  "Expected menu item is: "  +expectedItems+ " is matched to actual item: "+elementOptions.get(i).getText());
		}
	}
	}

else{
	Update_Report("Fail","selectMenuOneItem",  objName + " DropDown menu is not displayed please check your application");
}
}
		
/* Name of the Method: selectFromDropDown
 * Brief description: select from drop down menu Only one item with select tag
 * Arguments: obj --> webelement Object,objName --> Object Name
 * Created By: TechPirates 
 * Creation Date: July 4 2016
 * Last Modified: July 4 2016
 * */
public static void selectFromDropDown(WebElement obj, String selectItem, String objname) throws Exception{
	if(obj.isDisplayed()){
		Select options = new Select(obj);
		options.selectByVisibleText(selectItem);
		Update_Report("Pass", "selectFromDropDown",  "Menu item is: "  +selectItem+ " is Selected");
		
	}
	else{
		Update_Report("Fail", "selectFromDropDown",  objname + " DropDown menu is not displayed please check your application");
	}
	
}


/* Name of the Method: MouseOver to check font color changes
 * Brief description: MouseOver to check font color changes
 * Arguments: driver-->WebDriver driver,obj --> webelement Object,objName --> Object Name,expectedItem-->Name of object
 * Created By: TechPirates 
 * Creation Date: July 4 2016
 * Last Modified: July 4 2016
 * */
public static void mouseOverToCheckFontColorChanges(WebDriver driver,WebElement obj,String expectedItem,String objName) throws IOException{
	
	if(obj.isDisplayed()){
	obj.getText().equals(expectedItem);
	String colorbeforemouseOver=obj.getCssValue("color");
	Actions action=new Actions(driver);
	action.moveToElement(obj).build().perform();
    String colorAfterMouseOver=obj.getCssValue("color");
    if(!(colorbeforemouseOver.equals(colorAfterMouseOver))){
    	Update_Report("Pass", "mouseOverToCheckFontColorChanges","Font color before: "+colorbeforemouseOver+ " Font color changed during mouseover on: "+ objName + " " +  colorAfterMouseOver);
	}else{
		Update_Report("Fail", "mouseOverToCheckFontColorChanges","Font color before: "+colorbeforemouseOver+ " Font color does not change during mouseover on: "+ objName + " " + colorAfterMouseOver);
		}}
	else{
		Update_Report("Fail", "mouseOverToCheckFontColorChanges", objName+" is not displayed please check your application.");
	}
	}







/* Name of the Method: select by tagname
 * Brief description: select by tagname
 * Arguments: tagname-Webelement tagname,object --> element to be found ,objName --> Object Name
 * Created By: TechPirates 
 * Creation Date: July 4 2016
 * Last Modified: July 4 2016
 * */
public static void selectByTagname(WebDriver driver, String tagname, String object,String objname) throws Exception{
	
	List<WebElement>allItems=driver.findElements(By.tagName("tagname"));
	for(int i=0;i<allItems.size();i++){
		if(allItems.get(i).getText().equalsIgnoreCase(object)){
		
			Update_Report("Pass", "selectByTagname",  "Menu item is: "  +objname+ " is Selected");
		}
	
else{
		Update_Report("Fail", "selectByTagname", "Menu item is: "  +objname+ " is  not Selected") ;
	}
	}
}
/* Name of the Method:readExcel
 * Brief description: Read XL Sheet
 * Arguments: dtTablePath --> path Object,sheetName --> Sheet Name
 * Created By: TechPirates 
 * Creation Date: July 4 2016
 * Last Modified: July 4 2016
 * */	  
public static String[][] readExcel(String dtTablePath, String sheetName ) throws IOException{

	/*Step 1: Get the XL Path*/
	File xlFile = new File(dtTablePath);

	/*step2: Access the Xl File*/
	FileInputStream xlDoc = new FileInputStream(xlFile);

	/*Step3: Access the work book (POI jar file) */
	HSSFWorkbook wb = new HSSFWorkbook(xlDoc);

	/*Step4: Access the Sheet */
	HSSFSheet sheet = wb.getSheet(sheetName);

	int iRowCount = sheet.getPhysicalNumberOfRows();
	int iColCount = sheet.getRow(0).getLastCellNum();


	String[][] xlData = new String[iRowCount][iColCount];

	for(int i =0; i<iRowCount; i++){
		for(int j = 0; j <iColCount; j++){
			xlData[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();

		}

	}
	return xlData;
}


/* Name of the Method:getTodayDate
 * Brief description: To get today's date 
 * Arguments: NA
 * Created By: TechPirates 
 * Creation Date: July 9 2016
 * Last Modified: July 9 2016
 * */	
public static String getTodayDate(){
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	String todayDate = sdf.format(cal.getTime());
	return todayDate;
}


/* Name of the Method:getRandomUUID
 * Brief description: To get random number 
 * Arguments: NA
 * Created By: TechPirates 
 * Creation Date: July 9 2016
 * Last Modified: July 9 2016
 * */
public static String getRandomUUID(){
	return "U_"+java.util.UUID.randomUUID().toString().replace('-','_');
}











public void test() throws Exception {
		
	startReport("Decending order sort","C:/Users/glory/Google Drive/training/onepoint/Report/");

		Update_Report( "Pass", "Decending order sort",  "Decending order sort executing is complete.");
		Update_Report( "Fail", "Ascending order sort",  "Ascending order sort executing is complete.");

		
		bw.close();


	}
public static void startReport(String scriptName, String ReportsPath) throws IOException{

	String strResultPath = null;


	String testScriptName =scriptName;
    testPassed=true;

	cur_dt = new Date(); 
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	String strTimeStamp = dateFormat.format(cur_dt);

	if (ReportsPath == "") { 

		ReportsPath = "C:\\";
	}

	if (ReportsPath.endsWith("\\")) { 
		ReportsPath = ReportsPath + "\\";
	}

	strResultPath = ReportsPath + "Log" + "/" +testScriptName +"/"; 
	File f = new File(strResultPath);
	f.mkdirs();
	htmlname = strResultPath  + testScriptName + "_" + strTimeStamp 
			+ ".html";



	bw = new BufferedWriter(new FileWriter(htmlname));

	bw.write("<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
	bw.write("<TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
	bw.write("<TR><TD BGCOLOR=#66699 WIDTH=27%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Browser Name</B></FONT></TD><TD COLSPAN=6 BGCOLOR=#66699><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>"
			+ "FireFox " + "</B></FONT></TD></TR>");
	bw.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
	bw.write("<TR COLS=7><TD BGCOLOR=#BDBDBD WIDTH=3%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>SL No</B></FONT></TD>"
			+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Step Name</B></FONT></TD>"
			+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Execution Time</B></FONT></TD> "
			+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Status</B></FONT></TD>"
			+ "<TD BGCOLOR=#BDBDBD WIDTH=47%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Detail Report</B></FONT></TD></TR>");


}

public static void Update_Report(String Res_type,String Action, String result) throws IOException {
	String str_time;
	Date exec_time = new Date();
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	str_time = dateFormat.format(exec_time);
	if (Res_type.startsWith("Pass")) {
		bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
				+ (j++)
				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
				+Action
				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
				+ str_time
				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
				+ "Passed"
				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
				+ result + "</FONT></TD></TR>");

	} else if (Res_type.startsWith("Fail")) {
		testPassed=false;
		report = 1;
		bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
				+ (j++)
				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
				+Action
				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
				+ str_time
				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
				+ "<a href= "
				+ htmlname
				+ "  style=\"color: #FF0000\"> Failed </a>"

			+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
			+ result + "</FONT></TD></TR>");

	} 
}

}

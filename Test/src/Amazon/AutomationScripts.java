package Amazon;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class AutomationScripts  extends ReusableMethods {
	
	private static String TEST_REPORT_PATH = "C:/Users/glory/Google Drive/training/onepoint/TestReport_Amazon/";
	
	public static boolean runTest(String automationScript) throws ReflectiveOperationException, SecurityException{
		Method ts=AutomationScripts.class.getMethod(automationScript);
		ts.invoke(ts);
		driver.quit();
		return testPassed;
	}
	
	static WebDriver driver;
	
//TestCase 1-->Launch the Amazon Application
	
	public static void launchTheAmazonApplication() throws IOException{
			
	  startReport("Launch Amazon Application",TEST_REPORT_PATH);
	  driver=new FirefoxDriver();
	  driver.get("http://www.amazon.com/");
	  driver.manage().window().maximize();
	
	  Update_Report("Pass", "Launching Application", "Amazon Application is launched.");
    
	  bw.close();
} 
	
	//TestCase 2-->Verify Drop Down Option after Iphone  is Typedin Search
	
		public static void verifyDropDownOptionAfterIphoneIsTypedInSearch() throws IOException{
				
		startReport("Verify Drop Down Option after Iphone  is Typedin Search",TEST_REPORT_PATH);
		driver=new FirefoxDriver();
		driver.get("http://www.amazon.com/");
		driver.manage().window().maximize();
		
		Update_Report("Pass", "Launching Application", "Amazon Application is launched.");
		
		String[] expMenuItemes={"Search suggestions","iphone 6s case in All Departments","iphone 6s case in Electronics","iphone 6s case in Cell Phones & Accessories"};
		
		WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
		enterText(searchBox, "iphone", "iphone");
		
		WebElement searchSuggestion=driver.findElement(By.id("suggestion-title"));
		checkEquals("Search suggestions", searchSuggestion.getText());
		
		sleep(2);
		WebElement menuItems=driver.findElement(By.id("nav-flyout-searchAjax"));
		validateTextInDropdn(menuItems, expMenuItemes, "Dropdown Menu for iphone");
		
		bw.close();
		}
		
		//TestCase 3-->Click on Search Button after "Iphone " is entered 
		
		public static void clickOnSearchButtonAfterIphoneIsEntered() throws IOException{
					
		startReport("Click on Search Button after Iphone is entered",TEST_REPORT_PATH);
		driver=new FirefoxDriver();
		driver.get("http://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=iphone");
		driver.manage().window().maximize();
			
		Update_Report("Pass", "Launching Application", "Amazon Application is launched.");
			
		WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
		enterText(searchBox, "iphone", "iphone");
		
		WebElement searchButton=driver.findElement(By.xpath(".//*[@id='nav-search']/form/div[2]/div/input"));
		clickElement(searchButton, "Search Button");
			
		bw.close();
			}
			
		//TestCase 4-->Verify Show results for Column  on the left -"Cell Phones & Accessories "Header  
			
		public static void verifyShowResultsForCellPhonesAndAccessories() throws IOException{
					
		startReport("Verify Show results for Column on the left-Cell Phones & Accessories Header",TEST_REPORT_PATH);
		driver=new FirefoxDriver();
		driver.get("http://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=iphone");
		driver.manage().window().maximize();
			
		Update_Report("Pass", "Launching Application", "Amazon Application is launched.");
			
		WebElement cellPhonesAndAccessories=driver.findElement(By.xpath(".//*[@id='s-result-count']/span/a"));
		mouseOverToCheckFontColorChanges(driver, cellPhonesAndAccessories, "Cell Phones & Accessories", "Cell Phones & Accessories");
	
		WebElement cellPhonesAccessoryKits=driver.findElement(By.xpath(".//*[@id='refinements']/div[2]/ul[1]/li[3]/a"));
		mouseOverToCheckFontColorChanges(driver, cellPhonesAccessoryKits, "Cell Phone and Accessory Kits", "Cell Phone and Accessory Kits");
		
		WebElement accessories=driver.findElement(By.xpath(".//*[@id='refinements']/div[2]/ul[1]/li[4]/a/span[1]"));
		mouseOverToCheckFontColorChanges(driver, accessories, "Accessories", "Accessories");
		
		WebElement cellPhonesCases=driver.findElement(By.xpath(".//*[@id='refinements']/div[2]/ul[1]/li[5]/a/span[1]"));
		mouseOverToCheckFontColorChanges(driver, cellPhonesCases, "Cell Phone Cases", "Cell Phone and Cases");
		
		WebElement seeMore=driver.findElement(By.xpath(".//*[@id='seeAllDepartmentClosed1']/li/span/a"));
		mouseOverToCheckFontColorChanges(driver, seeMore, "+ See more", "+ See more");
		
		bw.close();
		}
		
		//TestCase 5-->Verify Show results for Column  on the left -" Computers & Accessories "Header  
		
		public static void verifyShowResultsForColumnOnTheLeftComputersAndAccessories() throws IOException{
							
		startReport("Verify Show results for Column on the left Computers & Accessories Header",TEST_REPORT_PATH);
		driver=new FirefoxDriver();
		driver.get("https://www.amazon.com/s/ref=nb_sb_ss_c_1_16?url=search-alias%3Daps&field-keywords=computer+and+accessories&sprefix=undefined%2Caps%2C457&rh=i%3Aaps%2Ck%3Acomputer+and+accessories");
		driver.manage().window().maximize();
					
	    Update_Report("Pass", "Launching Application", "Amazon Application is launched.");
		
		WebElement computerComponents=driver.findElement(By.xpath(".//*[@id='refinements']/div[2]/ul[1]/li[1]/ul/li[2]/a/span"));
		mouseOverToCheckFontColorChanges(driver, computerComponents, "Computer Components", "Computer Components");
		
		bw.close();
		
				} 
				

		//TestCase 6-->Verify Show results for Column  on the left -"  Electronics  "Header  
				
		public static void verifyShowResultsForColumnOnTheLeftElectronics() throws IOException{
					
		startReport("Verify Show results for Column on the left Electronics Header",TEST_REPORT_PATH);
		driver=new FirefoxDriver();
		driver.get("https://www.amazon.com/s/ref=nb_sb_ss_c_1_16?url=search-alias%3Daps&field-keywords=computer+and+accessories&sprefix=undefined%2Caps%2C457&rh=i%3Aaps%2Ck%3Acomputer+and+accessories");
		driver.manage().window().maximize();
					
		Update_Report("Pass", "Launching Application", "Amazon Application is launched.");	
				
		WebElement electronics=driver.findElement(By.xpath(".//*[@id='refinements']/div[2]/ul[1]/li[2]/a/span[1]"));
		mouseOverToCheckFontColorChanges(driver, electronics, "Electronics", "Electronics");
				
		WebElement sportsFanShop=driver.findElement(By.xpath(".//*[@id='refinements']/div[2]/ul[1]/li[3]/a/span[1]"));
		mouseOverToCheckFontColorChanges(driver, sportsFanShop, "Sports Fan Shop", "Sports Fan Shop");
				
		WebElement sportsAndFitness=driver.findElement(By.xpath(".//*[@id='refinements']/div[2]/ul[1]/li[4]/a/span[1]"));
		mouseOverToCheckFontColorChanges(driver, sportsAndFitness, "Sports & Fitness", "Sports & Fitness");
				
		WebElement seeAll35Depatments=driver.findElement(By.xpath(".//*[@id='seeAllDepartmentClosed1']/li/span/a/span[2]"));
		mouseOverToCheckFontColorChanges(driver, seeAll35Depatments, "+See All 35 Departments", "+See All 35 Departments");
		
		bw.close();
				}
		
//TestCase 7-->Verify Show results for Column  on the left -"  Refine by "Header   
				
	    public static void verifyShowResultsForColumnOnTheLeftRefineby() throws Exception{
					
	
			startReport("Verify Show results for Column on the left RefineBy Header",
					TEST_REPORT_PATH);
			driver = new FirefoxDriver();
			driver.get("http://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=iphone");
			driver.manage().window().maximize();
			sleep(5);
			
			Update_Report("Pass", "Launching Application", "Amazon Application is launched.");
			
			String[] expectedItem = { "Apple", "Hyperion EA", "Rinbers", "Buyee", "Grantwood Technology", "Energen",
					"RCO", "KINGLAKE", "UNU", "Cell Armor", "Maxboost" };
			
			String[] expectedItem1 = { "4 GB", "8 GB", "16 GB", "32 GB"};
			
			String[] expectedItem2 = { "3.9 Inches & Under", "4.0 to 4.4 Inches", "4.5 to 4.9 Inches", "5.0 to 5.4 Inches","5.5 Inches & Over"};
			
			String[] expectedItem3 = { "iPhone 6/6S", "iPhone 6/6S Plus", "iPhone 5/5S/SE", "iPhone 5C","iPhone 4/4S","Samsung Galaxy S 7","Samsung Galaxy S 7 Edge",
					                   "Samsung Galaxy S 6","Samsung Galaxy S 6 Edge","Samsung Galaxy S 5","Samsung Galaxy S 4","Samsung Galaxy Note 4","LG G3"};
					
			WebElement amazonPrime = driver.findElement(By.xpath(".//*[@id='refinements']/h2[1]"));
			checkEquals("Amazon Prime", amazonPrime.getText());
			
			WebElement checkbox = driver.findElement(By.xpath(".//*[@id='ref_2470954011']")).findElement(By.tagName("img"));
			checkElementDisplayedAndUnchecked(checkbox, "Amazon Prime Checkbox");
			
			WebElement eligibleForFreeShipping = driver.findElement(By.xpath(".//*[@id='refinements']/h2[2]"));
			checkEquals("Eligible for Free Shipping", eligibleForFreeShipping.getText());
			
			WebElement checkbox1 = driver.findElement(By.xpath(".//*[@id='ref_2491144011']/li/a/img"));
			checkElementDisplayedAndUnchecked(checkbox1, "Eligible for free shipping Checkbox");
			
			String[] expectedTexts = { "Brand", "Cell Phone Internal Memory", "Cell Phone Display Size", "Cell Phone Compatibility", 
					"Avg. Customer Review"};
			List<String> expectedHeadings = new ArrayList<String>(Arrays.asList(expectedTexts));
					
			List<WebElement> h2List = driver.findElements(By.xpath(".//*[@id='refinements']/h2"));
			for(WebElement h2:h2List){
				if(expectedHeadings.contains(h2.getText())){
					expectedHeadings.remove(expectedHeadings.indexOf(h2.getText()));
					Update_Report("Pass","Check Heading","Heading: " + h2.getText() +" is present");	
				}
			}
			if(expectedHeadings.size() > 0){
				Update_Report("Fail","Check Heading","Heading not present: "+expectedHeadings.toString());
			}
			
			
			WebElement brands = driver.findElement(By.id("ref_2528832011"));
			checkElementsDisplayedAndUnchecked(brands, expectedItem);
			
//			WebElement cellPhoneInternalMemory = driver.findElement(By.xpath(".//*[@id='refinements']/h2[4]"));
//			checkEquals("Cell Phone Internal Memory", cellPhoneInternalMemory.getText());
//			
			WebElement memories = driver.findElement(By.id("ref_7805160011"));
			checkElementsDisplayedAndUnchecked(memories, expectedItem1);
			
//			WebElement cellPhonedisplaySize = driver.findElement(By.xpath(".//*[@id='refinements']/h2[8]"));
//			checkEquals("Cell Phone Display Size", cellPhonedisplaySize.getText());
			
			WebElement sizes = driver.findElement(By.id("ref_6215726011"));
			checkElementsDisplayedAndUnchecked(sizes, expectedItem2);
			
//			WebElement cellPhoneCompatibility = driver.findElement(By.xpath(".//*[@id='refinements']/h2[10]"));
//			checkEquals("Cell Phone Compatibility", cellPhoneCompatibility.getText());
			
			WebElement phones = driver.findElement(By.id("ref_2488708011"));
			checkElementsDisplayedAndUnchecked(phones, expectedItem3);
			
//            WebElement avgCustomerReview = driver.findElement(By.xpath(".//*[@id='refinements']/h2[13]"));
//			checkEquals("Avg. Customer Review", avgCustomerReview.getText());
			
			WebElement reviews = driver.findElement(By.id("ref_2491147011"));
			List<WebElement>review=reviews.findElements(By.tagName("i"));
			for(int i=4;i>=1;i--){
				if(review.get(4-i).getAttribute("class").contains("a-star-"+i)){
					Update_Report("Pass", "Average Customer Review", "Average Customer Review: "+ i +" Star ");
				}
				
			}
		
			selectByTagname(driver, "h2", "International Shipping","International Shipping");
			
			selectByTagname(driver, "a", "AmazonGlobal Eligible", "AmazonGlobal Eligible");
			WebElement amazonGlobalEligible = driver.findElement(By.xpath(".//*[@id='ref_2944662011']/li/a/img"));
			checkElementDisplayedAndUnchecked(amazonGlobalEligible, "AmazonGlobal Eligible");
		   
			bw.close();
	}
	   
//TestCase 8-->Check Main Tab
	    
	    public static void checkMainTab() throws Exception{
			
	    	
			startReport("Check Main Tab",TEST_REPORT_PATH);
			driver = new FirefoxDriver();
			driver.get("http://www.amazon.com");
			driver.manage().window().maximize();
			
			Update_Report("Pass", "Launching Application", "Amazon Application is launched.");
	    
			WebElement departments=driver.findElement(By.xpath(".//*[@id='nav-link-shopall']/span[2]"));
			checkEquals("Departments", departments.getText());
			
			Actions action=new Actions(driver);
			action.moveToElement(departments).build().perform();
			
			WebElement yourAmazon=driver.findElement(By.xpath(".//*[@id='nav-your-amazon']"));
			checkEquals("Your Amazon.com", yourAmazon.getText());
	    
			WebElement deals=driver.findElement(By.xpath(".//*[@id='nav-xshop']/a[2]"));
			checkEquals("Today's Deals", deals.getText());
	        
			WebElement giftCards=driver.findElement(By.xpath(".//*[@id='nav-xshop']/a[3]"));
			checkEquals("Gift Cards & Registry", giftCards.getText());
			
			WebElement sell=driver.findElement(By.xpath(".//*[@id='nav-xshop']/a[4]"));
			checkEquals("Sell", sell.getText());
			
			WebElement help=driver.findElement(By.xpath(".//*[@id='nav-xshop']/a[5]"));
			checkEquals("Help", help.getText());
			
			WebElement yourAccount=driver.findElement(By.xpath(".//*[@id='nav-link-yourAccount']"));
			checkEquals("Hello. Sign in\nYour Account", yourAccount.getText().trim());
			Actions action1=new Actions(driver);
			action1.moveToElement(yourAccount).build().perform();
			
			WebElement tryPrime=driver.findElement(By.xpath(".//*[@id='nav-link-prime']/span[2]"));
			checkEquals("Try Prime", tryPrime.getText());
	   
			WebElement lists=driver.findElement(By.xpath(".//*[@id='nav-link-wishlist']"));
			checkEquals("Lists", lists.getText());
			
			WebElement cart=driver.findElement(By.xpath(".//*[@id='nav-cart']"));
			checkEquals("Cart\n0", cart.getText().trim());
			
			bw.close();
	    
	    }
			
			
	  //TestCase 9-->Validate Department Dropdown List
	    
	    public static void validatedepartmentDropdownList() throws Exception{
			
	    	
			startReport("Validate Department Dropdown List",TEST_REPORT_PATH);
			driver = new FirefoxDriver();
			driver.get("http://www.amazon.com");
			driver.manage().window().maximize();
			sleep(5);
			
			Update_Report("Pass", "Launching Application", "Amazon Application is launched.");
	    
			String[] expMenuItemes={"Amazon Video","Digital & Prime Music","Appstore for Android","Amazon Photos & Drive",
					"Kindle E-readers & Books","Fire Tablets","Fire TV","Echo & Alexa","AmazonFresh NEW","Books & Audible","Movies, Music & Games","Electronics & Computers","Home, Garden & Tools","Beauty, Health & Grocery",
					"Toys, Kids & Baby","Clothing, Shoes & Jewelry","Sports & Outdoors","Automotive & Industrial",
					"Handmade","Home Services","Credit & Payment Products","Full Store Directory"};
			
			
			WebElement departments=driver.findElement(By.xpath(".//*[@id='nav-link-shopall']/span[2]"));
			checkEquals("Departments", departments.getText());
			
			Actions action=new Actions(driver);
			action.moveToElement(departments).build().perform();
			
			WebElement menuItems=driver.findElement(By.id("nav-flyout-shopAll"));
			validateTextInDropdn(menuItems, expMenuItemes, "Dropdown Menu for Departments");
	    
	        bw.close();
	    
	   }
	    
//TestCase 10-->Validate "Your Account" Dropdown List
	    
	    public static void validateyourAccountDropdownList() throws Exception{
			
	    	
			startReport(" Validate Your Account Dropdown List",TEST_REPORT_PATH);
			driver = new FirefoxDriver();
			driver.get("http://www.amazon.com");
			driver.manage().window().maximize();
			
			Update_Report("Pass", "Launching Application", "Amazon Application is launched.");
	    
			String[] expMenuItemes={"Sign in","New customer? Start here.","Your Account","Your Orders","Your Lists","Your Recommendations",
					"Your Subscribe & Save Items","Your Digital Subscriptions","Your Service Requests","Your Prime Membership",
					"Your Garage","Register for a Business Account","Your Amazon Credit Card Accounts",
					"Manage Your Content and Devices","Your Video Subscriptions","Your Prime Music",
					"Your Music Library","Your Amazon Drive","Your Prime Video","Your Kindle Unlimited",
					"Your Watchlist","Your Video Library","Your Android Apps & Devices"};
			
			WebElement yourAccount=driver.findElement(By.xpath(".//*[@id='nav-link-yourAccount']"));
			checkEquals("Hello. Sign in\nYour Account", yourAccount.getText().trim());
			
			Actions action=new Actions(driver);
			action.moveToElement(yourAccount).build().perform();
			
			WebElement menuItems=driver.findElement(By.id("nav-flyout-yourAccount"));
			validateTextInDropdn(menuItems, expMenuItemes, "Dropdown Menu for Your Account");
	    
	        bw.close();
	    }
	    
//TestCase 11-->Validate the Dropdown list in <Try Prime> Tab
	    
	    public static void validateTryPrimeDropdownList() throws Exception{
			
	    	
			startReport(" Validate Try Prime Dropdown List",TEST_REPORT_PATH);
			driver = new FirefoxDriver();
			driver.get("http://www.amazon.com");
			driver.manage().window().maximize();
			
			Update_Report("Pass", "Launching Application", "Amazon Application is launched.");
	    
			String[] expMenuItemes={"Start your free trial and join millions of Amazon Prime members who enjoy:",
					"Prime Video Watch thousands of movies and TV episodes on your favorite device",
					"Free Two-Day Shipping Get fast, free shipping on over 20 million items",
					"Over a Million Songs, Ad-Free With Prime Playlists, listen to over a million songs, playlists and stations – all ad-free",
					"Kindle Owners' Lending Library Borrow from over 800,000 titles for free","Try Prime","amazonPrime"};
			

            WebElement tryPrime=driver.findElement(By.xpath(".//*[@id='nav-link-prime']/span[2]"));
			checkEquals("Try Prime", tryPrime.getText());
			
			Actions action=new Actions(driver);
			action.moveToElement(tryPrime).build().perform();
			
			WebElement menuItems=driver.findElement(By.id("nav-flyout-prime"));
			validateTextInDropdn(menuItems, expMenuItemes, "Dropdown Menu for Try Prime");
	    
	        bw.close();
	    }

//TestCase 12-->Validate "Lists" Dropdown List
	    
	    public static void validateListsDropdownList() throws Exception{
			
	    	
			startReport(" Validate Lists Dropdown List",TEST_REPORT_PATH);
			driver = new FirefoxDriver();
			driver.get("http://www.amazon.com");
			driver.manage().window().maximize();
			
			Update_Report("Pass", "Launching Application", "Amazon Application is launched.");
	    
			String[] expMenuItemes={"Create a List","Find a List or Registry","Find a Gift",
					"Save Items from the Web","Install Amazon Assistant","Wedding Registry",
					"Baby Registry","Kids' Birthdays","School Lists","Friends & Family Gifting",
					"Pantry Lists","Your Hearts (in Fashion)"};
			
			WebElement lists=driver.findElement(By.xpath(".//*[@id='nav-link-wishlist']"));
			checkEquals("Lists", lists.getText());
			
			Actions action=new Actions(driver);
			action.moveToElement(lists).build().perform();
			
			WebElement menuItems=driver.findElement(By.id("nav-flyout-wishlist"));
			validateTextInDropdn(menuItems, expMenuItemes, "Dropdown Menu for Lists");
	    
	        bw.close();
	    }
	    
		
		
		
		
		
		
		
		
		
		
		
	    	

}
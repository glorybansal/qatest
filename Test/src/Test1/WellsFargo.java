package Test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WellsFargo {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver=new FirefoxDriver();
		driver.get("https://www.wellsfargo.com/");
		driver.manage().window().maximize();
		
		System.out.println("Running Testcase for Wells Fargo.");
		System.out.println("Application is launched.");
		
		WebElement personal=driver.findElement(By.xpath(".//*[@id='tabNav']/ul/li[1]"));
		personal.getText().equals("Personal");
		
		System.out.println("Verified Personal Tab.");
		
		WebElement aboutWellsFargo=driver.findElement(By.xpath(".//*[@id='headerTools']/nav/ul/li[2]/a"));
		aboutWellsFargo.click();
		driver.getTitle().equals("About Wells Fargo");
		
		System.out.println("About Wells Fargo Tab is clicked and page is verified.");
		
		WebElement heading=driver.findElement(By.xpath(".//*[@id='shell']/div[1]/h1"));
		heading.getText().equals("About Wells Fargo");
		
		
		WebElement homePage=driver.findElement(By.xpath(".//*[@id='brand']/a/img"));
		homePage.click();
		
		System.out.println("Homepage is displayed.");
		
		WebElement personal1=driver.findElement(By.xpath(".//*[@id='tabNav']/ul/li[1]"));
		personal1.getClass().equals("current");
		
		System.out.println("Personal Tab is highlighted.");
		
		WebElement insurance=driver.findElement(By.xpath(".//*[@id='insuranceTab']/a"));
		insurance.click();
		
		System.out.println("Insurance tab is clicked");
		
		WebElement homeOwners_insurance=driver.findElement(By.xpath(".//*[@id='insurance']/div[1]/div[2]/ul/li[1]/a"));
		homeOwners_insurance.click();
		
		System.out.println("Homeowners Insurance tab is clicked.");
		
		Thread.sleep(5000);
		WebElement zipCode=driver.findElement(By.xpath(".//*[@id='zipCode' and @placeholder='ZIP code']" ));
		zipCode.sendKeys("94404");
		
		System.out.println("Test case passed:Zip Code is entered.");
		driver.quit();
		
		System.out.println("Driver:quit");
		}
	
	
	
	
	
	
	
	
	
	
	

}

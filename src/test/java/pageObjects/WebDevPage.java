package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebDevPage extends BasePage {

	public static String parentWindow;
	public static List<String> courseTitles=new ArrayList<String>();
	public static List<String> courseHours=new ArrayList<String>();
	public static List<String> courseRatings=new ArrayList<String>();
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	public WebDevPage(WebDriver driver)
	{
		super(driver);
	}
	

	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/label[1]/span[1]/span[1]/input[1]") 
	public WebElement chkBoxEnglish;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/label[1]/span[1]/span[1]/input[1]") 
	public WebElement chkBoxBeginner;
	
	
	@FindBy(xpath="(//*[@class='cds-CommonCard-clickArea']/div/div[2]/div[1]/div[2]/a)[1]")
	public WebElement firstCourse;
	
	@FindBy(xpath="(//*[@class='cds-CommonCard-clickArea']/div/div[2]/div[1]/div[2]/a)[2]")
	public WebElement secondCourse;
	
	
	
	
	
	//div[contains(@class,"css-1i4o2ol")]//child::span[contains(text(),' hours')]  //secondpage all the course hour elements to 
	
	
	
	public void clickEnglishCheckBox() throws InterruptedException {
		Thread.sleep(2000);
		chkBoxEnglish.click();
	
	}
	
	public void clickBeginnerCheckBox() throws InterruptedException {
		Thread.sleep(2000);
		chkBoxBeginner.click();
		Thread.sleep(2000);
	}
	
	public void getParentWindow(WebDriver driver)
	{
		this.driver=driver;
		parentWindow=driver.getWindowHandle();
	}
	
	public void clickFirstCourse() throws InterruptedException
	{
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();",firstCourse);
		Thread.sleep(4000);
	}
	
	public void clickSecondCourse() throws InterruptedException
	{
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();",secondCourse);
		Thread.sleep(2000);
	}
	
	public boolean invalidSearch()
	{
		return chkBoxEnglish.isDisplayed();
	}
}

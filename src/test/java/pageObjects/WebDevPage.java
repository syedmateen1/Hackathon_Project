package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
	
	@FindBy(xpath="(//form[@class='search-form']/div/div[1]/input)[1]")
	public WebElement searchInputBox;
	
	@FindBy(xpath="//button[@class='nostyle search-button']")
	public WebElement searchButton;

	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/label[1]/span[1]/span[1]/input[1]") 
	public WebElement chkBoxEnglish;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/label[1]/span[1]/span[1]/input[1]") 
	public WebElement checkBoxBeginner;
	
	
	@FindBy(xpath="(//*[@class='cds-CommonCard-clickArea']/div/div[2]/div[1]/div[2]/a)[1]")
	public WebElement firstCourse;
	
	@FindBy(xpath="(//*[@class='cds-CommonCard-clickArea']/div/div[2]/div[1]/div[2]/a)[2]")
	public WebElement secondCourse;
	
	@FindBy(xpath="//div[@class='cds-ContextualHelp-label']/label")
    public WebElement LanguageFilter;
    
    @FindBy(xpath="//div[@data-testid='search-filter-group-Level']//label")
    public WebElement LevelFilter;
    
    @FindBy(xpath="(//div[@class='rc-ActiveFilterItems css-7nzhcp']/button)[1]")
    public WebElement EnglishFilter;

    @FindBy(xpath="(//div[@class='rc-ActiveFilterItems css-7nzhcp']/button)[2]")
    public WebElement BeginnerFilter;
	
	
	
	
	//div[contains(@class,"css-1i4o2ol")]//child::span[contains(text(),' hours')]  //secondpage all the course hour elements to 
    public void search(String value) throws InterruptedException {
    	js.executeScript("arguments[0].value = '';", searchInputBox);
		
//		Thread.sleep(2000);
		searchInputBox.sendKeys(value);
		Thread.sleep(2000);
		
		//click search
		js.executeScript("arguments[0].click();",searchButton);
//		Thread.sleep(2000);
	}
	
	
	public void clickEnglishCheckBox() throws InterruptedException {
		Thread.sleep(2000);
		chkBoxEnglish.click();
	
	}
	
	public void clickBeginnerCheckBox() throws InterruptedException {
		//mywait.until(ExpectedConditions.elementToBeClickable(checkBoxBeginner));
	    JavascriptExecutor js=(JavascriptExecutor)driver; 
	    js.executeScript("window.scrollBy(0,1000)","");
		Thread.sleep(3000);
    	checkBoxBeginner.click();
    	js.executeScript("window.scrollBy(0,-1000)","");
	}
	
	public Boolean isLanguageCheckBoxDisplayed() { 
    	mywait.until(ExpectedConditions.visibilityOf(LanguageFilter));
    	Boolean result=LanguageFilter.isDisplayed();
    	return result; 
    }
     
    public Boolean isLevelCheckBoxDisplayed() {
    	mywait.until(ExpectedConditions.visibilityOf(LevelFilter));
    	Boolean result=LevelFilter.isDisplayed();
    	return result;  
    }
    
    public Boolean isLanguageCheckBoxClickable() { 
    	mywait.until(ExpectedConditions.elementToBeClickable(LanguageFilter));
    	Boolean result=LanguageFilter.isEnabled();
    	return result; 
    }
    
    public Boolean isLevelCheckBoxClickable() { 
    	mywait.until(ExpectedConditions.elementToBeClickable(LevelFilter));
    	Boolean result=LevelFilter.isEnabled(); 
    	return result;  
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
	
	public Boolean searchResult(String title) {
    	String result=driver.findElement(By.xpath("//div[@data-e2e='NumberOfResultsSection']/span")).getText();
    	if(result.contains(title)) {
    		return true;
    	}else { 
    		return false;
    	}
    }
    
    public Boolean checkLanguageFilterDisplayed() {
    	mywait.until(ExpectedConditions.visibilityOf(LanguageFilter));
    	Boolean result=LanguageFilter.isDisplayed();
    	return result;
    }
    
    public Boolean CheckLanguageFilterEnabled() {
    	mywait.until(ExpectedConditions.visibilityOf(LanguageFilter));
    	Boolean result=LanguageFilter.isEnabled(); 
    	return result; 
    }
    
    public Boolean checkLevelFilterDisplayed() {
    	mywait.until(ExpectedConditions.visibilityOf(LevelFilter));
    	Boolean result=LevelFilter.isDisplayed();
    	return result; 
    }
    
    public Boolean CheckLevelFilterEnabled() {
    	mywait.until(ExpectedConditions.visibilityOf(LevelFilter));
    	Boolean result=LevelFilter.isEnabled(); 
    	return result; 
    }
    
    public Boolean isEnglishFilterDisplayed() {
    	mywait.until(ExpectedConditions.visibilityOf(EnglishFilter));
    	String name=EnglishFilter.getText();
	    if(name.contains("Language: English")) {
	    	 return true;
	    }
	    else { 
	    	 return false;
	    }
    }
    
    public Boolean isBeginnerFilterDisplayed() {
    	mywait.until(ExpectedConditions.visibilityOf(BeginnerFilter));
    	String name1=BeginnerFilter.getText();
	    if(name1.contains("Beginner")) {
	    	 return true;
	    } 
	    else { 
	    	 return false; 
	    }  
    } 
	
	public boolean invalidSearch()
	{
		return chkBoxEnglish.isDisplayed();
	}
}

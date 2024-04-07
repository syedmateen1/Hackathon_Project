package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LanguageLearn extends BasePage{

	public LanguageLearn(WebDriver driver) {
		super(driver);
	}
	
	
			
	@FindBy(xpath="(//a[@class='cds-119 cds-113 cds-115 css-ia3qe1 cds-142'])[1]")
	WebElement checkFBS;
			
	//SearchBox:
	@FindBy(xpath="(//input[@placeholder='What do you want to learn?'])[1]")
	WebElement searchBox;
	
	//SearchButton:
	@FindBy(xpath="(//div[@class='magnifier-wrapper'])[2]")
	WebElement searchButton;
	
	//SeeAll:
	@FindBy(xpath="(//span[@class='cds-button-label'][normalize-space()='Show more'])[2]")
	WebElement seeAll;
	
	//Close:
	@FindBy(xpath="(//span[@class='cds-button-label'][normalize-space()='Close'])[2]")
	WebElement closeButton;
	
	//HomeButton:
    @FindBy(xpath="//a[@aria-label='Coursera']")
	WebElement homeButton;
    
    //For Enterprise:
    @FindBy(xpath="//a[normalize-space()='For Enterprise']")
	WebElement enterprise;
    
    public void navigateToForBusiness(){
    	
    	checkFBS.click();
    }
    
    public boolean availFBS(){
    	
    	return checkFBS.isDisplayed();
    }
    
    public void clearSearch() {
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("arguments[0].value=' '",searchBox);
    }
	public void searchBox(String value) {
		searchBox.sendKeys(value);
	}
	
	public void clickSearch() {
		searchButton.click();
	}
	
	public void clickSeeAll() {
		seeAll.click();
	}
	
	public boolean SeeAllisDisplayed() {
		return seeAll.isDisplayed();
	}
	
	public boolean LanguageIsDisplayed() {
		return seeAll.isDisplayed();
	}
	
	public void readLanguages() {
		List<WebElement> languages = driver.findElements(By.xpath("//*[@class='css-zweepb']/label/div/span/span"));
	     for(WebElement s : languages)
			{
				String a = s.getText().replaceAll("[\\(][\\d][\\)]|[\\(][\\d,]+[\\d][\\)]","");
				
				String b=s.getText().replaceAll("[\\(][^\\d]+[^\\d][\\)]","");
				String c=b.replaceAll("([\\( A-Za-z\\)])","");
				
				for(int i=0;i<1;i++)
				{
					System.out.println(a+"-"+c);
				}
				
			}
	}
	
	public void clickClose() {
		closeButton.click();
	}
	
	public void scrollTillLevel() {
		JavascriptExecutor js=(JavascriptExecutor)driver; 
	    js.executeScript("window.scrollBy(0,1000)","");
	}
	
	public void readLevels() {
		List<WebElement> levels=driver.findElements(By.xpath("//div[@data-testid='search-filter-group-Level']/div/div/div/label/div/span/span"));
	    List<String> levelname=new ArrayList<String>();
	    List<String> levelcount=new ArrayList<String>();
        for(WebElement l:levels) {
      	    String level=l.getText();
      	    String[] c=level.split(" ");
      	    levelname.add(c[0]);
        }
        for(WebElement l:levels) {
        	String level=l.getText().replaceAll("[^0-9]","");
            String[] c=level.split(" ");
        	levelcount.add(c[0]);
        }
        for(int i=0;i<levelname.size();i++) {
	    	System.out.println(levelname.get(i)+"-"+levelcount.get(i));
	    }
	}
	
	public void clickHome() {
		homeButton.click();
	}
	
	public boolean checkSearchPage() {
		
		if((driver.getTitle()).contains("Language Learning"))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	

	
	
}

package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CoursesForCampus extends BasePage{

	public CoursesForCampus(WebDriver driver) {
		super(driver);
	}
	
	//For Enterprise:
	@FindBy(xpath="//a[normalize-space()='For Enterprise']")
	WebElement enterprise;
	
	//Form Element:
	@FindBy(xpath="(//div[@class='cds-9 css-1xdhyk6 cds-10 cds-18'])[2]")
	WebElement form;
	
	//FirstName:
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement firstName;
	
	//LastName:
	@FindBy(xpath="//input[@id='LastName']")
	WebElement lastName;
	
	//Email:
	@FindBy(xpath="//input[@id='Email']")
	WebElement email;
	
	//Phone:
	@FindBy(xpath="//input[@id='Phone']")
	WebElement phone;
	
	//ComapanyName:
	@FindBy(xpath="//input[@id='Company']")
	WebElement companyName;
	
	//ComapanySize:
	@FindBy(xpath="//select[@id='Employee_Range__c']")
	WebElement companySize;
	
	//JobTitle:
	@FindBy(xpath="//input[@id='Title']")
	WebElement jobTitle;
	
	//Learners:
	@FindBy(xpath="//select[@id='Self_reported_employees_to_buy_for__c']")
	WebElement learners;
	
	//Country:
	@FindBy(xpath="//select[@id='Country']")
	WebElement country;
	
	//State:
	@FindBy(xpath="//select[@id='State']")
	WebElement state;
	
	//Needs:
	@FindBy(xpath="//select[@id='What_the_lead_asked_for_on_the_website__c']")
	WebElement needs;
	
	//Submit:
	@FindBy(xpath="//button[normalize-space()='Submit']")
	WebElement submit;
	
	//ErrorMsg:
	@FindBy(xpath="//div[@id='ValidMsgEmail']")
	WebElement errormsg;
	
	public void enterprise() {
		enterprise.click();
	}
	
	public void form() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",form);
	}
	
	public void firstName(String fName) {
		firstName.sendKeys(fName); 
	}
	
	public void lastName(String lname) {
		lastName.sendKeys(lname); 
	}
	
	public void email(String email1) {
		email.sendKeys(email1); 
	}
	
	public void phone(String phone1) {
		phone.sendKeys(phone1);  
	}
	
	public void companyName(String cname) {
		companyName.sendKeys(cname); 
	}
	
	public void companySize(String csize) {
		Select size=new Select(companySize);
		size.selectByVisibleText(csize);
	}
	
	public void jobTitle(String jtitle) {
		jobTitle.sendKeys(jtitle); 
	}
	
	public void learner(String lcount) {
		Select learner=new Select(learners); 
		learner.selectByVisibleText(lcount);
	}
	
	public void country(String countryName) {
		Select country1=new Select(country); 
		country1.selectByVisibleText(countryName);
	}
	
	public void state(String stateName) {
		Select state1=new Select(state);  
		state1.selectByVisibleText(stateName);
	}
	
	public void needs(String need) {
		Select needs1=new Select(needs);  
		needs1.selectByVisibleText(need); 
	}
	
	public void clickSubmit() {
		submit.click();
	}
	
	public String getErrorMsg() {
		return errormsg.getText(); 
	}
}

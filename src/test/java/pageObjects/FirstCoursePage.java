package pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;

public class FirstCoursePage extends BasePage {

	public static String firstCourseWindow;
	public static String secondCourseWindow;
	public WebDevPage wdp;
	
	public FirstCoursePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	
	@FindBy(xpath="//*[@id='rendered-content']/div/main/section[2]/div/div/div[1]/div[1]/section/h1")
	public WebElement firstCourseTitle;

	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/main[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[1]/section[1]/div[2]/div[3]/div[1]")
	public WebElement firstCourseHours;

	@FindBy(xpath="/html/body/div[2]/div/main/section[2]/div/div/div[2]/div/div/section/div[2]/div[1]/div[1]")
	public WebElement firstCourseRating;
	
	
	public boolean firstCourse_T_IsDisplayed()
	{
		
		
		return firstCourseTitle.isDisplayed();
			
	}
	public boolean firstCourse_H_IsDisplayed()
	{
		
		
		return firstCourseHours.isDisplayed();
			
	}
	public boolean firstCourse_R_IsDisplayed()
	{
		
		
		return firstCourseRating.isDisplayed();
			
	}
	
	public void firstCourseDetails()
	{
		
		driver.switchTo().window(firstCourseWindow);
		WebDevPage.courseTitles.add(firstCourseTitle.getText());
		WebDevPage.courseHours.add(firstCourseHours.getText());
		WebDevPage.courseRatings.add(firstCourseRating.getText());
		
		
	}
	
	
	
	public void getWindowHandles()
	{
		
		Set<String> windows=driver.getWindowHandles();
		System.out.println(windows);
		for(String i: windows)
		{
			
			if(driver.switchTo().window(i).getTitle().equalsIgnoreCase("Python for Data Science, AI & Development | Coursera"))
			{
				firstCourseWindow=i;
			}
			else if(driver.switchTo().window(i).getTitle().equalsIgnoreCase("Meta Front-End Developer Professional Certificate | Coursera"))
			{
				secondCourseWindow=i;
			}
		}

   }
	
	public void getWindowHandlesListF() throws InterruptedException
	{
		
		Set<String> windows=driver.getWindowHandles();
		List<String> windlist = new ArrayList<String>(windows);
		driver.switchTo().window(windlist.get(1));	
		if(firstCourse_T_IsDisplayed())
		{
		
		}
		else
		{
			driver.switchTo().window(windlist.get(0));
		}
	
	
   }
}

package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	@FindBy(xpath="//input[@placeholder='Username']")
	  WebElement username;
	@FindBy(xpath="//input[@placeholder='Password']")
	  WebElement password;
	@FindBy(xpath="//button[normalize-space()='Login']")
	  WebElement loginbutton;
	@FindBy(xpath="//p[normalize-space()='Time at Work']")
	  WebElement timeatwork;
	@FindBy(xpath="//a[normalize-space()='Logout']")
	  WebElement logout;
	@FindBy(xpath="//h6[normalize-space()='Dashboard']")
	 WebElement dashboard;
	@FindBy(xpath="//p[normalize-space()='My Actions']")
	  WebElement myactions;
	@FindBy(xpath="//p[normalize-space()='Quick Launch']")
	 WebElement quicklaunch;
	@FindBy(xpath="//p[normalize-space()='Employees on Leave Today']")
	 WebElement ed_by_leave_today;
	@FindBy(xpath="//p[normalize-space()='Employee Distribution by Sub Unit']")
	 WebElement ed_by_subunit;
	@FindBy(xpath="//p[normalize-space()='Employee Distribution by Location']")
	 WebElement ed_by_location;
	
	@FindBy(xpath="//button[@class='oxd-icon-button oxd-icon-button--success orangehrm-report-icon']")
	 WebElement leave_request_to_approve;
	@FindBy(xpath="//button[@class='oxd-icon-button oxd-icon-button--warn orangehrm-report-icon']")
	 WebElement timesheet_to_approve;
	@FindBy(xpath="//button[@class='oxd-icon-button oxd-icon-button--warn orangehrm-report-icon']")
	 WebElement pending_self_review;
	@FindBy(xpath="//button[@class='oxd-icon-button oxd-icon-button--info orangehrm-report-icon']")
	 WebElement candidate_to_interview;
	

	@FindBy(xpath="//button[@title='Assign Leave']//*[name()='svg']")
	 WebElement assign_leave;
	@FindBy(xpath="//button[@title='Leave List']//*[name()='svg']")
	 WebElement leave_list;
	@FindBy(xpath="//button[@title='Timesheets']//*[name()='svg']")
	 WebElement timesheets;
	@FindBy(xpath="//button[@title='Apply Leave']//*[name()='svg']")
	 WebElement apply_leave;
	@FindBy(xpath="//button[@title='My Leave']//*[name()='svg']//*[name()='g' and contains(@fill,'currentCol')]//*[name()='path' and contains(@class,'cls-1')]")
	 WebElement my_leave;
	@FindBy(xpath="//button[@title='My Timesheet']//*[name()='svg']")
	 WebElement my_timesheet;
	
	
	 WebDriver driver;
	
	
	 
	public DashboardPage( WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginToSite(String validusername, String validpassword ) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		username.sendKeys(validusername);

		password.sendKeys(validpassword);

		loginbutton.click();
			
	}
	public void checkOnHeadings() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		dashboard.isDisplayed();
		timeatwork.isDisplayed();
		myactions.isDisplayed();	
		ed_by_leave_today.isDisplayed();
		ed_by_subunit.isDisplayed();
		ed_by_location.isDisplayed();
		
	}
	public void myActionsClickables()
	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		leave_request_to_approve.click();
		driver.navigate().back();
		timesheet_to_approve.click();
		driver.navigate().back();
		pending_self_review.click();
		driver.navigate().back();
		candidate_to_interview.click();
		driver.navigate().back();
	}
	public void quickLaunchClickables()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		assign_leave.click();
		driver.navigate().back();
		leave_list.click();
		driver.navigate().back();
		timesheets.click();
		driver.navigate().back();
		apply_leave.click();
		driver.navigate().back();
		my_leave.click();
		driver.navigate().back();
		my_timesheet.click();
		driver.navigate().back();
		driver.close();
	}
}

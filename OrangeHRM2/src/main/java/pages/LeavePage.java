package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeavePage {
	@FindBy(xpath="//input[@placeholder='Username']")
	  WebElement username;
	@FindBy(xpath="//input[@placeholder='Password']")
	  WebElement password;
	@FindBy(xpath="//button[normalize-space()='Login']")
	  WebElement loginbutton;
	
	@FindBy(xpath="//span[normalize-space()='Leave']")
	  WebElement leave;
	@FindBy(xpath="//a[normalize-space()='Apply']")
	  WebElement apply;
	@FindBy(xpath="//a[normalize-space()='My Leave']")
	 WebElement my_leave;
	@FindBy(xpath="//span[normalize-space()='Entitlements']")
	  WebElement entitlements;
	@FindBy(xpath="//span[normalize-space()='Reports']")
	 WebElement reports;
	@FindBy(xpath="//span[normalize-space()='Configure']")
	 WebElement configure;
	@FindBy(xpath="//a[normalize-space()='Leave List']")
	 WebElement leave_list;
	@FindBy(xpath="//a[normalize-space()='Assign Leave']")
	 WebElement assign_leave;
	
	@FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
	WebElement leave_type_dropdown ;
	@FindBy(xpath="//*[text()='CAN - Bereavement']")
	WebElement leave_type;
	@FindBy(xpath="(//input[@placeholder='yyyy-mm-dd'])[1]")
	WebElement from_date;
	@FindBy(xpath="//div[@class='oxd-form-row']//div[2]//div[1]//div[2]//div[1]//div[1]//input[1]")
	WebElement to_date;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]")
	WebElement partial_days_dropdown;
	@FindBy(xpath="//*[text()='All Days']")
	WebElement days;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]")
	WebElement duration_dropdown;
	@FindBy(xpath="//*[text()='Half Day - Morning']")
	WebElement duration;
	@FindBy(xpath="//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']")
	WebElement comments;
	@FindBy(xpath="//button[normalize-space()='Apply']")
	WebElement apply_;
	 WebDriver driver;
		 
	public LeavePage( WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginToSite(String validusername, String validpassword ) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		username.sendKeys(validusername);

		password.sendKeys(validpassword);

		loginbutton.click();
	}
	
	// moving to Leave
	public void leave() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		leave.click();
	}
	
	//let us check headings of page 
	public void checkOnLeavePageHeadings() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		apply.isDisplayed();
		my_leave.isDisplayed();
		entitlements.isDisplayed();	
		reports.isDisplayed();
		configure.isDisplayed();
		leave_list.isDisplayed();
		assign_leave.isDisplayed();
	}
	
	// let us check clicking operation
	public void clickOperationCheck() {	
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		apply.click();
		my_leave.click();
		entitlements.click();	
		reports.click();
		configure.click();
		leave_list.click();
		assign_leave.click();
		apply.click();
	}
	
	//let us fill data in apply field
	public void fillData() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		leave_type_dropdown.click();
		Actions act = new Actions(driver);
		act.moveToElement(leave_type).click().build().perform(); 
		from_date.sendKeys("2022-11-20");
		Thread.sleep(4000);
		to_date.sendKeys(Keys.CONTROL + "a");
		to_date.sendKeys(Keys.DELETE); 
		Thread.sleep(4000);
		to_date.sendKeys("2022-11-27");
		Thread.sleep(4000);
		
		
		act.moveToElement(partial_days_dropdown).click().build().perform();
		act.moveToElement(days).click().build().perform();
		duration_dropdown.click();
		act.moveToElement(duration).click().build().perform();
		comments.sendKeys("cgdyagfuhuf");
		apply_.click();
	}
}

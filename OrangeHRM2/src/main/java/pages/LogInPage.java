package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
	@FindBy(xpath="//input[@placeholder='Username']")
	  WebElement username;
	@FindBy(xpath="//input[@placeholder='Password']")
	  WebElement password;
	@FindBy(xpath="//button[normalize-space()='Login']")
	  WebElement loginbutton;
	@FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	  WebElement dropdown;
	@FindBy(xpath="//a[normalize-space()='Logout']")
	  WebElement logout;
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
	  WebElement errorMsg;
	 WebDriver driver;
	 public static String actualMsg;
	 
	public LogInPage( WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginToSite(String validusername, String validpassword ) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		username.sendKeys(validusername);

		password.sendKeys(validpassword);

		loginbutton.click();
			
	}
	
	public void logout() throws InterruptedException {
		Thread.sleep(4000);
        dropdown.click();		
		logout.click();
	}
	
	public void invalidUsernameLogin(String invalidusername, String validpassword) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		username.sendKeys(invalidusername);
		password.sendKeys(validpassword);
		loginbutton.click();
		 actualMsg=errorMsg.getText();
		
	}
	
	public void invalidPasswordLogin(String validusername, String invalidpassword) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		username.sendKeys(validusername);
		password.sendKeys(invalidpassword);
	    loginbutton.click();
	    actualMsg=errorMsg.getText();
	}
	
	public void invalidDataLogin(String invalidusername, String invalidpassword) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		username.sendKeys(invalidusername);
		password.sendKeys(invalidpassword);
	    loginbutton.click();
	    actualMsg=errorMsg.getText();
	}

}

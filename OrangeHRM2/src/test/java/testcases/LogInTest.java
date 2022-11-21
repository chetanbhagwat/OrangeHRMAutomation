package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import junit.framework.Assert;
import listeners.TestNGListeners;
import pages.LogInPage;
import utility.ExcelDataReader;

public class LogInTest extends TestNGListeners {
	@Test(priority=1)
	public void verifyPageTitleTest() throws IOException {
		Assert.assertEquals(lip.verifyPagetitle(), "OrangeHRM");
		test.info("Title of page received :"+lip.verifyPagetitle());
	}
	@Test(priority=0)
	public void validDataLogIn() throws IOException {
		test.info("Entering Credentials");
		lip.loginToSite(ExcelDataReader.readData("Orange HRM2 data", "Sheet1", 1, 1), 
				ExcelDataReader.readData("Orange HRM2 data", "Sheet1", 2, 1));
		test.info("Entered creds are: "+ExcelDataReader.readData("Orange HRM2 data","Sheet1",1,1)
		+" "+ExcelDataReader.readData("Orange HRM2 data","Sheet1",2,1));
	}
	
	@Test(priority=2)
	public void logout() throws InterruptedException {
		lip.logout();
	}
	
	@Test(priority=3)
	public void invalidUsernameLoginTest() throws IOException {
		test.info("Entering Credentials");
		lip.invalidUsernameLogin(ExcelDataReader.readData("Orange HRM2 data", "Sheet1", 3, 1), 
				ExcelDataReader.readData("Orange HRM2 data", "Sheet1", 2, 1));
		test.info("Entered creds are: "+ExcelDataReader.readData("Orange HRM2 data","Sheet1",3,1)
		+" "+ExcelDataReader.readData("Orange HRM2 data","Sheet1",2,1));
		
		Assert.assertEquals(LogInPage.actualMsg, "Invalid credentials");
		test.info("Error msg received :"+LogInPage.actualMsg);
	}

	@Test(priority=4)
	public void invalidPasswordLogInTest() throws IOException {
		test.info("Entering Credentials");
		lip.invalidPasswordLogin(ExcelDataReader.readData("Orange HRM2 data", "Sheet1", 1, 1), 
				ExcelDataReader.readData("Orange HRM2 data", "Sheet1", 4, 1));
		test.info("Entered creds are: "+ExcelDataReader.readData("Orange HRM2 data","Sheet1",1,1)
		+" "+ExcelDataReader.readData("Orange HRM2 data","Sheet1",4,1));
		
		Assert.assertEquals(LogInPage.actualMsg, "Invalid credentials");
		test.info("Error msg received :"+LogInPage.actualMsg);
	}
	
	@Test(priority=5)
	public void invalidDataLogInTest() throws IOException {
		test.info("Entering Credentials");
		lip.invalidDataLogin(ExcelDataReader.readData("Orange HRM2 data", "Sheet1", 3, 1), 
				ExcelDataReader.readData("Orange HRM2 data", "Sheet1", 4, 1));
		test.info("Entered creds are: "+ExcelDataReader.readData("Orange HRM2 data","Sheet1",3,1)
		+" "+ExcelDataReader.readData("Orange HRM2 data","Sheet1",4,1));
		
		Assert.assertEquals(LogInPage.actualMsg, "Invalid credentials");
		test.info("Error msg received :"+LogInPage.actualMsg);
	}


}

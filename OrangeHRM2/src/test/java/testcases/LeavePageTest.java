package testcases;

import java.io.IOException;
import org.testng.annotations.Test;

import listeners.TestNGListeners;
import utility.ExcelDataReader;

public class LeavePageTest extends TestNGListeners{
	@Test(priority=0)
	public void validDataLogIn() throws IOException {
		test.info("Entering Credentials");
		lip.loginToSite(ExcelDataReader.readData("Orange HRM2 data", "Sheet1", 1, 1), 
				ExcelDataReader.readData("Orange HRM2 data", "Sheet1", 2, 1));
		test.info("Entered creds are: "+ExcelDataReader.readData("Orange HRM2 data","Sheet1",1,1)
		+" "+ExcelDataReader.readData("Orange HRM2 data","Sheet1",2,1));
	}
	@Test(priority=1)
	public void leave() {
		leavepage.leave();
		test.info("Successfuly launched Leave Page");
		
	}
	
	@Test(priority=2)
	public void checkOnLeavePageHeadingsTest() {
		leavepage.checkOnLeavePageHeadings();
		test.info("Apply is displayed");
		test.info("My Leave is displayed");
		test.info("Entitlements is displayed");
		test.info("Reports is displayed");
		test.info("Configure is displayed");
		test.info("Leave List is displayed");
		test.info("Assign Leave displayed");
	}
	
	@Test(priority=3)
	public void clickOperationCheckTest() {	
		leavepage.clickOperationCheck();
		test.info("Apply is clickable");
		test.info("My Leave is clickable");
		test.info("Entitlements is clickable");
		test.info("Reports is clickable");
		test.info("Configure is clickable");
		test.info("Leave List is clickable");
		test.info("Assign Leave is clickable");
	}
	
	@Test(priority=4)
	public void fillDataTest() throws InterruptedException {
		
		leavepage.fillData();
		test.info("Data filled properly");
	}
	
	
}

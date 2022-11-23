package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import listeners.TestNGListeners;
import utility.ExcelDataReader;


public class DashboardPageTest extends TestNGListeners {
	@Test(priority=0)
	public void validDataLogIn() throws IOException {
		test.info("Entering Credentials");
		dbp.loginToSite(ExcelDataReader.readData("Orange HRM2 data", "Sheet1", 1, 1), 
				ExcelDataReader.readData("Orange HRM2 data", "Sheet1", 2, 1));
		test.info("Entered creds are: "+ExcelDataReader.readData("Orange HRM2 data","Sheet1",1,1)
		+"   "+ExcelDataReader.readData("Orange HRM2 data","Sheet1",2,1));
	}
	@Test(priority=1)
	public void checkForHeadingsTest() {
		dbp.checkOnHeadings();
		test.info("Dashboard is displayed");
		test.info("My Actions is displayed");
		test.info("Time at Work is displayed");
		test.info("Quick Launch is displayed");
		test.info("Employees on Leave Today is displayed");
		test.info("Employee Distribution by Sub Unit is displayed");
		test.info("Employee Distribution by Location is displayed");
		
	}
	
	@Test(priority=2)
	public void myActionsClickablesTest()
	{
		dbp.myActionsClickables();
		test.info("Timesheets to Approve is clickable");
		test.info("Pending Self Review is clickable");
		test.info("Candidate to Interview is clickable");
		
	}
	
	@Test(priority=3)
	public void quickLaunchClickablesTest()
	{
		dbp.quickLaunchClickables();
		test.info("Assign Leave is clickable");
		test.info("Leave list is clickable");
		test.info("Timesheets is clickable");
		test.info("Apply Leave is clickable");
		test.info("My Leave list is clickable");
		test.info("My Timesheet is clickable");
		
	}
}

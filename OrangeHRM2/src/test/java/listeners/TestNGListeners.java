package listeners;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testcases.BaseTest;
import utility.Screenshot;

public class TestNGListeners extends BaseTest implements ITestListener{
	
	ExtentReports extent = ExtentReportGen.extentReportGenerator();
	public static ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Testing get started on method "+result.getName());
		test = extent.createTest(result.getName());
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case is successfully executed for "+ result.getMethod().getMethodName());
		test.log(Status.PASS, "Test case is passed");
	}
	@Override
	public void onTestFailure(ITestResult result) 
	{
		test.fail(result.getThrowable());
	try
	{
	//	TakeScreenShot.captureScreenshotWithPath(driver, result.getName());
		test.addScreenCaptureFromPath(Screenshot.captureScreenshotWithPath(driver, result.getName()));
	}
	catch(Exception e)
	{
		System.out.println("Screen shot is available for fail test cases");
	}
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case :"+result.getMethod().getMethodName()+" has been  skipped");	
		test.log(Status.SKIP, "Test case got skipped");
	}
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Testing get finished on method "+ context.getName());
		extent.flush();
	}
	
}

package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportGen {
	
	public static ExtentReports extent;
	
	public static ExtentReports extentReportGenerator()
	{
		String path = System.getProperty("user.dir")+"\\reports\\orangehrm.html";
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);
		
		reporter.config().setTheme(Theme.DARK);
		
		reporter.config().setReportName("OrangeHRM Project Report");
		
		extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Project Name", "OrangeHRM");
		
		extent.setSystemInfo("Executed By", "Chetan Bhagwat");
		
		extent.setSystemInfo("Environment Used","Staging");
		
		return extent;
		
	}

}

package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


import pages.DashboardPage;
import pages.LogInPage;
import utility.ExcelDataReader;

public class BaseTest {
	public static WebDriver driver;
	public LogInPage lip;
	public DashboardPage dbp;
@BeforeSuite
public void initBrowser() throws IOException
{
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(ExcelDataReader.readData("Orange HRM2 data", "Sheet1", 0, 1));
	}
@BeforeClass
public void createObject()
{
	lip = new LogInPage(driver);
	dbp = new DashboardPage(driver);
}
}

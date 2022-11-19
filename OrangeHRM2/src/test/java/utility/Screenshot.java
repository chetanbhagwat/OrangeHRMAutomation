package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
	static TakesScreenshot ts;
	public static String captureScreenshotWithPath(WebDriver driver, String filename) throws IOException {
		ts = (TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String path =System.getProperty("user.dir")+"\\CapturedScreenshots\\"+filename+".png";
		File destination =new File(path);
		FileHandler.copy(source, destination);
		return path;
	}
}

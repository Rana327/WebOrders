package utilities;


import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import framework.testBase;
public class screenshots extends testBase {

	public static void screen(int i) throws IOException
	{
		
		TakesScreenshot ts = ((TakesScreenshot)driver);
		File picture = ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(picture, new File("./Screenshots/"+i+".png"));
	
	}

	
	
	

	
}

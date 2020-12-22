package framework;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
public class testBase {
  
	public static WebDriver driver;
    public static ChromeOptions chromeOptions;
	public static void initialization() throws MalformedURLException
	{
		  String strbrowser = readData().getProperty("executionPlatform");
	//	String strExecutionPlatform  = System.getProperty("executionPlatform").trim().toUpperCase();
		switch(strbrowser)
	  {
		case "LOCAL_CHROME":
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\837311\\Downloads\\webordersUpdated\\WebOrders\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			break; //.\\drivers\\chromedriver.exe
		}
		case "LOCAL_IE":
		{
			System.setProperty("webdriver.ie.driver","C:\\Users\\837311\\Downloads\\webordersUpdated\\WebOrders\\drivers\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			break;
		}
		case "GRID_CHROME":
		{
			 URL gridUrl = new URL("http://localhost:4444/wd/hub");
             DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
             chromeOptions = new ChromeOptions();
             desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
             driver= new RemoteWebDriver(gridUrl,desiredCapabilities);
             break;
		}
		case "GRID_IE":
		{
			 URL gridUrl = new URL("http://localhost:4444/wd/hub");
             DesiredCapabilities desiredCapabilities = DesiredCapabilities.internetExplorer();
             driver= new RemoteWebDriver(gridUrl,desiredCapabilities);
             break;
		}
		case "AWS_CHROME":
		{
			System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
			driver=new ChromeDriver();
			break;
		}
		case "AWS_FIREFOX":
		{
			   System.setProperty("webdriver.gecko.driver","/usr/bin/geckodriver");
               driver = new FirefoxDriver();
               break;
		}
		/* case "AWS_DEVICEFARM_CHROME":
		 {	 
             testGridUrl = getTestGridUrl();
             DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
             chromeOptions = new ChromeOptions();
             //chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
             desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
             driver = new RemoteWebDriver(testGridUrl, desiredCapabilities);
             break;
		 }   
		  case "AWS_DEVICEFARM_FIREFOX":
		  {
              testGridUrl = getTestGridUrl();
              driver = new RemoteWebDriver(testGridUrl, DesiredCapabilities.firefox());
              ExtentCucumberAdapter.addTestStepLog(strExecutionPlatform + " Driver Creation Completed");
              break;
		  }
          case "AWS_FARGATE":
          {	  
              DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
              ChromeOptions chromeOpt = new ChromeOptions();
              chromeCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOpt);
              driver = new RemoteWebDriver(new URL("http://3.19.74.252:4444/wd/hub"), chromeCapabilities);
              ExtentCucumberAdapter.addTestStepLog(strExecutionPlatform + " Driver Creation Completed");
              break;
          }*/
		default:
		{

			System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			break;
		}
	  }
	    driver.get(" http://downloads.smartbear.com/samples/TestComplete10/WebOrders/Login.aspx");
        driver.manage().window().maximize();
	}
	   
	 public static Properties readData()
	 {
	        Properties objProp = new Properties();
	        try {
	            String env = System.getProperty("env");
	            File file = new File("TestSettings.properties");
	            FileInputStream fileInput = null;
	            fileInput = new FileInputStream(file);
	            objProp.load(fileInput);
	             }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	        return objProp;
	 }
	 
	/* public static URL getTestGridUrl() {
	        String strAWSprojectArn = readData().getProperty("AWSprojectArn");
	        System.out.println("eeee:" + strAWSprojectArn);
	        DeviceFarmClient client = DeviceFarmClient.builder().region(Region.US_WEST_2).build();
	        CreateTestGridUrlRequest request = CreateTestGridUrlRequest.builder()
	                .expiresInSeconds(300) // 5 minutes
	                .projectArn(strAWSprojectArn)
	                .build();
	        URL testGridUrl = null;
	        try {
	            CreateTestGridUrlResponse response = client.createTestGridUrl(request);
	            testGridUrl = new URL(response.url());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        System.out.println("testGridUrl: " + testGridUrl);
	        return testGridUrl; 
	        }*/
	public static void closingDriver()
	 {
		driver.close();
	 }
}


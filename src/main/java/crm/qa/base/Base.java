package crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import crm.qa.utils.TestUtils;

public class Base {
	
	public static WebDriver driver;
	public static Properties prop;
	//public static EventFiringWebDriver edriver;
	
public Base() throws IOException
{
	try
	{
		prop=new Properties();
		FileInputStream fis= new FileInputStream("E:\\selenium\\project\\Opps\\FreeCRMTest\\src\\main\\java\\crm\\qa\\configs\\config.properties");
	prop.load(fis);
	}
	catch(FileNotFoundException e)
	{
		e.printStackTrace();
	}catch(IOException f)
	{
		f.printStackTrace();
	}
}	
	
	@SuppressWarnings("deprecation")
	public static void initialiazation()
	{
		String browsername=prop.getProperty("browser");
		
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","E:\\selenium\\project\\Opps\\FreeCRMTest\\drivers\\chromedriver.exe");
			driver =new ChromeDriver(); 
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
					
		
		
	}
}


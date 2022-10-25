package crm.qa.testcases;

import java.io.IOException;

import org.apache.logging.log4j.core.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import crm.qa.base.Base;
import crm.qa.pages.LoginPage;

public class LoginPageTC extends Base{
	LoginPage lp;
	//Logger log=Logger.getLogger(LoginPageTC.class);

	public LoginPageTC() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void setup() throws IOException
	{
		initialiazation();
		lp=new LoginPage();
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

	
	@Test
	public void validateLogin() throws InterruptedException, IOException
	{
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
	Thread.sleep(2000);
	}
}

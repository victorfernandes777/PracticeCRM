package crm.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import crm.qa.base.Base;
import crm.qa.pages.ContactsPage;
import crm.qa.pages.HomePage;
import crm.qa.pages.LoginPage;

public class HomePageTC extends Base{

	LoginPage lp;
	HomePage home;
	ContactsPage cp;
	public HomePageTC() throws IOException
	{
		super();
	}

	
	@BeforeMethod
	public void setup() throws IOException
	{
		initialiazation();
		 lp=new LoginPage();
		home=lp.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test
	public void testlogout() throws IOException, InterruptedException
	{   home=new HomePage();
		driver.switchTo().frame("mainpanel");
		home.verifyLogoutTC();
	}
	
	@Test
	public void createcontact() throws IOException, InterruptedException
	{   home=new HomePage();
	   cp=new ContactsPage();
		driver.switchTo().frame("mainpanel");
		home.ClickonNewContactMenu();
		cp.createContact("Rey","Meysterio");
		
	}
	
	@AfterMethod
	public void tear()
	{
		driver.quit();
	}
}

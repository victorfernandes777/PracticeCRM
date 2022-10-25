
package crm.qa.testcases;

import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import crm.qa.base.Base;
import crm.qa.pages.ContactsPage;
import crm.qa.pages.HomePage;
import crm.qa.pages.LoginPage;
import crm.qa.utils.TestUtils;

public class ContactsPageTC extends Base{

	LoginPage lp;
	HomePage home;
	ContactsPage cp;
	String sheet="contact";
	public ContactsPageTC() throws IOException
	{
		super();
	}

	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException
	{
		initialiazation();
		lp=new LoginPage();
		cp=new ContactsPage();
		home=lp.login(prop.getProperty("username"), prop.getProperty("password"));
		driver.switchTo().frame("mainpanel");
		cp=home.ClickonNewContactMenu();
	}
	
	@DataProvider
	public Object[][] getcontactData()
	{
		Object data[][]=TestUtils.getTestData(sheet);
		return data;
		
	}
	
	@Test(dataProvider="getcontactData")
	public void createcontact(String f,String l) throws IOException, InterruptedException
	{   
	   	cp=new ContactsPage();
		cp.createContact(f,l);
		
	}
	
	@AfterMethod
	public void tear()
	{
		driver.quit();
	}
}


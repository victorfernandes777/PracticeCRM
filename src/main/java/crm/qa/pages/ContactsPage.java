
package crm.qa.pages;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import crm.qa.base.Base;

public class ContactsPage extends Base{
	
	@FindBy(xpath="//tbody/tr/td[4]/a[1]")
	WebElement logout;
	
	@FindBy(id="first_name")
	WebElement first_name;
	
	@FindBy(id="surname")
	WebElement surname;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement Save;

	
	public ContactsPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	

	public void createContact(String Fn,String Ln)throws IOException, InterruptedException
	{
		first_name.sendKeys(Fn);
		surname.sendKeys(Ln);
		Save.click();
		
	}

	
}

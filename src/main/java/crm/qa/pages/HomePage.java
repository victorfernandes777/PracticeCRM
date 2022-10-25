package crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.qa.base.Base;

public class HomePage extends Base{
	
	@FindBy(xpath="//tbody/tr/td[4]/a[1]")
	WebElement logout;
	
	@FindBy(xpath="//a[normalize-space()='New Contact']")
	WebElement newcontactmenu;
	
	@FindBy(xpath="//a[normalize-space()='Contacts']")
	WebElement contact;
	
	//a[normalize-space()='Contacts']
	
	public HomePage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage verifyLogoutTC() throws IOException, InterruptedException
	{
		
		//Thread.sleep(2000);
		logout.click();
		return new LoginPage();
	}

	public ContactsPage ClickonNewContactMenu() throws InterruptedException, IOException
	{
		Actions action=new Actions(driver);
		action.moveToElement(contact).build().perform();
		Thread.sleep(2000);
		newcontactmenu.click();
		return new ContactsPage();
		
	}
	
}

package crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.qa.base.Base;

public class LoginPage extends Base{

	public LoginPage() throws IOException {
		//super();
		
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	//////////Page Factory
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement login;
	
	/////////Actions
	public String validateTitle()
	{
       return driver.getTitle();
	}
	
	public HomePage login(String un,String pwd) throws IOException
	{
       username.sendKeys(un);
       password.sendKeys(pwd);
       login.click();
       return new HomePage();
	}
	
	
	}
	


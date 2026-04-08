package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class LoginPage extends BasePage{

	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//h2[text()='Login to your account']")
	private WebElement loginHeader;
	
	@FindBy(xpath="//div[@class='login-form']//*[@name='email']")
	private WebElement loginEmail;
	
	@FindBy(xpath="//div[@class='login-form']//*[@name='password']")
	private WebElement loginPassword;
	
	@FindBy(xpath="//button[text()='Login']")
	private WebElement loginBtn;
	
	public boolean isLoginPageVisible() {
		 return isVisible(loginHeader);
	}
	
	public void login(String email, String pass) {
		type(loginEmail,email);
		type(loginPassword,pass);
		click(loginBtn);
	}
	
	
	  @FindBy(xpath = "//h2[text()='New User Signup!']") public WebElement
	  signupHeader;
	  
	  @FindBy(xpath="//div[@class='signup-form']//*[@name='name']") public
	  WebElement signupName;
	  
	  @FindBy(xpath="//div[@class='signup-form']//*[@name='email']") public
	  WebElement signupEmail;
	  
	  @FindBy(xpath="//button[text()='Signup']") WebElement SignupBtn;
	  
	  public boolean isSignupVisible() {
			 return isVisible(signupHeader);
		}
	    
	  public void signup(String name, String email) {
		  type(signupName,name);
		  type(signupEmail,email);
		  click(SignupBtn); 
		  }
}

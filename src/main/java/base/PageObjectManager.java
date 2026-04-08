package base;

import driver.DriverManager;
import pages.AccountPage;
import pages.DeleteAccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

public class PageObjectManager{
	
	  public HomePage getHomePage() {
	        return new HomePage(DriverManager.getDriver());
	    }

	    public LoginPage getLoginPage() {
	        return new LoginPage(DriverManager.getDriver());
	    }

	    public RegisterPage getRegisterPage() {
	        return new RegisterPage(DriverManager.getDriver());
	    }

	    public AccountPage getAccountPage() {
	        return new AccountPage(DriverManager.getDriver());
	    }

	    public DeleteAccountPage getDeletePage() {
	        return new DeleteAccountPage(DriverManager.getDriver());
	    }
}

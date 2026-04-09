package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import driver.DriverManager;
import pages.AccountPage;
import pages.DeleteAccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

public class PageObjectManager{
	
	private HomePage homePage;
    private LoginPage loginPage;
    private AccountPage accountPage;
    private DeleteAccountPage deletePage;
    private RegisterPage registerPage;
    protected final Logger log = LogManager.getLogger(this.getClass());
    
    public HomePage getHomePage() {
        if (homePage == null) homePage = new HomePage(DriverManager.getDriver());
        return homePage;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) loginPage = new LoginPage(DriverManager.getDriver());
        return loginPage;
    }

    public AccountPage getAccountPage() {
        if (accountPage == null) accountPage = new AccountPage(DriverManager.getDriver());
        return accountPage;
    }

    public DeleteAccountPage getDeletePage() {
        if (deletePage == null) deletePage = new DeleteAccountPage(DriverManager.getDriver());
        return deletePage;
    }
    
    public RegisterPage getRegisterPage() {
        if (registerPage == null) registerPage = new RegisterPage(DriverManager.getDriver());
        return registerPage;
    }
}

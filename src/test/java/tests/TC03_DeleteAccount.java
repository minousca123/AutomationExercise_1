package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.ConfigReader;

@Test
public class TC03_DeleteAccount extends BaseTest {

	public void deleteAccount() {
		   String email = ConfigReader.get("email");
	        String password = ConfigReader.get("password");
	        
		Assert.assertTrue(pom.getHomePage().isHomePageVisible(), "Home gage not visible");
		pom.getHomePage().clickSignUpLoginLink();

		Assert.assertTrue(pom.getLoginPage().isLoginPageVisible(), "Login page not visible");
		pom.getLoginPage().login(email,password);

		Assert.assertTrue(pom.getAccountPage().isUserLoggedIn(), "Login Failed");
		pom.getAccountPage().clickDeleteAccount();

		Assert.assertTrue(pom.getDeletePage().isAccountDeleted(), "Account not deleted");
		pom.getDeletePage().clickContinueBtn();
		
	}

}

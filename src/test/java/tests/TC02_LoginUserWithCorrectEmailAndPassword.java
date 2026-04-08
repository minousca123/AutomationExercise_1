package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.ConfigReader;

public class TC02_LoginUserWithCorrectEmailAndPassword extends BaseTest{
    
	@Test
	public void testLoginAndDeleteAccount() {
		String email = ConfigReader.get("email");
	    String password = ConfigReader.get("password");
		
		Assert.assertTrue(pom.getHomePage().isHomePageVisible(), "Home gage not visible");
		pom.getHomePage().clickSignUpLoginLink();
		
		Assert.assertTrue(pom.getLoginPage().isLoginPageVisible(), "Login page not visible");
		pom.getLoginPage().login(email,password);		
	}
}

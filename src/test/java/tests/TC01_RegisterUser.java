package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.ConfigReader;

public class TC01_RegisterUser extends BaseTest {

	@Test
	public void registerUser() throws InterruptedException {

	//	String email = "test" + System.currentTimeMillis() + "@mail.com";
		String email = ConfigReader.get("email");
		String fname = ConfigReader.get("fname");
		String password = ConfigReader.get("password");
		String lname = ConfigReader.get("lname");

		Assert.assertTrue(pom.getHomePage().isHomePageVisible(), "Home page not visible");
		pom.getHomePage().clickSignUpLoginLink();

		Assert.assertTrue(pom.getLoginPage().isSignupVisible(), "Signup not visible");
		pom.getLoginPage().signup(fname, email);

		Assert.assertTrue(pom.getRegisterPage().isAccountInfoVisible(), "Account Info not visible");
		Assert.assertEquals(pom.getRegisterPage().getEnteredName(), fname);
		Assert.assertEquals(pom.getRegisterPage().getEnteredEmail(), email);

		pom.getRegisterPage().fillAccountDetails(password, fname, lname);
		pom.getRegisterPage().clickCreateAccount();
		Assert.assertTrue(pom.getRegisterPage().isAccountCreated(), "Account not created");
		pom.getRegisterPage().clickContinue();
		Assert.assertTrue(pom.getAccountPage().isUserLoggedIn(), "User not logged in");

	}
}

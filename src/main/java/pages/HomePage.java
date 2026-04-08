package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//img")
    WebElement homePageBanner;

	@FindBy(xpath = "//a[@href='/login']")
	WebElement signupLoginLink;

    public boolean isHomePageVisible() {
        return isVisible(homePageBanner);
    }
	
	public void clickSignUpLoginLink() {
		click(signupLoginLink);
	}

}

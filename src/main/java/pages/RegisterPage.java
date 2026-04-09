package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class RegisterPage extends BasePage{
	
	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//b[text()='Enter Account Information']") WebElement registerHeader;
	@FindBy(xpath = "//input[@id='id_gender1']") WebElement titleMr;
	@FindBy(id = "id_gender2") WebElement titleMrs;
	@FindBy(id = "name") WebElement name;
	@FindBy(id = "email") WebElement email;
	@FindBy(id = "password") WebElement password;
	@FindBy(id = "days") WebElement day;
	@FindBy(id = "months") WebElement month;
	@FindBy(id = "years") WebElement year;
	@FindBy(id = "newsletter") WebElement newsletter;
	@FindBy(id = "optin") WebElement offers;
	@FindBy(id = "first_name") WebElement firstName;
	@FindBy(id = "last_name") WebElement lastName;
	@FindBy(id = "company") WebElement company;
	@FindBy(id = "address1") WebElement address1;
	@FindBy(id = "address2") WebElement address2;
	@FindBy(id = "country") WebElement country;
	@FindBy(id = "state") WebElement state;
	@FindBy(id = "city") WebElement city;
	@FindBy(id = "zipcode") WebElement zipcode;
	@FindBy(id = "mobile_number") WebElement mobile_number;
	@FindBy(xpath = "//button[text()='Create Account']") WebElement createAccountBtn;
	
	@FindBy(xpath = "//b[text()='Account Created!']") WebElement accountCreatedHeader;
	@FindBy(xpath = "//a[text()='Continue']") WebElement continueBtn;
	
	
	public boolean isAccountInfoVisible() {
		return registerHeader.isDisplayed();
	}
	
	public String getEnteredName() {
	    return getValue(name);
	}

	public String getEnteredEmail() {
	    return getValue(email);
	}
	
	public void fillAccountDetails(String passwordValue, String first, String last) {
		log.info("Fill in Account Information");
		click(titleMrs);
		type(password, passwordValue);
		
		selectDropdown(day,"Value","10");
		selectDropdown(month,"text","May");
		selectDropdown(year,"value","1980");

        click(newsletter);
        click(offers);

        type(firstName, first);
        type(lastName, last);
        type(company, "QA Corp");
        type(address1, "Abu Dhabi");
        type(state, "UAE");
        type(city, "Abu Dhabi");
        type(zipcode, "00000");
        type(mobile_number, "1234567890");
    }

	public void clickCreateAccount() {
		click(createAccountBtn);
    }
	
	public boolean isAccountCreated() {
		return isVisible(accountCreatedHeader, "Account Created Header");
	}
	
	public void clickContinue() {
		click(continueBtn);
    }

}

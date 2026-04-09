package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class DeleteAccountPage extends BasePage{

	public DeleteAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//b[text()='Account Deleted!']")
	WebElement deleteMsg;
	
	@FindBy(xpath="//a[text()='Continue']")
	WebElement continueBtn;
	
    public boolean isAccountDeleted() {
    	return isVisible(deleteMsg, "Account Deleted!");
      
    }
    
    public void clickContinueBtn() {
    	click(continueBtn);
    }

}

package finalexam;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends baseDP {
	@FindBy(xpath="//h1[normalize-space()='Welcome, Please Sign In!']")
	@CacheLookup
	private WebElement banner;
	
	public SignInPage(){
		PageFactory.initElements(getDriver(), this);
	}

	public boolean bannervalidation() {
		String expectedText = "Welcome, Please Sign In!";
		String actualText = banner.getText().trim();
		return actualText.equals(expectedText);
	}
	
}

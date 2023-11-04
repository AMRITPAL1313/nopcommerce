package finalexam;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClothingPage extends baseDP {

	@FindBy(xpath="//div[@class='picture']//img[@title='Show details for Custom T-Shirt']")
	@CacheLookup
	private WebElement ctsimage;
	
	public ClothingPage (){
		PageFactory.initElements(getDriver(), this);
	}

	public TShirtPage clickCTS() {
		ctsimage.click();
		return new TShirtPage();
	}
}


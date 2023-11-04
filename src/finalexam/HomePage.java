package finalexam;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends baseDP{
	@FindBy(xpath="//ul[@class='top-menu notmobile']//a[normalize-space()='Apparel']")
	@CacheLookup
	private WebElement apptab;
	
	@FindBy(xpath="//ul[@class='top-menu notmobile']//a[normalize-space()='Clothing']")
	@CacheLookup
	private WebElement clotab;
	
	
	public HomePage(){
		PageFactory.initElements(getDriver(), this);
	}

	public ClothingPage hoverApparelTab() throws InterruptedException {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(apptab).perform();
        Thread.sleep(3000);
        clotab.click();
        return new ClothingPage();
    }
	
}


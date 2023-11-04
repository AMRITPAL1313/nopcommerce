package finalexam;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestShopping extends baseDP{
	private String url = "https://demo.nopcommerce.com/";
	private HomePage hp;
	private ClothingPage cp;
	private TShirtPage tsp;
	private ShopCartPage scp;
	private SignInPage sip;
	
	
	@BeforeClass
	public void testbaseSetup() throws InterruptedException {
		 baseSetup("firefox", url);
		  hp = new HomePage();
		}
	
	@Test(priority=0)
	public void hover() throws InterruptedException {
		cp = hp.hoverApparelTab();
	}
	@Test(priority=1)
	public void clickimage() {
		tsp = cp.clickCTS();
	}
	
	@Test(priority=2)
	public void writetext() {
		tsp.writetxt("puma");
	}

	@Test(priority=3)
	public void shopcart() throws InterruptedException {
		scp = tsp.clickSC();
	}
	
	@Test(priority = 4)
	public void displaytotal() {
	    ShopCartPage scp = new ShopCartPage();
	    String totboxText = scp.getTotboxText();
	    System.out.println("Shopping Spree Total: " + totboxText);
	}
	
	@Test(priority=5)
	public void gotocheckout() throws InterruptedException {
		sip = scp.checkout();
	}
	
	@Test(priority=6)
	public void validatetext() {
		SignInPage sip = new SignInPage();
        boolean isCorrect = sip.bannervalidation();
        if (isCorrect) {
            System.out.println("Logotext is correct: Welcome, Please Sign In!");
        } else {
            System.out.println("Logo text is not correct");
        }

        Assert.assertTrue(isCorrect, "Logo text is not correct: Welcome, Please Sign In!");
	}

	@AfterClass
	public void tearDown() {
	    getDriver().quit();
	}
}


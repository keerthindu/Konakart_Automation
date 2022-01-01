package KonaKart_Tests;

import KonaKart_Pages.AddCartPage;
import KonaKart_Pages.GamePage;
import KonaKart_Pages.HomePage;
import Utilities.readConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05_AddFirstItemsToCart extends BaseClass {

    private static final Logger log = LogManager.getLogger("TC05_AddFirstItemToCart");

    readConfig readconf = new readConfig();

    @Test
    public void AddItemsToCart() throws Exception {
        driver.get(baseUrl);
        driver.manage().window().maximize();
        Assert.assertEquals("KonaKart", driver.getTitle(),"KonaKart Home Page Title is mismatched");
        log.info("KonaKart Home Page Opened successfully");

        HomePage homePage = new HomePage(driver);
        homePage.selectGame();
        log.info("Game catagory has selected from the product dropdown");

        GamePage gamePage = new GamePage(driver);
        String productBeforeadd = gamePage.FirstItemnameBeforeadd();

        AddCartPage addCartPage = new AddCartPage(driver);
        //select last item with 1 quantity
        addCartPage.AddlastItem();
        log.info("Added the last product with 1 Quantity to the cart");
        //select first item with 2 Quantity
        addCartPage.addFirstItemToCart();
        log.info("Added first product with 2 Quantity to the cart");

       // Verify that the game has 4 screenshots
        Assert.assertEquals(addCartPage.Verify4Screenshots(),readconf.screenshotCount());
        Thread.sleep(5000);
        log.info("Product has 4 Screenshots ");

        //Verify that the game name is the same as the one you clicked
        Assert.assertEquals(productBeforeadd,gamePage.FirstItemnameAfteradd(),"Game name is not the same as the one you clicked");
        Thread.sleep(5000);
        log.info("Verified the game name is the same as the one you clicked");

        //Add the game to the cart and verify item added
        addCartPage.verifyBasketItems();
        Assert.assertEquals(addCartPage.verifyBasketItems(),readconf.FinalBasketCount());
        log.info("Verified final cart count");
        captureScreenshot(driver,"TC05_AddFirstItemsToCart");

    }
}

package KonaKart_Tests;

import KonaKart_Pages.AddCartPage;
import KonaKart_Pages.GamePage;
import KonaKart_Pages.HomePage;
import KonaKart_Pages.ShoppingCartPage;
import Utilities.loggerClass;
import Utilities.readConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06_OpenShopCart extends BaseClass {

    private static final Logger log = LogManager.getLogger("TC06_OpenShopCart");

    readConfig readconf = new readConfig();

    @Test
    public void VerifyShopCart() throws Exception {

        driver.get(baseUrl);
        driver.manage().window().maximize();
        Assert.assertEquals("KonaKart", driver.getTitle(),"KonaKart Home Page Title is mismatched");
        log.info("KonaKart Home Page Opened successfully");

        HomePage homePage = new HomePage(driver);
        homePage.selectGame();
        log.info("Game catagory has selected from the product dropdown");

        GamePage gamePage = new GamePage(driver);
        String productBeforeadd = gamePage.FirstItemnameBeforeadd();
        String Last_productBeforeadd = gamePage.LastItemnameBeforeadd();

        AddCartPage addCartPage = new AddCartPage(driver);
        //select last item with 1 quantity
        addCartPage.AddlastItem();
        log.info("Added the last product with 1 Quantity to the cart");

        //select first item with 2 Quantity
        addCartPage.addFirstItemToCart();
        log.info("Added first product with 2 Quantity to the cart");

        // Verify that the game has 4 screenshots
        // addCartPage.Verify4Screenshots();
        Assert.assertEquals(addCartPage.Verify4Screenshots(), readconf.screenshotCount());
        Thread.sleep(5000);
        log.info("Product has 4 Screenshots ");

        //Verify that the game name is the same as the one you clicked
        Assert.assertEquals(productBeforeadd, gamePage.FirstItemnameAfteradd(), "Game name is not the same as the one you clicked");
        log.info("Verified the game name is the same as the one you clicked");

        //Add the game to the cart and verify item added
        addCartPage.verifyBasketItems();
        Assert.assertEquals(addCartPage.verifyBasketItems(), readconf.FinalBasketCount());
        log.info("Verified final cart count");

        //Verify that the added items there
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.openShopCart();
        Assert.assertEquals(shoppingCartPage.verifyAddeditemOne(),productBeforeadd);
        Thread.sleep(3000);
        Assert.assertEquals(shoppingCartPage.verifyAddeditemTwo(),Last_productBeforeadd);
        log.info("Verified that the items are added");

        //Verify subtotal is the total price of the added items
        shoppingCartPage.verifySubTotal();
        log.info("Verified Subtotal is the total price of the added items");

        captureScreenshot(driver,"TC06_OpenShopCart");


    }
}

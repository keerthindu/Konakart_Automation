package KonaKart_Tests;

import KonaKart_Pages.AddCartPage;
import KonaKart_Pages.GamePage;
import KonaKart_Pages.HomePage;
import Utilities.readConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04_AddLastToCart extends BaseClass {
    private static final Logger log = LogManager.getLogger("TC04_AddLastToCart");

    readConfig readconf = new readConfig();





    @Test
    public void AddLastoneToCart() throws Exception {
        driver.get(baseUrl);
        driver.manage().window().maximize();
        Assert.assertEquals("KonaKart", driver.getTitle(),"KonaKart Home Page Title is mismatched");
        log.info("KonaKart Home Page Opened successfully");

        HomePage homePage = new HomePage(driver);
        homePage.selectGame();
        log.info("Game catagory has selected from the product dropdown");

        GamePage gamePage = new GamePage(driver);
        gamePage.filterprize();
        gamePage.filtervalue();
        log.info("Filtered price range from 39$ to 80$ is applied");

        AddCartPage addCartPage = new AddCartPage(driver);
        //select last item with 1 quantity
        addCartPage.AddlastItem();
        log.info("Added the last product with 1 Quantity to the cart");
        Assert.assertEquals(addCartPage.verifyCartCount(),readconf.getCartCount(), "Cart count is mismatched");
        log.info("Verified the item added in the cart without opening the cart page");
        captureScreenshot(driver,"TC04_AddLastToCart");

    }
}

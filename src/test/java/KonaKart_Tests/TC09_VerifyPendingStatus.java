package KonaKart_Tests;

import KonaKart_Pages.*;
import Utilities.readConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09_VerifyPendingStatus extends BaseClass {

    private static final Logger log = LogManager.getLogger("TC09_VerifyPendingStatus");

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
        Assert.assertEquals(shoppingCartPage.verifyAddeditemOne(), productBeforeadd);
        Assert.assertEquals(shoppingCartPage.verifyAddeditemTwo(), Last_productBeforeadd);
        log.info("Verified that the items are added");

        //Verify subtotal is the total price of the added items
        shoppingCartPage.verifySubTotal();
        log.info("Verified Subtotal is the total price of the added items");

        //Proceed to checkout as a guest
        shoppingCartPage.proceedCheckout();
        log.info("Clicked on Checkout button");
        shoppingCartPage.registerAccount();
        log.info("Clicked on Register Account");

        //Fill the data  (Unable to procceed with guest hence created new account)
        NewRegisterPage newRegisterPage = new NewRegisterPage(driver);
        newRegisterPage.fillData();
        log.info("Register form filled successfully and Address Confirmed");

        //click on Confirm order
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        orderConfirmationPage.confirmOrder();
        log.info("Clicked on Order confirmation button");

        //Click on Confirm checkout
        CheckoutConfirmationPage checkoutConfirmationPage = new CheckoutConfirmationPage(driver);
        checkoutConfirmationPage.confirmCheckout();
        log.info("Clicked on Confirm checkout button");

        //click on final continue button
        checkoutConfirmationPage.clickContinue();
        captureScreenshot(driver, "TC08_ConfirmOrder");

        //Verify that the order status is pending ins “My account” page
        checkoutConfirmationPage.verifyPending();
        Assert.assertEquals(checkoutConfirmationPage.verifyTitle(),readconf.title());
        log.info("My Account Page Title Verified");
        Assert.assertEquals(checkoutConfirmationPage.verifyPending(),readconf.status());
        log.info(" Item status is Pending");
        captureScreenshot(driver,"TC09_Pending status captured");


    }
}

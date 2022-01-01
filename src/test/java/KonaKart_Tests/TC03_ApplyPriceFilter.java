package KonaKart_Tests;

import KonaKart_Pages.GamePage;
import KonaKart_Pages.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03_ApplyPriceFilter extends BaseClass{

    private static final Logger log = LogManager.getLogger("TC03_ApplyPriceFilter");



    @Test
    public void applyFilter() throws Exception {
        driver.get(baseUrl);
        driver.manage().window().maximize();
        Assert.assertEquals("KonaKart", driver.getTitle(),"KonaKart Home Page Title is mismatched");
        log.info("KonaKart Home Page Opened successfully");

        HomePage homePage =new HomePage(driver);
        homePage.selectGame();
        log.info("Game catagory has selected from the product dropdown");

        GamePage gamePage = new GamePage(driver);
        //gamePage.sortprize();
        gamePage.filterprize();
        gamePage.filtervalue();
        log.info("Filtered price range from 39$ to 80$ is applied");
        captureScreenshot(driver,"TC03_ApplyPriceFilter");
    }

}

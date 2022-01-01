package KonaKart_Tests;

import KonaKart_Pages.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02_SelectGame extends BaseClass {
    private static final Logger log = LogManager.getLogger("TC02_SelectGame");

    @Test
    public void selectGame() throws Exception {
        driver.get(baseUrl);
        driver.manage().window().maximize();
        Assert.assertEquals("KonaKart", driver.getTitle(),"KonaKart Home Page Title is mismatched");
        log.info("KonaKart Home Page Opened successfully");

        HomePage homePage =new HomePage(driver);
        homePage.selectGame();
        log.info("Game catagory has selected from the product dropdown");
        Assert.assertEquals(driver.getTitle(),"Games","Game Title is mismatched");
        captureScreenshot(driver,"TC02_SelectGame");
    }

}

package KonaKart_Tests;

import KonaKart_Pages.HomePage;
import jdk.jfr.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01_VerifyHomePage extends BaseClass{


    private static final Logger log = LogManager.getLogger("TC01_VerifyHomePage");
    @Test
    @Description("TestCase01 Description: Verify Home page title")
    public void verifyHomepageTitle() throws Exception {
        driver.get(baseUrl);
        driver.manage().window().maximize();
        Assert.assertEquals("KonaKart", driver.getTitle(),"KonaKart Home Page Title is mismatched");
        captureScreenshot(driver,"TC01_VerifyHomePage");
        log.info("KonaKart Home Page Opened successfully");
    }




}

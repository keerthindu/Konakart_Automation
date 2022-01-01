package KonaKart_Tests;

import Utilities.readConfig;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Random;

public class BaseClass {

    readConfig readconf = new readConfig();

    public static WebDriver driver;
    String baseUrl = readconf.getURL();


    @BeforeClass
    public void setup(){

        System.out.println("launching chrome browser");
        System.setProperty("webdriver.chrome.driver",readconf.getchromedriver());
        driver=new ChromeDriver();

    }


    @AfterClass
    public void teardown(){

        driver.close();

    }

    public void captureScreenshot(WebDriver driver, String tname) throws Exception {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir")+"./Screenshots/" +tname+".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }

    public int randomstring()
    {
        Random random = new Random();
        return random.nextInt();
    }
}

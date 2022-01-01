package KonaKart_Pages;

import KonaKart_Tests.BaseClass;
import Utilities.readConfig;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage extends BaseClass {

    WebDriver ldriver;

    public OrderConfirmationPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath = "//*[@id='continue-button']")
    WebElement confirmOrder;

    public void confirmOrder() throws InterruptedException {

//        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
//        javascriptExecutor.executeScript("document.getElementsByClassName('button small-rounded-corners')[1].click()");

        Actions act = new Actions(ldriver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
        act.moveToElement(confirmOrder).click().build().perform();
        Thread.sleep(5000);
    }
}

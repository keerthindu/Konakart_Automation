package KonaKart_Pages;

import KonaKart_Tests.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckoutConfirmationPage extends BaseClass {

    WebDriver ldriver;

    public CheckoutConfirmationPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath = "//*[@id='continue-button']")
    WebElement continuechekcout;

    @FindBy(xpath = "//*[@id='continue-button']")
    WebElement finalContinue;

    @FindBy(xpath = "//tbody/tr/td[4]/div[1]")
    WebElement pendinglabel;

    @FindBy(xpath = "//h1[@id='page-title']")
    WebElement title;

    @FindBy(xpath = "//*[@id=\"last-orders\"]/div[2]/table/tbody[1]/tr/td[3]")
    WebElement total;

    public void confirmCheckout() throws InterruptedException {

        Actions act = new Actions(ldriver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();",continuechekcout);
//        act.moveToElement(continuechekcout).click().build().perform();
//        Thread.sleep(5000);

    }

    public void clickContinue() throws InterruptedException {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();",finalContinue);

        //Actions act = new Actions(ldriver);
       // act.moveToElement(finalContinue).click().build().perform();
       // new WebDriverWait(ldriver, 40).until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[id='continue-button'] span"))).click();
        Thread.sleep(3000);


    }

    public String verifyPending(){
        return pendinglabel.getText();
    }

    public String verifyTitle(){
        return title.getText();
    }

    public String verifyAddeditemOne(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) ldriver;
        String value = jsExecutor.executeScript("return document.getElementsByClassName('text-link')[6].innerText").toString();
//        value = value.replaceAll("[$]", "");
        //return value.replaceAll("\nQuantity","");
        return value;
    }

    public String verifyAddeditemTwo(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) ldriver;
        String value = jsExecutor.executeScript("return document.getElementsByClassName('text-link')[5].innerText").toString();
        //return value.replaceAll("\nQuantity","");
        return value;
    }

    public String VerifyTotal(){
        String val = total.getText();
        return val.replaceAll("[Total: $]", "");

    }
}

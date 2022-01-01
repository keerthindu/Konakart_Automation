package KonaKart_Pages;

import KonaKart_Tests.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddCartPage extends BaseClass {

    WebDriver ldriver;

    public AddCartPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath = "//*[@class='jcarousel-control-next jcarousel-border-next next-items-inactive']")
    WebElement arrow;
    @FindBy(xpath = "//*[@id='449atc-21'][@class='add-to-cart-button button small-rounded-corners']")
    WebElement AddTocart;
    //  @FindBy(xpath = "//*[text()='SWAT 3: Close Quarters Battle']")
    @FindBy(xpath = "//*[@class='jcarousel']/ul/li[5]")
    WebElement lastitem;
    @FindBy(xpath = "//a[@onclick=\"addtoCartOrWishListFunc('AddToCartForm')\"][normalize-space()='Add to Cart']")
    WebElement Addcart;
    @FindBy(xpath = "//span[@class='shopping-cart-title top-bar-menu-title']/span")
    WebElement cartCount;
    @FindBy(xpath = "//*[@class='jcarousel']/ul/li[1]")
    WebElement AddFirstItem;
    @FindBy(xpath="//form[@id='AddToCartForm']//select[@id='prodQuantityId']//option[@value='2']")
    WebElement ProdQuantity;
    @FindBy(xpath = "//span[@class='shopping-cart-title top-bar-menu-title']/span")
    WebElement finalcartCount;
    @FindBy (xpath = "//span[@class='shopping-cart-title top-bar-menu-title']//span[@id='basket-items']")
    WebElement BasketItem;

    public void AddlastItem() throws InterruptedException {
        Actions act = new Actions(ldriver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) ldriver;
        jsExecutor.executeScript("document.getElementsByClassName('add-to-cart-button button small-rounded-corners')[4].click()");
        Thread.sleep(5000);
    }

    public void Additems() throws Exception {

        Actions act = new Actions(ldriver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(5000);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) ldriver;
        jsExecutor.executeScript("document.getElementsByClassName('add-to-cart-button button small-rounded-corners')[4].click();");
        jsExecutor.executeScript("document.getElementsByClassName('add-to-cart-button button small-rounded-corners')[0].click();");
        jsExecutor.executeScript("document.getElementsByClassName('add-to-cart-button button small-rounded-corners')[0].click();");
        Thread.sleep(5000);
    }

    public String  verifyCartCount() throws Exception {

        return cartCount.getText();
    }
    public void addFirstItemToCart() throws InterruptedException {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) ldriver;
        jsExecutor.executeScript("document.getElementsByClassName('add-to-cart-button button small-rounded-corners')[0].click();");
        Thread.sleep(5000);
        jsExecutor.executeScript("document.getElementsByClassName('add-to-cart-button button small-rounded-corners')[0].click();");
        //AddFirstItem.click();
        //ProdQuantity.click();
       // Addcart.click();

    }
    public String  ProductquantityCount() throws Exception {

       // return ProdQuantity.getText();
       return finalcartCount.getText();
    }

    public String Verify4Screenshots(){
        AddFirstItem.click();
        List<WebElement> elements = ldriver.findElements(By.xpath("//*[@id='gallery_nav']//img"));
        System.out.println("Number of Images:" +elements.size());
        int val= elements.size();
        return Integer.toString(val);

    }

    public String verifyBasketItems(){
        return BasketItem.getText().replaceAll("[()]","");
    }

    public String VerifyLastitemTitle(){
        return lastitem.getText();
    }

    public String VerifyFirstitemTitle(){
        String value = AddFirstItem.getText();
        System.out.println("1st item title" + value);
        return value;

    }


}



        //JavascriptExecutor jsExecutor = (JavascriptExecutor) ldriver;
       //String value = jsExecutor.executeScript("return document.getElementsByClassName('price')[4].innerText").toString();
      //  ldriver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[4]/div[2]/div[1]/div[1]/a[2]")).click();
       // jsExecutor.executeScript("document.querySelector('body > div:nth-child(6) > div:nth-child(1) > div:nth-child(7) > div:nth-child(4) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > a:nth-child(1)').click()");




        // act.moveToElement(arrow).click().build().perform();
       // new WebDriverWait(ldriver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='jcarousel-control-next jcarousel-border-next next-items-inactive']"))).click();

        //captureScreenshot(ldriver,"TC04_Addcart");

        //ldriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       // JavascriptExecutor jsExecutor = (JavascriptExecutor) ldriver;
      //  jsExecutor.executeScript("document.querySelector('body > div:nth-child(6) > div:nth-child(1) > div:nth-child(7) > div:nth-child(4) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > a:nth-child(1)').click()");

//
//        new WebDriverWait(ldriver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='449atc-21'][@class='add-to-cart-button button small-rounded-corners']"))).click();
//        act.moveToElement(AddTocart).click().build().perform();

//        JavascriptExecutor jsExecutor = (JavascriptExecutor) ldriver;
//        jsExecutor.executeScript(" document.querySelector('body > div:nth-child(6) > div:nth-child(1) > div:nth-child(7) > div:nth-child(4) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > a:nth-child(1)').click();");
//        //jsExecutor.executeScript("arguments[0].click();", "//*[@id='449atc-21'][@class='add-to-cart-button button small-rounded-corners']");

//        String value = jsExecutor.executeScript("return document.getElementsByClassName('price')[4].innerText").toString();
//        value = value.replaceAll("[$]", "");
//        float amount2 = Float.parseFloat(value);
//
//        if (amount2 >= 39 && amount2 <= 80) {
//            System.out.println(amount2);
//
//        }



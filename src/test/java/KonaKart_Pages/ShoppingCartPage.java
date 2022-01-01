package KonaKart_Pages;

import KonaKart_Tests.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends BaseClass {

    WebDriver ldriver;

    public ShoppingCartPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy (xpath = "//span[@class='shopping-cart-title top-bar-menu-title']//span[@id='basket-items']")
    WebElement ShoppingCart;

    @FindBy(xpath = "//span[text()='Checkout']")
    WebElement CheckOut;

    @FindBy(xpath = "//span[text()='Register an account']")
    WebElement Register;

    public void openShopCart() throws InterruptedException {
        ShoppingCart.click();
        Thread.sleep(3000);
    }

    public String verifyAddeditemOne(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) ldriver;
        String value = jsExecutor.executeScript("return document.getElementsByClassName('basket-body')[0].innerText").toString();
//        value = value.replaceAll("[$]", "");
        return value.replaceAll("\nQuantity","");
    }

    public String verifyAddeditemTwo(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) ldriver;
        String value = jsExecutor.executeScript("return document.getElementsByClassName('basket-body')[1].innerText").toString();
        return value.replaceAll("\nQuantity","");
    }

    public String verifySubTotal(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) ldriver;
        String price1 = jsExecutor.executeScript("return document.getElementsByClassName('total-price right')[0].innerText").toString();
        price1 = price1.replaceAll("[$]", "");
        String price2 = jsExecutor.executeScript("return document.getElementsByClassName('total-price right')[1].innerText").toString();
        price2 = price2.replaceAll("[$]", "");
        return price1 + price2;
    }

    public String total(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) ldriver;
        String total = jsExecutor.executeScript("return document.getElementsByClassName('cost-overview-amounts right')[2].innerText").toString();
        total = total.replaceAll("[$\n]", "");
        return total;

    }

    public void proceedCheckout(){
        CheckOut.click();
    }

    public void registerAccount(){
        Register.click();
    }

}

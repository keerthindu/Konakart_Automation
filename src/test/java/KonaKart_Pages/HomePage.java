package KonaKart_Pages;

import KonaKart_Tests.BaseClass;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class HomePage {

    WebDriver ldriver;

    public HomePage(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(xpath = "//*[text()='Products']")
    WebElement selectproduct;

    @FindBy(xpath = "//*[text()='Games']")
    WebElement selectgame;

    @FindBy(xpath = "//ul[@id='smart-menus']//li//ul//a[@href='SelectCat.action?catId=2']")
    WebElement games;

    @FindBy(id ="search-input")
    WebElement entertxt;

    @FindBy(id="search-button")
    WebElement searchbtn;

    @FindBy(xpath = "//*[@class='price']")
    WebElement prize;

    @Step("Selecting Game from Product drop down")
    public void selectGame() throws Exception {

        Actions act = new Actions(ldriver);
        act.moveToElement(selectproduct).build().perform();
      //  Thread.sleep(5000);
       // new WebDriverWait(ldriver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Products']"))).click();
       // ldriver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);
        //act.moveToElement(games).click().build().perform();
        new WebDriverWait(ldriver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='smart-menus']//li//ul//a[@href='SelectCat.action?catId=2']"))).click();
        act.moveToElement(games).click().build().perform();
        Thread.sleep(5000);
    }

    public void sortprize(){
        //capture all webelement into list
        List<WebElement> elements = ldriver.findElements(By.xpath("//*[@class='price']"));
        System.out.println("Number of elements:" +elements.size());

        //capture text of all element into list
        List<String > originalList = elements.stream().map(s->s.getText()).collect(Collectors.toList());

        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted Element is" + sortedList);

        }


        public void filterprize() throws ParseException {


            HashMap<Integer, String> map = new HashMap<>();
            List<WebElement> elements = ldriver.findElements(By.xpath("//*[@class='item']"));

            if(elements.size()!=0){
                for (int i=0;i<elements.size()-1;i++) {
//                    System.out.println("*************"+elements.get(i).getText());
                    // String price = new WebDriverWait(ldriver, 50).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='pricing']"))).get(i).getText();
                    //String title = new WebDriverWait(ldriver, 50).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='item-title']"))).get(i).getText();
                    // JavascriptExecutor jse = (JavascriptExecutor) ldriver;
                    //String price= jse.executeScript("document.getElementsByClassName('pricing')[0].innerText;").toString();

                    String price = ldriver.findElements(By.xpath("//*[@class='pricing']")).get(i).getText();
                    //String title = ldriver.findElements(By.xpath("//*[@class='item-title']")).get(i).getText();
                    //System.out.println(title);
                    // System.out.println(price);

                    price = price.replaceAll("[$]", "");
                    float amount = Float.parseFloat(price);
                    //NumberFormat format = NumberFormat.getCurrencyInstance();
                    //Number a = format.parse(price);
                    //int amount =a.intValue();
                    if (!price.equals("")) {

//                    System.out.println(amount);

                        if (amount >= 39 && amount <= 80) {
                            System.out.println(amount);

                        }

                    }

                }


            }

        }

        public void fsample(){

                JavascriptExecutor jsExecutor = (JavascriptExecutor) ldriver;
                String value = jsExecutor.executeScript("return document.getElementsByClassName('price')[4].innerText").toString();
                value = value.replaceAll("[$]", "");
                float amount2 = Float.parseFloat(value);

            if (amount2 >= 39 && amount2 <= 80) {
                System.out.println(amount2);

            }
    }

}




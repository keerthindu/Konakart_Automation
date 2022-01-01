package KonaKart_Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GamePage {

    WebDriver ldriver;

    public GamePage(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }
    @FindBy(xpath = "//*[@class='jcarousel']/ul/li[1]/div/a[@class='item-title']")
    WebElement FirstItemTitleBeforeadd;

    @FindBy(xpath = "//*[@class='jcarousel']/ul/li[5]/div/a[@class='item-title']")
    WebElement LastItemBeforeadd;

    @FindBy(xpath = "//h1[@id='page-title']")
    WebElement FirstItemTitle;

    public void sortprize(){
        //capture all webelement into list
        List<WebElement> elements = ldriver.findElements(By.xpath("//*[@class='price']"));
        System.out.println("Number of elements:" +elements.size());

        //capture text of all element into list
        List<String > originalList = elements.stream().map(s->s.getText()).collect(Collectors.toList());

        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted Element is" + sortedList);

    }


    public void filterprize() throws ParseException, InterruptedException {


        HashMap<Integer, String> map = new HashMap<>();
        Actions act = new Actions(ldriver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(5000);
        List<WebElement> elements = ldriver.findElements(By.xpath("//*[@class='item']"));

        if(elements.size()!=0){
            for (int i=0;i<elements.size()-1;i++) {
                String price = ldriver.findElements(By.xpath("//*[@class='pricing']")).get(i).getText();
                String title = ldriver.findElements(By.xpath("//*[@class='item-title']")).get(i).getText();
                price = price.replaceAll("[$]", "");
                float amount = Float.parseFloat(price);
                if (!price.equals("")) {
                    if (amount >= 39 && amount <= 80) {
                        System.out.println(title + " " +amount);
                    }
                }
            }
        }
    }

    public void filtervalue() throws InterruptedException {

        JavascriptExecutor jsExecutor = (JavascriptExecutor) ldriver;
        Actions act = new Actions(ldriver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(5000);
        String value = jsExecutor.executeScript("return document.getElementsByClassName('price')[4].innerText").toString();
        value = value.replaceAll("[$]", "");
        float amount2 = Float.parseFloat(value);
        String title = ldriver.findElements(By.xpath("//*[@class='item-title']")).get(4).getText();

        if (amount2 >= 39 && amount2 <= 80) {
            System.out.println( title + " " +amount2);

        }
    }

    public String FirstItemnameBeforeadd(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) ldriver;
        String value = jsExecutor.executeScript("return document.getElementsByClassName('item-title')[0].innerText").toString();
        return value;
        //return FirstItemTitleBeforeadd.getText();
    }

    public String LastItemnameBeforeadd(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) ldriver;
        String value = jsExecutor.executeScript("return document.getElementsByClassName('item-title')[4].innerText").toString();
        return value;
    }



    public String FirstItemnameAfteradd(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) ldriver;
        String firstitem = javascriptExecutor.executeScript("return document.getElementsByClassName('shopping-cart-item-title')[0].innerText").toString();
        return firstitem;
        //return FirstItemTitle.getText();
    }




}

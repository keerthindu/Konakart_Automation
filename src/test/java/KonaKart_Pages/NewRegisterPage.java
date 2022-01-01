package KonaKart_Pages;

import KonaKart_Tests.BaseClass;
import Utilities.readConfig;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewRegisterPage extends BaseClass {
    readConfig readconf = new readConfig();

    WebDriver ldriver;

    public NewRegisterPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath = "//input[@value='f']")
    WebElement gender;
    @FindBy(xpath = "//input[@id='firstName']")
    WebElement firstName;
    @FindBy(xpath = "//input[@id='lastName']")
    WebElement lastName;
    @FindBy(xpath = "//input[@id='datepicker']")
    WebElement dob;
    @FindBy(xpath = "//input[@id='emailAddr']")
    WebElement email;
    @FindBy(xpath = "//input[@id='streetAddress']")
    WebElement streetaddress;
    @FindBy(xpath = "//input[@id='postcode']")
    WebElement postcode;
    @FindBy(xpath = "//input[@id='city']")
    WebElement city;
    @FindBy(xpath = "//select[@id='countryId']//option[text()='United Arab Emirates']")
    WebElement country;
    @FindBy(xpath = "//input[@id='state']")
    WebElement state;
    @FindBy(xpath = "//input[@id='telephoneNumber']")
    WebElement phonenumber;
    @FindBy(xpath = "//input[@id='password']")
    WebElement pwd;
    @FindBy(xpath = "//input[@id='passwordConfirmation']")
    WebElement confirmpwd;
    @FindBy(xpath = "//*[@id='continue-button']")
    WebElement continueButton;


    public void fillData() throws Exception {
         gender.click();
         firstName.sendKeys(readconf.firstName());
         lastName.sendKeys(readconf.lastName());
         dob.sendKeys(readconf.dob());
         dob.sendKeys(Keys.ENTER);
         email.sendKeys(readconf.email());
         streetaddress.sendKeys(readconf.streetAddress());
         postcode.sendKeys(readconf.postCode());
         city.sendKeys(readconf.city());
         country.click();
         state.sendKeys(readconf.state());
         phonenumber.sendKeys(readconf.phone());
         pwd.sendKeys(readconf.password());
         confirmpwd.sendKeys((readconf.password()));
         Thread.sleep(8000);
         captureScreenshot(driver,"dataadded");

        Actions act = new Actions(ldriver);
        //new WebDriverWait(ldriver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='button small-rounded-corners']//span[text()='Continue']"))).click();
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
        //Thread.sleep(5000);
        act.moveToElement(continueButton).click().build().perform();
        Thread.sleep(5000);


    }

}

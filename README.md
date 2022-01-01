# KonaKartAutomation (Selenium- Java - testNG Framework) #

KonaKart automation project has done with the help of page object model(POM) which is written in Selenium with Java. This testng framwork automated the following test cases and enabled extent report for the same.

## Test Case ##
1. TC01_VerifyHomePage - Verify whether the KonaKart Home page opened successfully and Verify the home page title should be matched
2. TC02_SelectGame - Verify the Game catagory has selected from the product drop down menu and it should display all available games.
3. TC03_ApplyPriceFilter - Verify the game product price should be filtered from 39$ to 80$
4. TC04_AddLastToCart - Verify the last game product should be added to the cart.
5. TC05_AddFirstItemToCart - Verify the first game product should be added to the cart with 2 quantity
6. TC06_OpenShopCart - Verify whether the shop cart able to open and validate the item & total value of each products
7. TC07_ProceedToCheckout - Verify to the products should proceed checkout and check whether the user able to create new account before proceed.
8. TC08_ConfirmOrder - Verify the user able to proceed the confirm order button.
9. TC09_VerifyPendingStatus - Verify the status of the order should be pending
10. TC10_VerifyPrice_Item - Verify the price and product name should be same as we added earlier.


**Prerequisite**
1. Java environment 
2. Maven 
3. allure
4. Intellij IDE

## Getting Started ##
Copy the repo into your local machine.
  * git clone https://github.com/keerthindu/Konakart_Automation.git
 
 ## Project Structure ##
 
 ![image](https://user-images.githubusercontent.com/85629580/147827112-9d4021d9-9e22-4ee8-83b1-ef258ffb66ea.png)


## Run tests locally ##

 Run the test cases using any one of the below methods,

  * Under the KonaKart_Tests package you can see Testcases. Right Click on TestCases and select "Run" or "Debug" to start the test.
  * Open testng.xml file --> Right Click on it and Select "Run" or "Debug" to start the test.
  * Run test through the commandline,
      *mvn clean test
      
## Defining the browser ##

By default, the project will default to ChromeLocal (running a local Chrome instance) if no browser is specified.
 
 - Configure webdriver.
    - I used ChromeDriver but you can choose other webdriver eg. Mozilla GeckoDriver 
    - So first download ChromeDriver from [http://chromedriver.chromium.org/downloads](http://chromedriver.chromium.org/downloads).
    - Copy your downloaded **chromedriver.exe** file path.
    - Go to `KonaKart\Drivers` file.
    - Paste the copied file path in `System.setProperty("webdriver.chrome.driver","Paste path here")`.

## TestCase Package ##

 * KonaKart>src>test>KonaKart_Tests
 
 ## Base Class ##
 
* Base Class contains reusable methods such as setup() and teardown() functions which help to initate and close the browser session after every test execution completed.
* captureScreenshot() method helps to capture the screenshot at test level and You can find the screenshot under 'Screenshots' folder
 
 ## qa_config.properties ##
 
 * qa_config.properties file contains base url, browser, sample test data, etc,.
 
 
 ## Utilities Package ##
 
  * Utilities package contains helper methods which help to read the qa_config.properties file.
  * readConfig() class helps to access the qa_config properties
 
    - Note: same email address you can not register an account , so with the help of Random() class I've created random email address before every run of the test. 
 
 ## KonaKart Pages ##
   
 * Page Factory is a class provided by Selenium WebDriver to support Page Object Design patterns. 
 * In Page Factory, I used @FindBy annotation. The initElements method is used to initialize web elements.

    * @FindBy: An annotation used in Page Factory to locate and declare web elements using different locators. Below is an example of declaring an element using @FindBy
   
          *@FindBy(id="elementId") WebElement element;
    
 * When all screens have independent java files, one can easily identify actions that will be performed on a particular screen by navigating through the java file.
 * If a change must be made to a certain section of code, it can be efficiently done without affecting other files.
 
 * As already discussed, each java class will contain a corresponding page file. Here, I've created 7-page classes.
      * AddCartPage
      * CheckoutConfirmationPage
      * GamePage
      * HomePage
      * NewRegisterPage
      * OrderConfirmationPage
      * ShoppingCartPage

* Each of these files will contain UI elements or Objects which are present on these screens. It will also contain the operations to be performed on these elements.

 ### Page Class ###
 ![image](https://user-images.githubusercontent.com/85629580/147827900-e94040ae-9314-46f5-96bf-e4c3f1cc92cc.png)

 ## log4j2.properties ##
 
 * Log4j2 with Properties configuration file provides a simple way of setting up logging in your Java application.
 * To setup log4j2 for logging we will need log4j2 dependencies, which we will provide in our project's pom.xml file. 
 * Added log4j-api and log4j-core dependency
 

 ## testng.xml file ##
 
 * TestNG.xml file is an XML file which contains all the Test configuration and this XML file can be used to run and organize our test.
 * configuration of testng.xml are as follows,
     * A suite is represented by one XML file. It can contain one or more tests and is defined by the <suite> tag.
     * A test is represented by <test> and can contain one or more TestNG classes.
     * A TestNG class is a Java class that contains at least one TestNG annotation. It is represented by the <class> tag and can contain one or more test methods.
     * A test method is a Java method annotated by @Test in your source.
 
 ![image](https://user-images.githubusercontent.com/85629580/147827825-7224503d-413c-4331-ab12-a21ba5c4f1a6.png)

 
Note: TestNG plugin can be used to automatically generate testng.xml file so no need to write from scratch.
 
 ## Reports ##
 **You can find the test result in `target/surefire-reports/index.html`**


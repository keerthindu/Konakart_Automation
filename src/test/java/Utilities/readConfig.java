package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

public class readConfig {
    Properties pro;

    public readConfig()
    {	//read common value from config.properties
        File src = new File("qa_config.properties");

        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e) {
            System.out.println("Exception is " + e.getMessage());
        }
    }

    public String getURL()
    {
        return pro.getProperty("baseURL");
    }

    public String getchromedriver()
    {
        return pro.getProperty("chromepath");
    }

    public String getiedriver()
    {
        return pro.getProperty("iepath");
    }

    public String getCartCount(){
        return pro.getProperty("CartCount");
    }

    public String getCartfinalCount(){
        return pro.getProperty("FinalCartCount");
    }

    public String screenshotCount(){
        return pro.getProperty("NoOfScreenshot");
    }

    public String Prodquantity(){
        return pro.getProperty("ProductQuantity");
    }

    public String FinalBasketCount(){
        return pro.getProperty("FinalBasketItems");
    }

    public String firstName() {return pro.getProperty("FirstName");}
    public String lastName() {return pro.getProperty("LastName");}
    public String dob() {return pro.getProperty("DOB");}
    public String email() {
        Random random = new Random();
        int val = random.nextInt();
         return "username" + val + "@gmail.com";
    }

    public String streetAddress() {
        Random random = new Random();
        int val = random.nextInt(100);
        return val+pro.getProperty("StreetAddress");

    }

    public String postCode(){
       return pro.getProperty("PostCode");
    }
    public String city(){return pro.getProperty("City");}
    public String state(){return pro.getProperty("State");}
    public String phone(){return pro.getProperty("Phone");}
    public String password(){return pro.getProperty("Password");}

    public String status(){return pro.getProperty("Status");}
    public String title(){return pro.getProperty("Title");}

}

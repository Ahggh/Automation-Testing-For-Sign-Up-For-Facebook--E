package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Facebook_Login_Page {
   private static WebElement Object=null;
    public static WebElement create_new_account_button(WebDriver driver){
        Object=  driver.findElement(By.xpath("//*[@data-testid='open-registration-form-button']"));
        return Object;
    }
    public static WebElement login_button(WebDriver driver){
        Object=  driver.findElement(By.xpath("//*[@data-testid='royal_login_button']"));
        return Object;
    }
}

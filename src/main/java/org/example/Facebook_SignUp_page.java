package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Facebook_SignUp_page {
   private static WebElement Object=null;
   private static Select Selection_Obj=null;
    private static List<WebElement> obj_repeated =null;
   //elements of typing name
   public static WebElement first_name_text_box(WebDriver driver){
       Object=driver.findElement(By.name("firstname"));
       return Object;
   }
    public static WebElement surname_text_box(WebDriver driver){
        Object=driver.findElement(By.name("lastname"));
        return Object;
    }
    //elements of typing email or phone number
    public static WebElement mobile_number_or_email_address_text_box(WebDriver driver){
        Object=driver.findElement(By.name("reg_email__"));
        return Object;
    }
    //elements of password
    public static WebElement password_text_box(WebDriver driver){
        Object=driver.findElement(By.name("reg_passwd__"));
        return Object;
    }
    //selection of elements for data of birth
    public static Select data_of_birth_selection_day(WebDriver driver){
        Selection_Obj=new Select(driver.findElement(By.id("day")));

        return Selection_Obj;
    }
    public static Select data_of_birth_selection_month(WebDriver driver){
        Selection_Obj=new Select(driver.findElement(By.id("month")));
        return Selection_Obj;
    }
    public static Select data_of_birth_selection_year(WebDriver driver){
        Selection_Obj=new Select(driver.findElement(By.id("year")));
        return Selection_Obj;
    }
    public static WebElement SignUp_btn(WebDriver driver){
        Object=driver.findElement(By.xpath("//*[@type='submit']"));
        return Object;
    }
    public static WebElement Gender_Alert(WebDriver driver){
        Object=driver.findElement(By.xpath("//*[text()='Please choose a gender. You can change who can see this later.']"));
        return Object;
    }
    public static WebElement Gender_Male_Selection(WebDriver driver,int index){
        obj_repeated=driver.findElements(By.xpath("//*[@id='sex']"));

        return obj_repeated.get(index);
    }
    public static WebElement Gender_Female_Selection(WebDriver driver){
        Object=driver.findElement(By.xpath("//*[@value='2']"));
        return Object;
    }

    //Error Indicators
    public static void Error_indicator_for_firstName(WebElement Obj_element,WebDriver driver)  {
     String   expectedCssValue="rgb(255, 0, 0)";
       WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
      boolean isCssValueChanged = wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                String currentCssValue = Obj_element.getCssValue("border-color");
                System.out.println("Current CSS Value: " + currentCssValue);
                return currentCssValue.equals(expectedCssValue);}
        });


        if (isCssValueChanged){
    System.out.println("color of element changed");

}
else {
    System.out.println("color of element Not changed");
}
    }
    public static WebElement FirstName_messageError_elment(WebDriver driver){
        Object=driver.findElement(By.xpath("//*[@class='_5633 _5634 _53ij']"));
        return Object;
    }
    public static void FirstName_messageError_found_detection(WebDriver driver,WebElement text_box,WebElement message_error) {
        //Actions act = new Actions(driver);
        String Expected_String = "What's your name?";
        boolean is_error_message_founded=false;
try {
     is_error_message_founded= new WebDriverWait(driver, Duration.ofSeconds(2)).until(new ExpectedCondition<Boolean>() {


        public Boolean apply(WebDriver input) {
            // act.doubleClick(Facebook_SignUp_page.first_name_text_box(driver));

            Facebook_SignUp_page.first_name_text_box(input).sendKeys(" ");
            String actual_String =message_error.getText();
            return actual_String.equals(Expected_String);
        }
    });
    if(is_error_message_founded){
        System.out.println(Expected_String);
    }
}
catch (TimeoutException ignored){
    Assert.fail("Test failed because the element was not clickable.");

}



}
}



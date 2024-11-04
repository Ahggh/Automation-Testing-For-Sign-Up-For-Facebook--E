import com.beust.jcommander.Parameter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.ObjectUtils;
import org.example.Facebook_Login_Page;
import org.example.Facebook_SignUp_page;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.swing.*;
import java.time.Duration;

public class Test_Facebook_SignUp {
    public WebDriver signup_page= null;
   @BeforeMethod
    public void open_page(){
       WebDriverManager.chromedriver().setup();
       signup_page=new ChromeDriver();
       signup_page.get("https://www.facebook.com/");
       Facebook_Login_Page.create_new_account_button(signup_page).click();
    }
    @Parameters({"Valid_email","Index_Male"})
    @Test(priority = 0)
    public void validate_leaving_the_firstname_empty(String mail,int gender_male_index ) throws InterruptedException {
String Intial_Url=signup_page.getCurrentUrl();
        Facebook_SignUp_page.surname_text_box(signup_page).sendKeys("Bassam");
        Facebook_SignUp_page.data_of_birth_selection_day(signup_page).selectByIndex(gender_male_index);
        Facebook_SignUp_page.data_of_birth_selection_month(signup_page).selectByIndex(gender_male_index);
        Facebook_SignUp_page.data_of_birth_selection_year(signup_page).selectByValue("2008");
        Facebook_SignUp_page.data_of_birth_selection_year(signup_page).selectByValue("2008");
        Facebook_SignUp_page.mobile_number_or_email_address_text_box(signup_page).sendKeys(mail);
        Facebook_SignUp_page.password_text_box(signup_page).sendKeys("Sam123@");
        Facebook_SignUp_page.Gender_Male_Selection(signup_page, gender_male_index).click();
        Facebook_SignUp_page.SignUp_btn(signup_page).click();
        String Current_Url=signup_page.getCurrentUrl();
        Assert.assertEquals(Intial_Url,Current_Url,"(FaceBook SignUp ,Not Detect first Name empty Field)");
        if(Intial_Url.equals(Current_Url))System.out.println("(FaceBook  Not SignUp And Detect first Name empty Field)");

        Facebook_SignUp_page.FirstName_messageError_found_detection(signup_page,Facebook_SignUp_page.first_name_text_box(signup_page)
                ,Facebook_SignUp_page.FirstName_messageError_elment(signup_page));


    }
    @Parameters({"Valid_email","Index_Male"})
    @Test
    public void validate_leaving_the_Surname_empty(String mail,int gender_male_index){
        String Intial_Url=signup_page.getCurrentUrl();
          Facebook_SignUp_page.first_name_text_box(signup_page).sendKeys("Mahmoud");
        //Facebook_SignUp_page.surname_text_box(signup_page).sendKeys("Bassam");
        Facebook_SignUp_page.data_of_birth_selection_day(signup_page).selectByIndex(gender_male_index);
        Facebook_SignUp_page.data_of_birth_selection_month(signup_page).selectByIndex(gender_male_index);
        Facebook_SignUp_page.data_of_birth_selection_year(signup_page).selectByValue("2008");
        Facebook_SignUp_page.data_of_birth_selection_year(signup_page).selectByValue("2008");
        Facebook_SignUp_page.mobile_number_or_email_address_text_box(signup_page).sendKeys(mail);
        Facebook_SignUp_page.password_text_box(signup_page).sendKeys("Sam123@");
        Facebook_SignUp_page.Gender_Male_Selection(signup_page, gender_male_index).click();
        Facebook_SignUp_page.SignUp_btn(signup_page).click();
        String Current_Url=signup_page.getCurrentUrl();
        Assert.assertEquals(Intial_Url,Current_Url,"(FaceBook SignUp ,Not Detect first Name empty Field)");
        if(Intial_Url.equals(Current_Url))System.out.println("(FaceBook  Not SignUp And Detect Surname empty Field)");

    }
    @Parameters("Index_Male")
    @Test
    public void validate_leaving_the_email_or_phone_number_empty(int gender_male_index){
        String Intial_Url=signup_page.getCurrentUrl();
        Facebook_SignUp_page.first_name_text_box(signup_page).sendKeys("Mahmoud");
        Facebook_SignUp_page.surname_text_box(signup_page).sendKeys("Bassam");
        Facebook_SignUp_page.data_of_birth_selection_day(signup_page).selectByIndex(gender_male_index);
        Facebook_SignUp_page.data_of_birth_selection_month(signup_page).selectByIndex(gender_male_index);
        Facebook_SignUp_page.data_of_birth_selection_year(signup_page).selectByValue("2008");
        Facebook_SignUp_page.data_of_birth_selection_year(signup_page).selectByValue("2008");
        //Facebook_SignUp_page.mobile_number_or_email_address_text_box(signup_page).sendKeys(mail);
        Facebook_SignUp_page.password_text_box(signup_page).sendKeys("Sam123@");
        Facebook_SignUp_page.Gender_Male_Selection(signup_page, gender_male_index).click();
        Facebook_SignUp_page.SignUp_btn(signup_page).click();
        String Current_Url=signup_page.getCurrentUrl();
        Assert.assertEquals(Intial_Url,Current_Url,"(FaceBook SignUp ,Not Detect Email Or phoneNumber empty Field)");
        if(Intial_Url.equals(Current_Url))System.out.println("(FaceBook  Not SignUp And Detect Email Or phoneNumber empty Field)");

    }
    @Parameters({"Index_Male","Valid_email"})
    @Test
    public void validate_leaving_the_password_empty(int gender_male_index,String mail){
        String Intial_Url=signup_page.getCurrentUrl();
        Facebook_SignUp_page.first_name_text_box(signup_page).sendKeys("Mahmoud");
        Facebook_SignUp_page.surname_text_box(signup_page).sendKeys("Bassam");
        Facebook_SignUp_page.data_of_birth_selection_day(signup_page).selectByIndex(gender_male_index);
        Facebook_SignUp_page.data_of_birth_selection_month(signup_page).selectByIndex(gender_male_index);
        Facebook_SignUp_page.data_of_birth_selection_year(signup_page).selectByValue("2008");
        Facebook_SignUp_page.data_of_birth_selection_year(signup_page).selectByValue("2008");
        Facebook_SignUp_page.mobile_number_or_email_address_text_box(signup_page).sendKeys(mail);
        //Facebook_SignUp_page.password_text_box(signup_page).sendKeys("Sam123@");
        Facebook_SignUp_page.Gender_Male_Selection(signup_page, gender_male_index).click();
        Facebook_SignUp_page.SignUp_btn(signup_page).click();
        String Current_Url=signup_page.getCurrentUrl();
        Assert.assertEquals(Intial_Url,Current_Url,"(FaceBook SignUp ,Not Detect leaving_the_password_empty)");
        if(Intial_Url.equals(Current_Url))System.out.println("(FaceBook  Not SignUp And Detect leaving_the_password_empty)");
    }
    @Parameters({"Index_Male","Valid_email","password_with_less_than_6_digits"})
    @Test
    public void validate_password_with_less_than_6_digits (int gender_male_index,String mail,String password){
        String Intial_Url=signup_page.getCurrentUrl();
        Facebook_SignUp_page.first_name_text_box(signup_page).sendKeys("Mahmoud");
        Facebook_SignUp_page.surname_text_box(signup_page).sendKeys("Bassam");
        Facebook_SignUp_page.data_of_birth_selection_day(signup_page).selectByIndex(gender_male_index);
        Facebook_SignUp_page.data_of_birth_selection_month(signup_page).selectByIndex(gender_male_index);
        Facebook_SignUp_page.data_of_birth_selection_year(signup_page).selectByValue("2008");
        Facebook_SignUp_page.data_of_birth_selection_year(signup_page).selectByValue("2008");
        Facebook_SignUp_page.mobile_number_or_email_address_text_box(signup_page).sendKeys(mail);
        Facebook_SignUp_page.password_text_box(signup_page).sendKeys(password);
        Facebook_SignUp_page.Gender_Male_Selection(signup_page, gender_male_index).click();
        Facebook_SignUp_page.SignUp_btn(signup_page).click();
        String Current_Url=signup_page.getCurrentUrl();
        Assert.assertEquals(Intial_Url,Current_Url,"(FaceBook SignUp ,Not Detect password_with_less_than_6_digits)");
        if(Intial_Url.equals(Current_Url))System.out.println("(FaceBook  Not SignUp And Detect password_with_less_than_6_digits)");
    }


    @AfterMethod
    public void close_page() throws InterruptedException {
      Thread.sleep(300);
        signup_page.quit();

    }



}

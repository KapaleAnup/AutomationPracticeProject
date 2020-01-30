package com.practice.tests;

import com.practice.BaseLayer.BaseTest;
import com.practice.Pages.RegistrationPage;
import com.practice.Utility.TestUtilis;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class RegistrationTest extends BaseTest {

    RegistrationPage registrationPage ;


    @BeforeMethod
    public void beforeMethod(Method method){

        registrationPage = new RegistrationPage();
        System.out.println("\n" + " ****** starting test :" + method.getName() + " ******" + "\n");

    }

    @Test(priority = 0)
    public void invalidRegistrationDetailsWithBlankData(){
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            registrationPage.clickMyAccountPage();
            String titleOfCurrentPage = driver.getTitle();
            System.out.println("Name of the Page is : " + titleOfCurrentPage);
            registrationPage.enteruseremailId(" ");
            registrationPage.enterPassword("");
            registrationPage.pressRegistrationbutton();

            String actualerror = registrationPage.getErrormsg();
            String expectederror = "Error: Please provide a valid email address.";

            System.out.println("Actual Error text - " + actualerror + "\n" + "Expected Error text -" + expectederror);

            Assert.assertEquals(actualerror,expectederror);


    }

    @Test(priority = 1)
    public void invalidRegistrationDetailsWithinvalidEmailId(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        registrationPage.clickMyAccountPage();
        String titleOfCurrentPage = driver.getTitle();
        System.out.println("Name of the Page is : " + titleOfCurrentPage);
        registrationPage.enteruseremailId("");
        registrationPage.enterPassword("@@@@TESTUSER1234TESSETTETETTETETETTETETETETTETTETETTERERERRER");
        registrationPage.pressRegistrationbutton();

        String actualerror = registrationPage.getErrormsg();
        String expectederror = "Error: Please provide a valid email address.";

        System.out.println("Actual Error text - " + actualerror + "\n" + "Expected Error text -" + expectederror);

        Assert.assertEquals(actualerror,expectederror);


    }

    @Test(priority = 2)
    public void invalidRegistrationDetailsWithValidDetails(){

        registrationPage.clickMyAccountPage();
        String titleOfCurrentPage = driver.getTitle();
        System.out.println("Name of the Page is : " + titleOfCurrentPage);


       String useremail = registrationPage.enteruseremailId(TestUtilis.getUserEmailId() + "@gmail.com");
        System.out.println("Email id is :" + useremail.toString() );


        registrationPage.enterPassword("User@@@@TESTUSER1234TESSETTETETTETETETTETETETETTETTETETTERERERRER");
        registrationPage.pressRegistrationbutton();


        registrationPage.signout();
        System.out.println("The Registered user succesfulluy logged out..!");
      /*String user = registrationPage.getUsername();
      System.out.println("Name of the registered user is :" + user);

      Assert.assertEquals(user,);*/


    }
}

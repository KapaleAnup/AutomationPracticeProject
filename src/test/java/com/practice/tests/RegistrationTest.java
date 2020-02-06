package com.practice.tests;

import com.practice.BaseLayer.BaseTest;
import com.practice.Pages.RegistrationPage;
import com.practice.Utility.TestUtilis;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class RegistrationTest extends BaseTest {

    RegistrationPage registrationPage ;

    InputStream jsonData;
    String useremail;
    JSONObject registrationDetails;


    @BeforeClass
    public void beforeClass() throws Exception {
        try
        {
            String dataFileName = "data/RegistrationPage.json";
            jsonData =getClass().getClassLoader().getResourceAsStream(dataFileName);

            JSONTokener tokener = new JSONTokener(jsonData);
            registrationDetails = new JSONObject(tokener);

        }catch (Exception e){

            e.printStackTrace();

        }finally {

            if(jsonData!=null){
                jsonData.close();
            }
        }

    }
    @BeforeMethod
    public void beforeMethod(Method method) throws Exception {

        registrationPage = new RegistrationPage();
        System.out.println("\n" + " ****** starting test :" + method.getName() + " ******" + "\n");

    }

   //@Test(priority = 0)
    public void invalidRegistrationDetailsWithBlankData(){
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            registrationPage.clickMyAccountPage();
            String titleOfCurrentPage = driver.getTitle();
            System.out.println("Name of the Page is : " + titleOfCurrentPage);

            registrationPage.enteruseremailId(registrationDetails.getJSONObject("RegistrationDetailsWithBlankdata").getString("useremaiId"));
            registrationPage.enterPassword(registrationDetails.getJSONObject("RegistrationDetailsWithBlankdata").getString("password"));
            registrationPage.pressRegistrationbutton();

            String actualerror = registrationPage.getErrormsg();
            String expectederror = "Error: Please provide a valid email address.";

            System.out.println("Actual Error text - " + actualerror + "\n" + "Expected Error text -" + expectederror);

            Assert.assertEquals(actualerror,expectederror);


    }

   //@Test(priority = 1)
    public void invalidRegistrationDetailsWithinvalidEmailId(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        registrationPage.clickMyAccountPage();
        String titleOfCurrentPage = driver.getTitle();
        System.out.println("Name of the Page is : " + titleOfCurrentPage);
        registrationPage.enteruseremailId(registrationDetails.getJSONObject("BlankenailIdandvalidPassword").getString("useremaiId"));
        registrationPage.enterPassword(registrationDetails.getJSONObject("BlankenailIdandvalidPassword").getString("password"));
        registrationPage.pressRegistrationbutton();

        String actualerror = registrationPage.getErrormsg();
        String expectederror = "Error: Please provide a valid email address.";

        System.out.println("Actual Error text - " + actualerror + "\n" + "Expected Error text -" + expectederror);

        Assert.assertEquals(actualerror,expectederror);


    }


    @Test(priority = 2)
    public void RegistrationDetailsWithValidDetails(){

        registrationPage.clickMyAccountPage();
        String titleOfCurrentPage = driver.getTitle();
        System.out.println("Name of the Page is : " + titleOfCurrentPage);

        useremail = registrationPage.enteruseremailId(TestUtilis.getUserEmailId()+"@gmail.com");

       // String useremail = registrationPage.getUsername();
        System.out.println("Email id is :" + useremail);


        registrationPage.enterPassword(registrationDetails.getJSONObject("validemailandPassword").getString("password"));
        registrationPage.pressRegistrationbutton();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        registrationPage.signout();
        System.out.println("The Registered user successfully logged out..!");
      /*String user = registrationPage.getUsername();
      System.out.println("Name of the registered user is :" + user);

      Assert.assertEquals(user,);*/


    }
}

package com.practice.tests;

import com.practice.BaseLayer.BaseTest;
import com.practice.Pages.LoginPage;
import com.practice.Pages.RegistrationPage;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.lang.reflect.Method;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    InputStream jsonData;

    JSONObject loginDetails;


    @BeforeClass
    public void beforeClass() throws Exception {
        try
        {
            String dataFileName = "data/loginPage.json";
            jsonData =getClass().getClassLoader().getResourceAsStream(dataFileName);

            JSONTokener tokener = new JSONTokener(jsonData);
            loginDetails = new JSONObject(tokener);

        }catch (Exception e){

            e.printStackTrace();

        }finally {

            if(jsonData!=null){
                jsonData.close();
            }
        }

    }
    @BeforeMethod
    public void beforeMethod(Method method){

        loginPage = new LoginPage();

        System.out.println("\n" + " ****** starting test :" + method.getName() + " ******" + "\n");

    }

    @Test
    public void loginSuccess(){
        loginPage.clickonloginButton();
        loginPage.enterUserEmail(loginDetails.getJSONObject("loginDetails").getString("useremaiId"));
        loginPage.enterUserPassword(loginDetails.getJSONObject("loginDetails").getString("password"));
        loginPage.loginClick();
        System.out.println("User logged in succesfully !!!");

    }


}

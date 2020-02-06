package com.practice.tests;


import com.practice.BaseLayer.BaseTest;
import com.practice.Pages.HomePage;
import com.practice.Pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class HomePageTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage ;
    @BeforeMethod
    public void beforeMethod(Method method){

        loginPage = new LoginPage();
        homePage = new HomePage();

        System.out.println("\n" + " ****** starting test :" + method.getName() + " ******" + "\n");

    }

    @Test
    public void loginSuccess(){

       homePage.clickShopHeader();
       homePage.clickHomeText();
       homePage.addBasketButton();
       System.out.println("item added successfully!!!");

    }
}

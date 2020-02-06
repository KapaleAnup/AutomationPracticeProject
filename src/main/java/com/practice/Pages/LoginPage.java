package com.practice.Pages;

import com.practice.BaseLayer.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseTest {

    @FindBy(xpath = "//nav [@id=\"main-nav-wrap\"]//a [contains(text(),'My Account')]")
    WebElement myaccountbtn;

    @FindBy(xpath = "//p[@class=\"woocommerce-FormRow woocommerce-FormRow--wide form-row form-row-wide\"]//input[@id=\"username\"]")
    WebElement loginUsername;

    @FindBy(xpath = "//p[@class=\"woocommerce-FormRow woocommerce-FormRow--wide form-row form-row-wide\"]//input[@id=\"password\"]")
    WebElement loginPassword;

    @FindBy(xpath = "//p[@class=\"form-row\"]//input[@name=\"login\"]")
    WebElement loginbtn;

    @FindBy(xpath = "//ul[@class='woocommerce-error']")
    WebElement loginpageError;


    //Error: Password is required.
    // Error: Username is required.


    public LoginPage clickonloginButton(){
        click(myaccountbtn);
        return this;
    }
    public LoginPage enterUserEmail(String emailid){

        sendData(loginUsername,emailid);
        return this;
    }

    public LoginPage enterUserPassword(String password){

        sendData(loginPassword,password);
        return this;
    }

    public HomePage loginClick(){
        click(loginbtn);
        return new HomePage();
    }




}

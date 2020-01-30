package com.practice.Pages;

import com.practice.BaseLayer.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseTest {

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


    public LoginPage enterUserEmail(String emailid){

        sendData(loginUsername,emailid);
        return this;
    }

    public LoginPage enterUserPassword(String password){

        sendData(loginPassword,password);
        return this;
    }

    public LoginPage loginClick(){
        click(loginbtn);
        return this;
    }


}

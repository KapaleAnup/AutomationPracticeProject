package com.practice.Pages;

import com.practice.BaseLayer.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BaseTest {

    LoginPage loginPage;

    @FindBy(xpath = "//nav [@id=\"main-nav-wrap\"]//a [contains(text(),'My Account')]")
    WebElement myaccountbtn;

    @FindBy(xpath = "//p[@class='woocommerce-FormRow woocommerce-FormRow--wide form-row form-row-wide']//input[@id='reg_email']")
    WebElement useremailiId;

    @FindBy(xpath = "//p[@class='woocommerce-FormRow woocommerce-FormRow--wide form-row form-row-wide']//input[@id='reg_password']")
    WebElement userpassword;

    @FindBy(xpath = "//p[@class='woocomerce-FormRow form-row']//input[@name='register']")
    WebElement registerbtn;

    @FindBy(xpath = "//div[@id='body']//p[1]")
    WebElement getusername;

    @FindBy(xpath = "//div[@class='woocommerce-MyAccount-content']//a [contains(text(),'Sign out')]")
    WebElement signoutbtn;

    @FindBy(xpath = "//ul[@class='woocommerce-error']")
    WebElement errortext;


    public RegistrationPage clickMyAccountPage(){
        click(myaccountbtn);
        return this;
    }

    public String enteruseremailId(String username){

        sendData(useremailiId, username);
        return String.valueOf(this);
    }

    public RegistrationPage enterPassword(String password){

        sendData(userpassword,password );
        return this;
    }

    public RegistrationPage pressRegistrationbutton(){
        click(registerbtn);
        return this;
    }

    public LoginPage signout(){
        click(signoutbtn);
        return new LoginPage();
    }
    public String getUsername(){
      String username =  getusername.getText();
      return username;
    }

    public String getErrormsg(){
       return errortext.getText();
    }

    public String getErrorText(){

        return getAttribute(errortext, "text");
    }



}

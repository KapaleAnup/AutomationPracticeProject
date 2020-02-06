package com.practice.Pages;

import com.practice.BaseLayer.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseTest {

    @FindBy(xpath = "//li[@id='menu-item-40']//a[contains(text(),'Shop')]  ")
    private WebElement shopText;

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement hometext;

    @FindBy(xpath = "//div[@id='text-22-sub_row_1-0-2-0-0']//ul[contains(@class,'products’)]")
    private WebElement addBasketButtonbtn;



    public HomePage clickShopHeader(){

        click(shopText);
        return this;
    }

    public HomePage clickHomeText(){
        click(hometext);
        return this;
    }

    public HomePage addBasketButton(){
        click(addBasketButtonbtn);
        return this;
    }


}

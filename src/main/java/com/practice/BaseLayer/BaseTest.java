package com.practice.BaseLayer;

import com.practice.Utility.TestUtilis;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import javax.sound.midi.Soundbank;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class BaseTest {

    protected static WebDriver driver;
    protected static Properties prop;
    InputStream inputStream ;

    public BaseTest(){
        prop = new Properties();
        String configfilenane = "config.properties";
       inputStream = getClass().getClassLoader().getResourceAsStream(configfilenane);

        try {
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        PageFactory.initElements( driver,this);
    }

    @Parameters({"browser"})
    @BeforeClass
    public void initialize(String browser){
        try{

            if(browser.equalsIgnoreCase("Chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                System.out.println("Chrome browser has been launched..");
            }
            else if(browser.equalsIgnoreCase("firefox")){

                WebDriverManager.firefoxdriver().setup();

                driver = new FirefoxDriver();

                System.out.println("FireFox browser has been launched..");

            }
            else {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();

                System.out.println("EDge browser has been launched..");
            }

        }catch (Exception e){
            e.printStackTrace();
        }



        driver.get(prop.getProperty("weburl"));
        driver.manage().window().maximize();

    }

    public void waitforVisibility(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver,TestUtilis.Wait);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void click(WebElement element){
        waitforVisibility(element);
        element.click();
    }

    public void sendData(WebElement element, String text){
        waitforVisibility(element);
        element.sendKeys(text);
    }

    public void getAttribute(WebElement element, String text){
        waitforVisibility(element);
       element.getAttribute(text);
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}

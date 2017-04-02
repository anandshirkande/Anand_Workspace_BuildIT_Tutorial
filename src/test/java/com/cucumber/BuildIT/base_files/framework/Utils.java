package com.cucumber.BuildIT.base_files.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by shirkandea on 29/03/2017.
 */
public class Utils {

    private WebDriver driver;

    public Utils(WebDriver driver){
        this.driver=driver;

    }

    public void Click(By by){ driver.findElement(by).click();}

    public String getPageTitle(){

        return  driver.getTitle();
    }

    public void verify_Element_displayed(By by){

        wait_explicit_till_element_Displayed(by);
        boolean result =driver.findElement(by).isDisplayed();

        Assert.assertEquals(result, true, "Element not displayed");

    }

    public void verify_Element_displayed(WebElement objTest){

        wait_explicit_till_element_Displayed(objTest);
        boolean result =objTest.isDisplayed();

        Assert.assertEquals(result, true, "Element not displayed");

    }

    public void verify_Element_displayed(By by, String msg){

        wait_explicit_till_element_Displayed(by);
        boolean result =driver.findElement(by).isDisplayed();

        Assert.assertEquals(result, true, "Element not displayed. "+msg);

    }

    public String get_Element_Text(By by){
        return  driver.findElement(by).getText();
    }

    public void verify_Element_Text(By by, String text){

        String strExpected = driver.findElement(by).getText().toLowerCase().trim();
        Assert.assertEquals(strExpected, text.toLowerCase().trim(), "Element text not displayed as expected .Expected: "+text.toLowerCase()+" and Actual is : "+strExpected);

    }

    public void verify_Element_Text(WebElement objTest, String text){

        String strExpected = objTest.getText().toLowerCase().trim();
        Assert.assertEquals(strExpected, text.toLowerCase().trim(), "Element text not displayed as expected .Expected: "+text.toLowerCase()+" and Actual is : "+strExpected);

    }

    public String get_Attribute_Value(By by, String strAttribute){

        String result = driver.findElement(by).getAttribute(strAttribute);
        return  result;
    }

    public String get_Attribute_Value(WebElement objTest, String strAttribute){

        String result = objTest.getAttribute(strAttribute);
        return  result;
    }

    public Date get_Current_Date(){

        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        //getTime() returns the current date in default time zone
        Date date = calendar.getTime();
        return date;
    }


    public void wait_explicit_till_element_Displayed(By by){


        WebDriverWait waitnew=new WebDriverWait(driver,20);
        WebElement element = waitnew.until(ExpectedConditions.visibilityOfElementLocated(by));

        //  .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='WebDriver']")));

    }

    public void wait_explicit_till_element_Displayed(WebElement objTest){


        WebDriverWait waitnew=new WebDriverWait(driver,20);
        WebElement element = waitnew.until(ExpectedConditions.visibilityOf(objTest));

        //  .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='WebDriver']")));

    }


}

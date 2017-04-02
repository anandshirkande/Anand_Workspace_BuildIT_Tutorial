
package com.cucumber.BuildIT.base_files.page_objects;

import com.cucumber.BuildIT.base_files.framework.ParentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by shirkandea on 30/03/2017.
 */
public class Home_Page extends ParentPage {

    /*
    * On home page we can see weather forecast report fot five days.
    * So Home_Page class has five objects of class Daily_Forecast
    *
    * */
    private static Daily_Forcast objFirst_Day ;
    private static Daily_Forcast objSecond_Day ;
    private static Daily_Forcast objThird_Day ;
    private static Daily_Forcast objFourth_Day ;
    private static Daily_Forcast objFifth_Day ;

    public SoftAssert softAssert = new SoftAssert();

    String strTitle = "5 Weather Forecast";
    String strHeadline_Static_Part = "Five Day Weather Forecast for";

   // By HeadLine = By.xpath("//input[@id='city']/../..");
    //By City = By.xpath("//input[@id='city']");

    @FindBy(xpath="//input[@id='city']/../..")
    WebElement HeadLine;

    @FindBy(xpath="//input[@id='city']")
    WebElement City ;


    /* During constructor we will pass driver instance to parent class and
     * we will instantiate Daily_Forecast class objects */

    public Home_Page(WebDriver driver){

        super(driver);

        objFirst_Day = new Daily_Forcast(driver,"one");
        objSecond_Day = new Daily_Forcast(driver,"two");
        objThird_Day = new Daily_Forcast(driver,"three");
        objFourth_Day = new Daily_Forcast(driver,"four");
        objFifth_Day = new Daily_Forcast(driver,"five");

        PageFactory.initElements(driver, this);
    }

    public void Verify_Home_Page(){
        String pageTitle = getPageTitle();
        Assert.assertEquals(pageTitle, strTitle,"Page title does not match . Expected :"+strTitle+" and actual is :"+pageTitle);
    }

    public void Verify_Headline(String strCity){

        verify_Element_displayed(HeadLine);
        verify_Element_Text(HeadLine, strHeadline_Static_Part);

        verify_Element_displayed(City);
        String strActualCity = get_Attribute_Value(City, "value");
        Assert.assertEquals(strActualCity, strCity, "City name does not matched . Expected : "+strCity+" and actual is "+strActualCity);
    }

    /*
    *This function verify that home page displays current date and next four dates.
     */
    public void Verify_Dates(){


        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        //getTime() returns the current date in default time zone
        Date date = calendar.getTime();
        calendar.setTime(date);

        int day = calendar.get(Calendar.DATE);
        calendar.add(Calendar.DATE, 1);
        int day_Plus_1 =calendar.get(Calendar.DATE);
        calendar.add(Calendar.DATE, 1);
        int day_Plus_2=calendar.get(Calendar.DATE);
        calendar.add(Calendar.DATE, 1);
        int day_Plus_3=calendar.get(Calendar.DATE);
        calendar.add(Calendar.DATE, 1);
        int day_Plus_4=calendar.get(Calendar.DATE);

        String Current_Week_Day = new SimpleDateFormat("EE", Locale.ENGLISH).format(date.getTime());

        int Current_Day = objFirst_Day.Return_Date();
        int Current_Day_Plus_One = objSecond_Day.Return_Date();
        int Current_Day_Plus_Two = objThird_Day.Return_Date();
        int Current_Day_Plus_Three = objFourth_Day.Return_Date();
        int Current_Day_Plus_Four = objFifth_Day.Return_Date();

        softAssert.assertEquals(Current_Day, day, " Date does not match in first row");
        softAssert.assertEquals(Current_Day_Plus_One, day_Plus_1, " Date does not match in second row");
        softAssert.assertEquals(Current_Day_Plus_Two, day_Plus_2, " Date does not match in third row");
        softAssert.assertEquals(Current_Day_Plus_Three, day_Plus_3, " Date does not match in fourth row");
        softAssert.assertEquals(Current_Day_Plus_Four, day_Plus_4, " Date does not match in fifth row");
        softAssert.assertAll();
    }

    /*
    This function verify that home page displays correct week days for all five dates.
     */
    public void Verify_Days(){


        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        //getTime() returns the current date in default time zone
        Date date = calendar.getTime();
        calendar.setTime(date);

        String Current_Week_Day = new SimpleDateFormat("EE", Locale.ENGLISH).format(calendar.getTime());
        calendar.add(Calendar.DATE, 1);
        String Current_Week_Day_One = new SimpleDateFormat("EE", Locale.ENGLISH).format(calendar.getTime());
        calendar.add(Calendar.DATE, 1);
        String Current_Week_Day_Two = new SimpleDateFormat("EE", Locale.ENGLISH).format(calendar.getTime());
        calendar.add(Calendar.DATE, 1);
        String Current_Week_Day_Three = new SimpleDateFormat("EE", Locale.ENGLISH).format(calendar.getTime());
        calendar.add(Calendar.DATE, 1);
        String Current_Week_Day_Four = new SimpleDateFormat("EE", Locale.ENGLISH).format(calendar.getTime());



        String Current_Day = objFirst_Day.Return_Day();
        String Current_Day_Plus_One = objSecond_Day.Return_Day();
        String Current_Day_Plus_Two = objThird_Day.Return_Day();
        String Current_Day_Plus_Three = objFourth_Day.Return_Day();
        String Current_Day_Plus_Four = objFifth_Day.Return_Day();

        softAssert.assertEquals(Current_Day, Current_Week_Day, " Date does not match in first row");
        softAssert.assertEquals(Current_Day_Plus_One, Current_Week_Day_One, " Date does not match in second row");
        softAssert.assertEquals(Current_Day_Plus_Two, Current_Week_Day_Two, " Date does not match in third row");
        softAssert.assertEquals(Current_Day_Plus_Three, Current_Week_Day_Three, " Date does not match in fourth row");
        softAssert.assertEquals(Current_Day_Plus_Four, Current_Week_Day_Four, " Date does not match in fifth row");
        softAssert.assertAll();
    }

    /*
    This function will return object for requested day row.
     */

    public Daily_Forcast Get_Day_Report_Row_Object(String strDayNumber){

        switch (strDayNumber.toLowerCase().trim()){

            case "one" :
                return objFirst_Day;

            case "two" :
                return objSecond_Day;

            case "three" :
                return objThird_Day;

            case "four" :
                return objFourth_Day;

            case "five" :
                return objFifth_Day;

            default:
                return objFirst_Day;
        }
    }

}

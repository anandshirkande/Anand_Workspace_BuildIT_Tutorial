package com.cucumber.BuildIT.base_files.page_objects;

import com.cucumber.BuildIT.base_files.framework.ParentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by shirkandea on 29/03/2017.
 */
public class Daily_Forcast extends ParentPage{

    String strDayNumber ;
    String strDay;
    String strDate;
    String strDescription;
    String strMaxTemp;
    String strMinTemp;
    String strMaxSpeed;
    String strDirection;
    String strRainfall;
    String strPressure;


    By Byday  ;
    By ByDate ;
    By Appx_Aria_Condition  ;
    By Appx_Max_Temp  ;
    By Appx_Min_Temp  ;
    By Appx_Max_Speed  ;
    By Appx_Wind_Direction  ;
    By MaxRainfall  ;
    By MaxPrssure  ;


    Hourly_Forecast obj_Hourly_Forecast_One ;
    Hourly_Forecast obj_Hourly_Forecast_Two ;
    Hourly_Forecast obj_Hourly_Forecast_Three ;
    Hourly_Forecast obj_Hourly_Forecast_Four ;
    Hourly_Forecast obj_Hourly_Forecast_Five ;
    Hourly_Forecast obj_Hourly_Forecast_Six ;
    Hourly_Forecast obj_Hourly_Forecast_Seven ;
    Hourly_Forecast obj_Hourly_Forecast_Eight;



    public Daily_Forcast(WebDriver driver,String DayNumber){

        super(driver);

        strDayNumber = DayNumber.toLowerCase();
        Properties configProp = new Properties();
        try {
         //   InputStream in = new FileInputStream("/Users/shirkandea/Anand_Workspace/src/test/Resources/data_set.properties");

            InputStream in = this.getClass().getClassLoader().getResourceAsStream("data_set.properties");
            configProp.load(in);
             strDay = configProp.getProperty("row_"+strDayNumber+"_day");
             strDate = configProp.getProperty("row_"+strDayNumber+"_date");
             strDescription = configProp.getProperty("row_"+strDayNumber+"_description");
             strMaxTemp = configProp.getProperty("row_"+strDayNumber+"_max_temp");
             strMinTemp = configProp.getProperty("row_"+strDayNumber+"_min_temp");
             strMaxSpeed = configProp.getProperty("row_"+strDayNumber+"_speed");
             strDirection = configProp.getProperty("row_"+strDayNumber+"_direction");
             strRainfall = configProp.getProperty("row_"+strDayNumber+"_rainfall");
             strPressure = configProp.getProperty("row_"+strDayNumber+"_pressure");

        }catch(Exception e){

            e.printStackTrace();
        }

         Byday  = By.xpath("//span[contains(@class, 'name') and @data-test='"+strDay+"']");
         ByDate = By.xpath("//span[contains(@class, 'date') and @data-test='"+strDate+"']");
         Appx_Aria_Condition = By.xpath("//*[contains(@class, 'icon') and @data-test='"+strDescription+"']");
         Appx_Max_Temp = By.xpath("//span[contains(@class, 'max') and @data-test='"+strMaxTemp+"']");
         Appx_Min_Temp = By.xpath("//span[contains(@class, 'min') and @data-test='"+strMinTemp+"']");
         Appx_Max_Speed = By.xpath("//span[contains(@class, 'speed') and @data-test='"+strMaxSpeed+"']");
         Appx_Wind_Direction = By.xpath("//span[contains(@class, 'direction') and @data-test='"+strDirection+"']");
         MaxRainfall = By.xpath("//span[contains(@class, 'rainfall') and @data-test='"+strRainfall+"']");
         MaxPrssure = By.xpath("//span[contains(@class, 'pressure') and @data-test='"+strPressure+"']");

        String strChildOne = "one";
        String strChildTwo = "two";
        String strChildThree = "three";
        String strChildFour = "four";
        String strChildFive = "five";
        String strChildSix = "six";
        String strChildSeven = "seven";
        String strChildEight = "eight";


         obj_Hourly_Forecast_One = new Hourly_Forecast(driver,strDayNumber, strChildOne);
         obj_Hourly_Forecast_Two = new Hourly_Forecast(driver,strDayNumber,strChildTwo);
         obj_Hourly_Forecast_Three = new Hourly_Forecast(driver,strDayNumber,strChildThree);
         obj_Hourly_Forecast_Four = new Hourly_Forecast(driver,strDayNumber,strChildFour);
         obj_Hourly_Forecast_Five = new Hourly_Forecast(driver,strDayNumber,strChildFive);
         obj_Hourly_Forecast_Six = new Hourly_Forecast(driver,strDayNumber,strChildSix);
         obj_Hourly_Forecast_Seven = new Hourly_Forecast(driver,strDayNumber,strChildSeven);
         obj_Hourly_Forecast_Eight = new Hourly_Forecast(driver, strDayNumber,strChildEight);
    }


    public int Return_Date(){

        return Integer.parseInt(get_Element_Text(ByDate));
    }

    public String Return_Day(){


        return get_Element_Text(Byday);
    }

    public void Click_Day_Report(){
        Click(ByDate);
    }


    public Hourly_Forecast Get_Hourly_Report_Row_Object(String strChildNumber){

        switch (strChildNumber.toLowerCase().trim()){

            case "one" :
                return obj_Hourly_Forecast_One;


            case "two" :
                return obj_Hourly_Forecast_Two;


            case "three" :
                return obj_Hourly_Forecast_Three;


            case "four" :
                return obj_Hourly_Forecast_Four;


            case "five" :
                return obj_Hourly_Forecast_Five;

            case "six":
                return obj_Hourly_Forecast_Six;

            case "seven":
                return obj_Hourly_Forecast_Seven;

            case "eight":
                return obj_Hourly_Forecast_Eight;


            default:

                return obj_Hourly_Forecast_Eight;
        }
    }

    public void Verify_All_Elements_Displayed(String strDayNumber){

        verify_Element_displayed(Byday, "Verify day element for day row "+strDayNumber);
        verify_Element_displayed(ByDate,"Verify date element for day row "+strDayNumber);
        verify_Element_displayed(Appx_Aria_Condition,"Verify Aria condition day element for day row "+strDayNumber);
        verify_Element_displayed(Appx_Max_Temp,"Verify max temp element for day row "+strDayNumber);
        verify_Element_displayed(Appx_Min_Temp,"Verify min temp element for day row "+strDayNumber);
        verify_Element_displayed(Appx_Max_Speed,"Verify max speed element for day row "+strDayNumber);
        verify_Element_displayed(Appx_Wind_Direction,"Verify direction element for day row "+strDayNumber);
        verify_Element_displayed(MaxRainfall,"Verify rainfall element for day row "+strDayNumber);
        verify_Element_displayed(MaxPrssure,"Verify pressure element for day row "+strDayNumber);

    }


}

package com.cucumber.BuildIT.base_files.glue;

import com.cucumber.BuildIT.base_files.framework.ParentScenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

/**
 * Created by shirkandea on 29/03/2017.
 */
public class Base_Step_Definition extends ParentScenario {

    @Before
    public void BeforeScenario(){
        Before_Setup();
    }


    @Given("I have entered the city as \"(.*)\" to know weather forecast report")
    public void Fetch_Weather_Forcast_For_City(String strCity){
       Launch_URL("http://localhost:3000/");
    }

    @When("I see weather forecast report")
    public void Verify_Home_Page(){
       obj_Home_Page.Verify_Home_Page();
    }


    @After
    public void After_Scenario(){
        After_Setup();
    }

}

package com.qa.opencart.tests;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HirestAutomate {

    PlaywrightFactory pf;
    Page page;

    LoginPage loginPage;

    @BeforeTest
    public void setup(){
        pf=new PlaywrightFactory();
        page=  pf.initBrowser("chromium");
        loginPage =new LoginPage(page);
    }


    @Test
    public void autoHirish(){
        loginPage.clickonLoginAsJobSerach();
        loginPage.clickonclickOnSignIn();
        loginPage.enterUsername();
        loginPage.password();
        loginPage.clickonsubmitButton();
        loginPage.selectexperienceFilter();
//        loginPage.selectanyLocationFilter();
        loginPage.selectpostingFilter();
        loginPage.clickonapplyFilterButton();
        loginPage.selectmultycheck();
        loginPage.selectallpostbtn();


    }


    @AfterTest
    public void tearDown(){

//        page.context().browser().close();
    }

}

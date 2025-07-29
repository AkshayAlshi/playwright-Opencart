package com.qa.opencart.tests;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest1 {
    PlaywrightFactory pf;
    Page page;

    HomePage homePage;

    @BeforeTest
    public void setup(){
        pf=new PlaywrightFactory();
       page=  pf.initBrowser("chromium");
       homePage =new HomePage(page);
    }

    @Test
    public void homePageTitleTest(){
      String  actualtitle=  homePage.getHomePageTitle();
        Assert.assertEquals(actualtitle,"Your Store");

    }

    @Test
    public void homePageUrlTest(){
        String actualUrl=homePage.getHomePageUrl();
        Assert.assertEquals(actualUrl,"https://naveenautomationlabs.com/opencart/");
    }

    @Test
    public void searchTest(){
       String actualSearchHeader= homePage.doSearch("Mackbook");

    }



    @AfterTest
    public void tearDown(){
        page.context().browser().close();
    }
}

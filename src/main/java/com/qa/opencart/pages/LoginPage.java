package com.qa.opencart.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.ArrayList;
import java.util.List;

public class LoginPage {

    Page page;
    private  String  JobseekerLoginButton ="//button//p[contains(text(),'Jobseeker Login')]";
    private  String clickOnSignIn ="//p//a[contains(text(),'Sign In')]";
    private  String enterEmail ="//input[contains(@id,':r7:')]";
    private String enterPassword = "//input[contains(@id,':ra:')]";
    private String submitButton="//button[@type='submit']";


    private String experienceFilter = "//div[@id='lotus-select-experience']";
    private  String selectexperience="(//div//p[contains(text(),'4 - 6 yrs')])[1]";

    private  String anyLocationFilter="//div[@id='lotus-select-loc']";
    private String resetButton="//ul[@role='listbox']//li//p[text()='Reset']";
    private String searchCity="//ul[@role='listbox']//li//input[@id=':r2b:']";
    private String clickOnCity="//img[@alt='checkbox']";
    private String postingFilter="//div[@id='lotus-select-posting']";
    private String selectposting ="//ul[@role='listbox']//li//p[text()='< 3 Days']";
    private String applyFilterButton="//button//p[text()='Apply']";

    private String selectmultipalcheck="//div[@class='MuiBox-root mui-style-1wqkpd7']//child::span//child::input[@type='checkbox']";

    private String selectallbtn="//button[contains(text(),'Apply All')]";


    public LoginPage(Page page){
        this.page=page;
    }

    public void clickonLoginAsJobSerach(){
        Locator JobLoginButton=page.locator(JobseekerLoginButton);
        if (JobLoginButton.isEnabled()){
            JobLoginButton.click();
        }else {
            System.out.println("JobLoginButton is not enabled");
        }

    }



    public void clickonclickOnSignIn(){
        Locator SignIn=page.locator(clickOnSignIn);
        if (SignIn.isEnabled()){
            SignIn.click();
        }else {
            System.out.println("SignIn is not enabled");
        }

    }


    public void enterUsername(){
        Locator username=page.locator(enterEmail);
        if (username.isEnabled()){
            username.fill("akshayalshi10@gmail.com");
        }else {
            System.out.println("username is not enabled");
        }

    }


    public void password(){
        Locator Password=page.locator(enterPassword);
        if (Password.isEnabled()){
            Password.fill("Akshay@123");
        }else {
            System.out.println("Password is not enabled");
        }

    }


    public void clickonsubmitButton(){
        Locator sublitbutton=page.locator(submitButton);
        if (sublitbutton.isVisible()){
            sublitbutton.click();
        }else {
            System.out.println("sublitbutton is display");
        }
    }


    public void selectexperienceFilter(){
        Locator clickOnexperienceFilter=page.locator(experienceFilter);
        Locator clickOnselectexperience=page.locator(selectexperience);

        if (clickOnexperienceFilter.isVisible()){
            clickOnexperienceFilter.click();
            if (clickOnselectexperience.isVisible()){
                clickOnselectexperience.click();
            }
        }else {
            System.out.println("problem in selectexperienceFilter");
        }
    }



    public void selectanyLocationFilter(){
        Locator clickOnanyLocationFilter=page.locator(anyLocationFilter);
        Locator clickOnseresetButton=page.locator(resetButton);
        Locator clickOnsearchCity=page.locator(searchCity);
        Locator clickOnclickOnCity=page.locator(clickOnCity);

        if (clickOnanyLocationFilter.isVisible()){
            clickOnanyLocationFilter.click();
            if (clickOnseresetButton.isVisible()){
                clickOnseresetButton.click();
                if (clickOnsearchCity.isEnabled()){
                    clickOnsearchCity.fill("pune");
                    clickOnclickOnCity.click();

                }
            }
        }else {
            System.out.println("problem in selectanyLocationFilter");
        }
    }

    public void selectpostingFilter(){
        Locator clickOnpostingFilter=page.locator(postingFilter);
        Locator clickOnselectposting=page.locator(selectposting);

        if (clickOnpostingFilter.isVisible()){
            clickOnpostingFilter.click();
            if (clickOnselectposting.isVisible()){
                clickOnselectposting.click();
            }
        }else {
            System.out.println("problem in selectpostingFilter");
        }
    }


    public void clickonapplyFilterButton(){

        Locator applyFilterBtn=page.locator(applyFilterButton);
        if(applyFilterBtn.isVisible()){
            applyFilterBtn.click();
        }else {
            System.out.println("applyFilterBtn is not visible");
        }
    }


    public void selectmultycheck(){
            Locator checkboxes = page.locator(selectmultipalcheck);
            int count = checkboxes.count();

            List<Integer> disabledIndexes = new ArrayList<>();

            for (int i = 0; i < count; i++) {
                Locator checkbox = checkboxes.nth(i);

                if (checkbox.isEnabled()) {
                    checkbox.click();
                    System.out.println("✅ Clicked checkbox at index: " + i);
                } else {
                    System.out.println("❌ Index " + i + ": This element is not enabled.");
                    disabledIndexes.add(i);
                }
            }

            if (!disabledIndexes.isEmpty()) {
                throw new RuntimeException("⚠️ The following checkbox indexes are not enabled: " + disabledIndexes);
            }
        }

        public void selectallpostbtn(){
        Locator selectall=page.locator(selectallbtn);
        if (selectall.isDisabled()){
            selectall.click();
        }else {
            System.out.println("selectall button is not desplayed");
        }
        }

    }









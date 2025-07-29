package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {

    Page page;
    private  String  search ="//input[@name='search']";
    private  String searchIcon ="(//button[@type='button'])[4]";
    private  String searchPageHeader ="div#content h1";


    public HomePage(Page page){
        this.page=page;
    }


    //page actions

    public String getHomePageTitle(){
        String title=page.title();
        System.out.println("page title : "+title );
        return title;
    }

    public String getHomePageUrl(){
        String url = page.url();
        System.out.println("Page Url is : "+ url);
        return url;
    }

    public String doSearch(String productName){
        page.fill(search,productName);
        page.click(searchIcon);
       String header=  page.textContent(searchPageHeader);
        System.out.println("search header :"+ header);
        return header;
    }
}

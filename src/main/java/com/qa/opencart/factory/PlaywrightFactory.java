package com.qa.opencart.factory;

import com.microsoft.playwright.*;

public class PlaywrightFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;

    public Page initBrowser(String browserName) {

        System.out.println("browser name is : " + browserName);
        playwright = Playwright.create();

        switch (browserName.toLowerCase()) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;

            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;

            case "safari":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;

            case "chrome":
                browser = playwright.chromium().launch(
                        new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)
                );
                break;

            default:
                throw new IllegalArgumentException("Please pass the correct browser name: " + browserName);
        }

        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate("https://www.hirist.tech/");
//        page.navigate("https://naveenautomationlabs.com/opencart/");

        return page;
    }

    public void closeBrowser() {
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}

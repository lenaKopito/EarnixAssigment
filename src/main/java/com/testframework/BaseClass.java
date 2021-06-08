package com.testframework;

import com.testframework.pages.Page;
import com.testframework.utils.logs.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static com.testframework.utils.PropertyUtil.getPropertyByKey;

public class BaseClass extends WebDriverManager implements Page {

    public WebDriver driver;
    public WebDriverWait wait;
    public String baseUrl;


    public void setup() {
        driver = initDriver();
        baseUrl = getPropertyByKey("application.url");
        Log.info("Finished loading driver and base url");
    }

    public void cleanup() {
        driver.quit();
        Log.info("Closed driver");
    }

    @Override
    public void goToPage(String url) {
        Log.info("Open this page " + url);
        driver.get(url);
    }

    @Override
    public void waitForCurrentUrl(String url) {
        Log.info("Wait for this page: " + url);
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlToBe(url));
    }

    @Override
    public String waitForPageTitle(String title) {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleIs(title));
        Log.info("Wait for following page title to appear: " + title);
        return driver.getTitle();
    }
}

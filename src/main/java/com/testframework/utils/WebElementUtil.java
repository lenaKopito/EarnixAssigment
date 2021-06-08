package com.testframework.utils;

import com.testframework.utils.logs.Log;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class WebElementUtil {

    private WebDriver driver;
    private WebDriverWait wait;

    public WebElementUtil(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitAndClick(WebElement element) {
        waitForElementToBeClickable(element);
        element.click();
    }

    public void waitAndSendKeys(WebElement element, String keys) {
        waitForElementToBeVisible(element);
        element.clear();
        element.sendKeys(keys);
    }

    public void sendKeys(WebElement element) {
        element.sendKeys(Keys.ENTER);
    }

    public void openMenu(WebElement menuTitle) {
        waitAndClick(menuTitle);
    }

    public void openMenuAndClickOnMenuItem(WebElement menuTitle, WebElement menuItem) {
        waitForElementToBeClickable(menuTitle);
        Actions act = new Actions(driver);
        act.moveToElement(menuTitle).perform();
        waitAndClick(menuItem);
    }

    public String getElementText(WebElement element) {
        waitForElementToBeVisible(element);
        return element.getText();
    }

    public List<String> getElementsText(List<WebElement> elements) {
        scrollPage(elements.get(elements.size() - 1));
        waitForElementToBeVisible(elements.get(elements.size() - 1));
        List<String> elementsText = new ArrayList<>();
        for (WebElement ele : elements) {
            elementsText.add(ele.getText());
        }
        return elementsText;
    }

    public void scrollPage(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //sleep 5 seconds so page can fully load before scrolling
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.info("Scroll to last given page element");
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
}

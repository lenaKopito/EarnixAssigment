package com.testframework.pages;

import com.testframework.utils.WebElementUtil;
import com.testframework.utils.logs.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Homepage {

    private WebDriver driver;
    private WebElementUtil webElementUtil;
    private String searchText;

    @FindBy(xpath = "//li//a[@href = '/search']")
    private WebElement searchLink;

    @FindBy(xpath = "//input[@type = 'search']")
    private WebElement searchField;

    @FindBy(css = "div.ProductItem")
    private WebElement searchResult;

    @FindBy(xpath = "//a[text() = 'Pattern']")
    private WebElement patternTopMenuItem;

    @FindBy(xpath = "//li//a[@href = '/collections/retro']")
    private WebElement retroDropdownItem;

    @FindBy(xpath = "//li//a[@href = '/collections/tie-bars']")
    private WebElement tieBarTopMenuItem;

    public Homepage(WebDriver driver) {
        this.driver = driver;
        webElementUtil = new WebElementUtil(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickSearchLnk() {
        Log.info("Click on search link");
        webElementUtil.waitAndClick(searchLink);
    }

    public void typeSearchText(String searchText) {
        Log.info("Search for this text: " + searchText);
        webElementUtil.waitAndSendKeys(searchField, searchText);
    }

    public void sendEnterKey() {
        Log.info("Send \"Enter\" key");
        webElementUtil.sendKeys(searchField);
    }

    public void clickSearchResult() {
        Log.info("Click on search result");
        webElementUtil.waitAndClick(searchResult);
    }

    public void openTieBarTopMenu() {
        Log.info("Click on \"TieBar\" item from Top Menu");
        webElementUtil.openMenu(tieBarTopMenuItem);
    }

    public void openPatternMenuAndClickOnDropdownItem() {
        Log.info("Mouse over \"Pattern\" item from Top Menu and click on \"Retro\" item from the Dropdown Menu");
        webElementUtil.openMenuAndClickOnMenuItem(patternTopMenuItem, retroDropdownItem);
    }

}

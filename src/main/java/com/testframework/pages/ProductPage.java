package com.testframework.pages;

import com.testframework.utils.WebElementUtil;
import com.testframework.utils.logs.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class ProductPage {
    private WebDriver driver;
    private WebElementUtil webElementUtil;

    @FindBy(xpath = "//div[@class = 'Rte']")
    private WebElement tieDescription;

    @FindBy(css = "span.ProductMeta__Price")
    private WebElement tiePrice;

    @FindBy(css = ".ProductItem__Title.Heading")
    private List<WebElement> tiesListDetails;

    @FindBy(css = ".ProductItem__Price.Price")
    private List<WebElement> tiesListPrice;


    public ProductPage(WebDriver driver) {
        this.driver = driver;
        webElementUtil = new WebElementUtil(driver);
        PageFactory.initElements(driver, this);
    }

    public String getTieDescription() {
        Log.info("Got tie description");
        return webElementUtil.getElementText(tieDescription);
    }

    public String getTiePrice() {
        Log.info("Got tie price");
        return webElementUtil.getElementText(tiePrice);
    }

    public List<String> getTiesTextFromList() {
        List<String> tiesText = webElementUtil.getElementsText(tiesListDetails);
        Log.info("Got all ties description");
        return tiesText;
    }

    public List<String> getTiesPriceFromList() {
        List<String> tiesPrice = webElementUtil.getElementsText(tiesListPrice);
        Log.info("Got all ties price");
        return tiesPrice;
    }
}

import com.testframework.BaseClass;
import com.testframework.pages.Homepage;
import com.testframework.pages.ProductPage;
import com.testframework.utils.logs.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.testframework.utils.CommonUtils.sumOfListElements;

public class TopMenuTest extends BaseClass {
    private Homepage homepage;
    private ProductPage productpage;
    private String searchText = "BLACK POPLIN SKINNY TIE";
    private String homePageTitle = "Skinny Ties | Nothing but skinny ties. – SkinnyTiesShop";
    private String retroPatternUrl = "https://skinnyties.com/collections/retro";
    private String tieBarUrl = "https://skinnyties.com/collections/tie-bars";

    @BeforeMethod
    public void setup() {
        super.setup();
        homepage = new Homepage(driver);
        productpage = new ProductPage(driver);
        goToPage(baseUrl);
    }

    @AfterMethod
    public void cleanup() {
        super.cleanup();
    }

    @Test
    void selectRetroPatternAndVerifyProductsSizeTest() {
        waitForPageTitle(homePageTitle);
        homepage.openPatternMenuAndClickOnDropdownItem();
        waitForCurrentUrl(retroPatternUrl);
        double size = sumOfListElements(productpage.getTiesTextFromList());
        Log.info("This is the sum of all displayed products sizes: " + size);

        Assert.assertTrue(size > 4, "All displayed products size is equal to 4\" or lower than 4\". The size is: " + size);

    }

    @Test
    void selectTieBarAndVerifyProductsPriceTest() {
        waitForPageTitle(homePageTitle);
        homepage.openTieBarTopMenu();
        waitForCurrentUrl(tieBarUrl);
        double price = sumOfListElements(productpage.getTiesPriceFromList());
        Log.info("This is the sum of all displayed products prices: " + price);

        Assert.assertTrue(price > 20, "All displayed products price is equal to 20$ or lower than 20$. The price is: " + price);

    }

}

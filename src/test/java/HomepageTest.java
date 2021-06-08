import com.testframework.BaseClass;
import com.testframework.pages.Homepage;
import com.testframework.pages.ProductPage;
import com.testframework.utils.logs.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.testframework.utils.CommonUtils.parseStringToDouble;

public class HomepageTest extends BaseClass {
    private Homepage homepage;
    private ProductPage productpage;
    private String searchText = "BLACK POPLIN SKINNY TIE";
    private String homePageTitle = "Skinny Ties | Nothing but skinny ties. – SkinnyTiesShop";
    private String afterSearchPageTitle = "Search: 1 result found for \"" + searchText + "\" – SkinnyTiesShop";

    @BeforeMethod
    public void setup() {
        super.setup();
        homepage = new Homepage(driver);
        goToPage(baseUrl);
        productpage = new ProductPage(driver);
    }

    @AfterMethod
    public void cleanup() {
        super.cleanup();
    }

    @Test
    void searchForItemAndVerifyPriceTest() {
        waitForPageTitle(homePageTitle);
        homepage.clickSearchLnk();
        homepage.typeSearchText(searchText);
        homepage.sendEnterKey();
        waitForPageTitle(afterSearchPageTitle);
        homepage.clickSearchResult();
        String desc = productpage.getTieDescription();
        Log.info("Tie description: " + desc);
        String price = productpage.getTiePrice();
        Log.info("Tie price: " + price);
        double parsedPrice = parseStringToDouble(price);

        Assert.assertTrue(parsedPrice > 10, "Tie price is equal to 10$ or lower than 10$. The price is: " + parsedPrice);
    }


}

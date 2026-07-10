package Test;

import Pages.ProductPage;
import Pages.ComparePage;
import org.testng.annotations.Test;

public class CompareTest extends BaseTest {

    ProductPage productPage;
    ComparePage comparePage;

    @Test
    public void testCompareCycle() {
        productPage = new ProductPage(driver);
        productPage.AddProductToCompuure();
        comparePage = new ComparePage(driver);
        comparePage.RemoveProductFromCompare();
    }
}

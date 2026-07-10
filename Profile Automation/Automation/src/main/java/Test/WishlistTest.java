package Test;

import Pages.ProductPage;
import Pages.WishlistPage;
import org.testng.annotations.Test;

public class WishlistTest extends BaseTest{

    ProductPage productPage;
    WishlistPage wishlistPage;

    @Test
    public void testWishlistCycle() {
        productPage = new ProductPage(driver);
        productPage.AddProductToWishlist();
        wishlistPage = new WishlistPage(driver);
        wishlistPage.RemoveProductFromWishlist();
    }
}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Cart {

    WebDriver driver;

    public Cart(WebDriver driver) {
        this.driver = driver;
    }


    By CartIcon = By.cssSelector("#entry_217825 > a > div.cart-icon > div > svg");
    By GoToCartBtn = By.xpath("//*[@id=\"notification-box-top\"]/div/div[2]/div[2]/div[1]/a");
    By QuantityField = By.cssSelector("#content > form > div > table > tbody > tr > td:nth-child(4) > div > input");
    By UpdateQuantityBtn = By.cssSelector("#content > form > div > table > tbody > tr > td:nth-child(4) > div > div > button.btn.btn-primary");
    By DeleteItemBtn = By.cssSelector("#content > form > div > table > tbody > tr > td:nth-child(4) > div > div > button.btn.btn-danger");
    By UseCouponShowBtn = By.cssSelector("#accordion > div:nth-child(1) > h5 > i");
    By EstimateShippingShowBtn = By.cssSelector("#accordion > div:nth-child(2) > h5 > i");
    By GiftCertificateShowBtn = By.cssSelector("#accordion > div:nth-child(3) > h5 > i");
    By GoToCartAfterAddBtn = By.cssSelector("div > div.toast-body > div.form-row > div:nth-child(1) > a");
    By CouponField = By.cssSelector("#input-coupon");
    By ApplyCouponBtn = By.cssSelector("#button-coupon");
    By GiftField = By.cssSelector("#input-voucher");
    By ApplyGift = By.cssSelector("#button-voucher");
    By Country = By.cssSelector("#input-country");
    By State = By.cssSelector("#input-zone");
    By PostCode = By.cssSelector("#input-postcode");
    By GetQuotesBtn = By.cssSelector("#button-quote");
    By FlatRate = By.cssSelector("#modal-shipping > div > div > div.modal-body > div > label > input[type=radio]");
    By ApplyShippingBtn = By.cssSelector("#button-shipping");
    By CancelShippingBtn = By.cssSelector("#modal-shipping > div > div > div.modal-footer > button.btn.btn-light");
    By ContinueShoppingBtn = By.cssSelector("#content > div.buttons.d-flex > a.btn.btn-lg.btn-secondary.mr-auto");
    By CheckoutBtn = By.cssSelector("#content > div.buttons.d-flex > a.btn.btn-lg.btn-primary");

    HomePage homePage;

    public void GoToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        driver.findElement(CartIcon).click();
        WebElement GoToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(GoToCartBtn));
        actions.moveToElement(GoToCart).click().perform();
    }

    public void GotoCartAfterAdd() throws InterruptedException {
        homePage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        homePage.Add();
        WebElement GoToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(GoToCartAfterAddBtn));
        actions.moveToElement(GoToCart).click().perform();
    }

    public void ChangeQuantity(String quantity){
            WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
            WebElement quantityField = wait.until(ExpectedConditions.visibilityOfElementLocated(QuantityField));
            quantityField.clear();
            quantityField.sendKeys(quantity);
            driver.findElement(UpdateQuantityBtn).click();
    }

    public void DeleteItem() {
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteItemBtn));
        driver.findElement(DeleteItemBtn).click();
    }

    public void AddCoupon(String Coupon){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(UseCouponShowBtn));
        driver.findElement(UseCouponShowBtn).click();
        WebElement _CouponField = wait.until(ExpectedConditions.visibilityOfElementLocated(CouponField));
        _CouponField.sendKeys(Coupon);
        driver.findElement(ApplyCouponBtn).click();
    }

    public void AddGift(String Gift){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(GiftCertificateShowBtn));
        driver.findElement(GiftCertificateShowBtn).click();
        WebElement _GiftField = wait.until(ExpectedConditions.visibilityOfElementLocated(GiftField));
        _GiftField.sendKeys(Gift);
        driver.findElement(ApplyGift).click();
    }

    public void EstimateShipping(String country,String state,String postalCode) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(EstimateShippingShowBtn));
        driver.findElement(EstimateShippingShowBtn).click();
        //select country
        Thread.sleep(1000);
        WebElement CountrySelector = wait.until(ExpectedConditions.visibilityOfElementLocated(Country));
        Select countrySelect = new Select(CountrySelector);
        countrySelect.selectByVisibleText(country);
        //select state
        Thread.sleep(2000);
        WebElement StateSelector = wait.until(ExpectedConditions.visibilityOfElementLocated(State));
        Select stateSelect = new Select(StateSelector);
        stateSelect.selectByVisibleText(state);
        //enter PostalCode
        wait.until(ExpectedConditions.visibilityOfElementLocated(PostCode));
        driver.findElement(PostCode).sendKeys(postalCode);
        //click Get Quotes
        wait.until(ExpectedConditions.visibilityOfElementLocated(GetQuotesBtn));
        driver.findElement(GetQuotesBtn).click();
    }

    public void applyFlatShipping(){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        //Choose flat rate
        wait.until(ExpectedConditions.visibilityOfElementLocated(FlatRate));
        driver.findElement(FlatRate).click();
        //Apply
        wait.until(ExpectedConditions.elementToBeClickable(ApplyShippingBtn));
        driver.findElement(ApplyShippingBtn).click();
    }

    public void CancelEstimateShipping(){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        //Choose flat rate
        wait.until(ExpectedConditions.visibilityOfElementLocated(FlatRate));
        driver.findElement(FlatRate).click();
        //Cancel
        wait.until(ExpectedConditions.elementToBeClickable(CancelShippingBtn));
        driver.findElement(CancelShippingBtn).click();
    }

    public void ContinueShopping(){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ContinueShoppingBtn));
        driver.findElement(ContinueShoppingBtn).click();
    }

    public void GoToCheckout(){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutBtn));
        driver.findElement(CheckoutBtn).click();
    }

}
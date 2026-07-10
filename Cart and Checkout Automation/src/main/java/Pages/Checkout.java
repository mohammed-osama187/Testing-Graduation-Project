package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Checkout {
    WebDriver driver;
    WebDriverWait wait;

    // تم تعريف الـ wait هنا ليكون جاهزاً في كل الميثودز تلقائياً
    public Checkout(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // --- Locators ---
    By LoginBtn = By.cssSelector("#form-checkout > div > div.col-lg-5.mb-5.mb-lg-0 > div > div:nth-child(1) > div > div:nth-child(1) > label");
    By RegisterBtn = By.cssSelector("#form-checkout > div > div.col-lg-5.mb-5.mb-lg-0 > div > div:nth-child(1) > div > div:nth-child(2) > label");
    By GuestBtn = By.cssSelector("#form-checkout > div > div.col-lg-5.mb-5.mb-lg-0 > div > div:nth-child(1) > div > div:nth-child(3) > label");
    By FirstNameField = By.cssSelector("#input-payment-firstname");
    By LastNameField = By.cssSelector("#input-payment-lastname");
    By EmailField = By.cssSelector("#input-payment-email");
    By EmailLoginField = By.cssSelector("#input-login-email");
    By PasswordLoginField = By.cssSelector("#input-login-password");
    By TelephoneField = By.cssSelector("#input-payment-telephone");
    By PasswordField = By.cssSelector("#input-payment-password");
    By ConfirmPasswordField = By.cssSelector("#input-payment-confirm");
    By CompanyField = By.cssSelector("#input-payment-company");
    By Address1Field = By.cssSelector("#input-payment-address-1");
    By Address2Field = By.cssSelector("#input-payment-address-2");
    By CityField = By.cssSelector("#input-payment-city");
    By PostCodeField = By.cssSelector("#input-payment-postcode");
    By CountryField = By.cssSelector("#input-payment-country");
    By RegionField = By.cssSelector("#input-payment-zone");
    By DeliveryAndPaymentAddressCheckBox = By.cssSelector("#payment-address > div.custom-control.custom-checkbox > label");
    By FirstNameSA = By.cssSelector("#input-shipping-firstname");
    By LastNameSA = By.cssSelector("#input-shipping-lastname");
    By CompanySA = By.cssSelector("#input-shipping-company");
    By Address1SA = By.cssSelector("#input-shipping-address-1");
    By Address2SA = By.cssSelector("#input-shipping-address-2");
    By CitySA = By.cssSelector("#input-shipping-city");
    By PostCodeSA = By.cssSelector("#input-shipping-postcode");
    By CountrySA = By.cssSelector("#input-shipping-country");
    By RegionSA = By.cssSelector("#input-shipping-zone");
    By CommentField = By.cssSelector("#input-comment");
    By SubscriptionCheckBox = By.cssSelector("#form-checkout > div > div.col-lg-7.mb-5.mb-lg-0 > div > div:nth-child(3) > label");
    By PrivacyPolicyCheckBox = By.cssSelector("#form-checkout > div > div.col-lg-7.mb-5.mb-lg-0 > div > div:nth-child(4) > label");
    By TermsAndConditionCheckBox = By.cssSelector("#form-checkout > div > div.col-lg-7.mb-5.mb-lg-0 > div > div:nth-child(6) > label");
    By ContinueBtn = By.cssSelector("#button-save");
    By CheckOutBtn = By.cssSelector("#notification-box-top > div > div.toast-body > div.form-row > div:nth-child(2) > a");
    By loginBtn = By.cssSelector("#button-login");
    By ChooseExistBillingAddress = By.cssSelector("#payment-address > div:nth-child(2) > div.custom-control.custom-radio > label");
    By ChooseNewBillingAddress = By.cssSelector("#payment-address > div:nth-child(3) > div > label");
    By QuantityField = By.xpath("//*[starts-with(@id, 'quantity_')]");
    By UpdateQuantityBtn = By.cssSelector("#checkout-cart > table > tbody > tr > td:nth-child(3) > div > div > button.btn.btn-primary");
    By DeleteItem = By.cssSelector("#checkout-cart > table > tbody > tr > td:nth-child(3) > div > div > button.btn.btn-danger");
    By LoginTelephoneField = By.cssSelector("#input-telephone");

    public void GotoCheckout(){
        wait.until(ExpectedConditions.elementToBeClickable(CheckOutBtn)).click();
    }

    public void FillGuest(String FirstName, String LastName, String Email, String Telephone, String Company, String Address1, String Address2, String City, String PostCode, String Country, String Region) {
        wait.until(ExpectedConditions.elementToBeClickable(GuestBtn)).click();

        driver.findElement(FirstNameField).sendKeys(FirstName);
        driver.findElement(LastNameField).sendKeys(LastName);
        driver.findElement(EmailField).sendKeys(Email);
        driver.findElement(TelephoneField).sendKeys(Telephone);
        driver.findElement(CompanyField).sendKeys(Company);
        driver.findElement(Address1Field).sendKeys(Address1);
        driver.findElement(Address2Field).sendKeys(Address2);
        driver.findElement(CityField).sendKeys(City);
        driver.findElement(PostCodeField).sendKeys(PostCode);

        WebElement countrySelector = wait.until(ExpectedConditions.elementToBeClickable(CountryField));
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(CountryField, By.xpath(".//option[normalize-space()='" + Country + "']")));
        Select countrySelect = new Select(countrySelector);
        countrySelect.selectByVisibleText(Country);

        WebElement regionSelector = wait.until(ExpectedConditions.elementToBeClickable(RegionField));
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(RegionField, By.xpath(".//option[normalize-space()='" + Region + "']")));
        Select regionSelect = new Select(regionSelector);
        regionSelect.selectByVisibleText(Region);
    }

    public void FillRegister(String FirstName, String LastName, String Email, String Telephone, String Password, String ConfirmPassword, String Company, String Address1, String Address2, String City, String PostCode, String Country, String Region) {
        wait.until(ExpectedConditions.elementToBeClickable(RegisterBtn)).click();

        driver.findElement(FirstNameField).sendKeys(FirstName);
        driver.findElement(LastNameField).sendKeys(LastName);
        driver.findElement(EmailField).sendKeys(Email);
        driver.findElement(TelephoneField).sendKeys(Telephone);
        driver.findElement(PasswordField).sendKeys(Password);
        driver.findElement(ConfirmPasswordField).sendKeys(ConfirmPassword);
        driver.findElement(CompanyField).sendKeys(Company);
        driver.findElement(Address1Field).sendKeys(Address1);
        driver.findElement(Address2Field).sendKeys(Address2);
        driver.findElement(CityField).sendKeys(City);
        driver.findElement(PostCodeField).sendKeys(PostCode);

        WebElement countrySelector = wait.until(ExpectedConditions.elementToBeClickable(CountryField));
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(CountryField, By.xpath(".//option[normalize-space()='" + Country + "']")));
        Select countrySelect = new Select(countrySelector);
        countrySelect.selectByVisibleText(Country);

        WebElement regionSelector = wait.until(ExpectedConditions.elementToBeClickable(RegionField));
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(RegionField, By.xpath(".//option[normalize-space()='" + Region + "']")));
        Select regionSelect = new Select(regionSelector);
        regionSelect.selectByVisibleText(Region);
    }

    public void FillDifferentShipping(String FirstName, String LastName, String Company, String Address1, String Address2, String City, String PostCode, String Country, String Region) {
        wait.until(ExpectedConditions.elementToBeClickable(DeliveryAndPaymentAddressCheckBox)).click();

        driver.findElement(FirstNameSA).sendKeys(FirstName);
        driver.findElement(LastNameSA).sendKeys(LastName);
        driver.findElement(CompanySA).sendKeys(Company);
        driver.findElement(Address1SA).sendKeys(Address1);
        driver.findElement(Address2SA).sendKeys(Address2);
        driver.findElement(CitySA).sendKeys(City);
        driver.findElement(PostCodeSA).sendKeys(PostCode);

        // Country SA
        WebElement countrySelector = wait.until(ExpectedConditions.elementToBeClickable(CountrySA));
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(CountrySA, By.xpath(".//option[normalize-space()='" + Country + "']")));
        Select countrySelect = new Select(countrySelector);
        countrySelect.selectByVisibleText(Country);

        // Region SA
        WebElement regionSelector = wait.until(ExpectedConditions.elementToBeClickable(RegionSA));
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(RegionSA, By.xpath(".//option[normalize-space()='" + Region + "']")));
        Select regionSelect = new Select(regionSelector);
        regionSelect.selectByVisibleText(Region);
    }

    public void FillLogin(String Email, String Password) {
        wait.until(ExpectedConditions.elementToBeClickable(LoginBtn)).click();
        driver.findElement(EmailLoginField).sendKeys(Email);
        driver.findElement(PasswordLoginField).sendKeys(Password);
        driver.findElement(loginBtn).click();
    }

    public void CompleteLoginWithExistBillingAddress(String Telephone){
        WebElement loginTelephoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginTelephoneField));
        loginTelephoneField.clear();
        loginTelephoneField.sendKeys(Telephone);
        driver.findElement(ChooseExistBillingAddress).click();
    }

    public void CompleteLoginWithNewBillingAddress(String FirstName, String LastName, String Telephone, String Company, String Address1, String Address2, String City, String PostCode, String Country, String Region) {
        WebElement loginTelephoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginTelephoneField));
        loginTelephoneField.clear();
        loginTelephoneField.sendKeys(Telephone);
        driver.findElement(ChooseNewBillingAddress).click();

        driver.findElement(FirstNameField).sendKeys(FirstName);
        driver.findElement(LastNameField).sendKeys(LastName);
        driver.findElement(CompanyField).sendKeys(Company);
        driver.findElement(Address1Field).sendKeys(Address1);
        driver.findElement(Address2Field).sendKeys(Address2);
        driver.findElement(CityField).sendKeys(City);
        driver.findElement(PostCodeField).sendKeys(PostCode);

        // Country
        WebElement countrySelector = wait.until(ExpectedConditions.elementToBeClickable(CountryField));
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(CountryField, By.xpath(".//option[normalize-space()='" + Country + "']")));
        Select countrySelect = new Select(countrySelector);
        countrySelect.selectByVisibleText(Country);

        // Region
        WebElement regionSelector = wait.until(ExpectedConditions.elementToBeClickable(RegionField));
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(RegionField, By.xpath(".//option[normalize-space()='" + Region + "']")));
        Select regionSelect = new Select(regionSelector);
        regionSelect.selectByVisibleText(Region);
    }

    public void checkBoxes(){
        WebElement Subscription = wait.until(ExpectedConditions.presenceOfElementLocated(SubscriptionCheckBox));
        if(Subscription.isDisplayed()){
            Subscription.click();
        }
        WebElement TermsAndConditions = driver.findElement(TermsAndConditionCheckBox);
        if(TermsAndConditions.isDisplayed()){
            TermsAndConditions.click();
        }
        WebElement PrivacyPolicy = driver.findElement(PrivacyPolicyCheckBox);
        if(PrivacyPolicy.isDisplayed()){
            PrivacyPolicy.click();
        }
    }

    public void UpdateQuantity(String quantity){
        WebElement quantityField = wait.until(ExpectedConditions.visibilityOfElementLocated(QuantityField));
        quantityField.clear();
        quantityField.sendKeys(quantity);
        driver.findElement(UpdateQuantityBtn).click();
    }

    public void DeleteItem(){
        wait.until(ExpectedConditions.elementToBeClickable(DeleteItem)).click();
    }

    public void AddComment(String Comment){
        wait.until(ExpectedConditions.visibilityOfElementLocated(CommentField)).sendKeys(Comment);
    }

    public void Continue(){
        wait.until(ExpectedConditions.elementToBeClickable(ContinueBtn)).click();
    }
}
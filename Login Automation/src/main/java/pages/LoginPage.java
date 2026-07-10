package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By emailField = By.id("input-email");
    private final By passwordField = By.id("input-password");
    private final By loginButton = By.cssSelector("input[value='Login']");
    private final By errorMsg = By.cssSelector(".alert-danger");
    private final By successHeading = By.cssSelector("#content h2");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        type(emailField, email);
        type(passwordField, password);
        click(loginButton);
    }

    public boolean isLoginSuccessful() {
        return isDisplayed(successHeading);
    }

    public boolean isErrorMsgDisplayed() {
        return isDisplayed(errorMsg);
    }

}
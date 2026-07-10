package tests;

import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;

@Listeners({AllureTestNg.class})
public class LoginTest extends BaseTest {

    @Feature("Login")
    @Story("LambdaTest E-Commerce - Login Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test login with valid email and password", priority = 1)
    public void testValidLogin() {
        Allure.step("Step 1: Initialize Login Page");
        LoginPage loginPage = new LoginPage(driver);

        Allure.step("Step 2: Perform login with valid credentials");
        loginPage.login("khaled@gmail.com", "12345678");

        Allure.step("Step 3: Validate login success");
        Assert.assertTrue(
                loginPage.isLoginSuccessful(),
                "Login failed: My Account heading is not displayed."
        );
    }

    @Feature("Login")
    @Story("LambdaTest E-Commerce - Login Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test login with valid email and invalid password", priority = 2)
    public void testLoginWithInvalidPassword() {
        Allure.step("Step 1: Initialize Login Page");
        LoginPage loginPage = new LoginPage(driver);

        Allure.step("Step 2: Perform login with invalid password");
        loginPage.login("khaled@gmail.com", "wrongpassword");

        Allure.step("Step 3: Validate error message is displayed");
        Assert.assertTrue(
                loginPage.isErrorMsgDisplayed(),
                "Error message not displayed after invalid password."
        );
    }

    @Feature("Login")
    @Story("LambdaTest E-Commerce - Login Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test login with invalid email and valid password", priority = 3)
    public void testLoginWithInvalidEmail() {
        Allure.step("Step 1: Initialize Login Page");
        LoginPage loginPage = new LoginPage(driver);

        Allure.step("Step 2: Perform login with invalid email");
        loginPage.login("wrong@gmail.com", "12345678");

        Allure.step("Step 3: Validate error message is displayed");
        Assert.assertTrue(
                loginPage.isErrorMsgDisplayed(),
                "Error message not displayed after invalid email."
        );
    }

    @Feature("Login")
    @Story("LambdaTest E-Commerce - Login Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test login with invalid email and invalid password", priority = 4)
    public void testLoginWithInvalidEmailAndPassword() {
        Allure.step("Step 1: Initialize Login Page");
        LoginPage loginPage = new LoginPage(driver);

        Allure.step("Step 2: Perform login with invalid credentials");
        loginPage.login("wrong@gmail.com", "wrongpassword");

        Allure.step("Step 3: Validate error message is displayed");
        Assert.assertTrue(
                loginPage.isErrorMsgDisplayed(),
                "Error message not displayed after invalid credentials."
        );
    }

    @Feature("Login")
    @Story("LambdaTest E-Commerce - Login Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test login with empty email and password", priority = 5)
    public void testLoginWithEmptyEmailAndPassword() {
        Allure.step("Step 1: Initialize Login Page");
        LoginPage loginPage = new LoginPage(driver);

        Allure.step("Step 2: Perform login with empty fields");
        loginPage.login("", "");

        Allure.step("Step 3: Validate required error messages are displayed");
        Assert.assertTrue(
                loginPage.isErrorMsgDisplayed(),
                "Error message not displayed after empty fields."
        );
    }

    @Feature("Login")
    @Story("LambdaTest E-Commerce - Login Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test login with empty email and valid password", priority = 6)
    public void testLoginWithEmptyEmail() {
        Allure.step("Step 1: Initialize Login Page");
        LoginPage loginPage = new LoginPage(driver);

        Allure.step("Step 2: Perform login with empty email");
        loginPage.login("", "12345678");

        Allure.step("Step 3: Validate email required error message is displayed");
        Assert.assertTrue(
                loginPage.isErrorMsgDisplayed(),
                "Error message not displayed after empty email."
        );
    }

    @Feature("Login")
    @Story("LambdaTest E-Commerce - Login Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test login with valid email and empty password", priority = 7)
    public void testLoginWithEmptyPassword() {
        Allure.step("Step 1: Initialize Login Page");
        LoginPage loginPage = new LoginPage(driver);

        Allure.step("Step 2: Perform login with empty password");
        loginPage.login("khaled@gmail.com", "");

        Allure.step("Step 3: Validate password required error message is displayed");
        Assert.assertTrue(
                loginPage.isErrorMsgDisplayed(),
                "Error message not displayed after empty password."
        );
    }

    @Feature("Login")
    @Story("LambdaTest E-Commerce - Login Functionality")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test login with special characters in email and password", priority = 8)
    public void testLoginWithSpecialCharacters() {
        Allure.step("Step 1: Initialize Login Page");
        LoginPage loginPage = new LoginPage(driver);

        Allure.step("Step 2: Perform login with special characters");
        loginPage.login("!@#$%^&*()", "!@#$%^&*()");

        Allure.step("Step 3: Validate error message is displayed");
        Assert.assertTrue(
                loginPage.isErrorMsgDisplayed(),
                "Error message not displayed after special characters input."
        );
    }
}
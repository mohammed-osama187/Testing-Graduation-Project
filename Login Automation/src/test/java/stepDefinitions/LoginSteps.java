package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;

public class LoginSteps {

    private LoginPage loginPage;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        loginPage = new LoginPage(Hooks.driver);
    }

    @When("the user attempts to login with email {string} and password {string}")
    public void the_user_attempts_to_login_with_email_and_password(String email, String password) {
        loginPage.login(email, password);
    }

    @Then("the login result should be {string}")
    public void the_login_result_should_be(String expectedResult) {
        if (expectedResult.equals("success")) {
            Assert.assertTrue(
                    loginPage.isLoginSuccessful(),
                    "Login failed: My Account heading is not displayed."
            );
        } else {
            Assert.assertTrue(
                    loginPage.isErrorMsgDisplayed(),
                    "Error message not displayed as expected."
            );
        }
    }
}

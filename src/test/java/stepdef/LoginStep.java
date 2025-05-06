package stepdef;

import io.cucumber.java.en.*;
import org.junit.Assert;
import Pages.LoginPage;
import utils.BaseTest;

public class LoginStep extends BaseTest {
    LoginPage loginPage;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        getDriver().get("https://example.com/login");
        loginPage = new LoginPage(getDriver());
    }

    @When("I enter valid username and password")
    public void enter_valid_credentials() {
        loginPage.enterUsername("validUser");
        loginPage.enterPassword("validPass");
    }

    @When("I enter invalid username and password")
    public void enter_invalid_credentials() {
        loginPage.enterUsername("invalid");
        loginPage.enterPassword("invalid");
    }

    @When("I leave the username field empty")
    public void leave_username_empty() {
        loginPage.enterUsername("");
    }

    @And("I enter valid password")
    public void enter_valid_password() {
        loginPage.enterPassword("validPass");
    }

    @And("I click the login button")
    public void click_login() {
        loginPage.clickLogin();
    }

    @Then("I should be redirected to the dashboard")
    public void should_redirect_to_dashboard() {
        Assert.assertTrue(getDriver().getCurrentUrl().contains("/dashboard"));
    }

    @Then("I should see an error message")
    public void should_see_error_message() {
        Assert.assertTrue(loginPage.getErrorMessage().contains("Invalid"));
    }

    @Then("I should see a validation message")
    public void should_see_validation_message() {
        Assert.assertTrue(loginPage.getErrorMessage().contains("required"));
    }
}

package scenarios;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobject.mainpage.MainPage;
import pageobject.mainpage.sections.LoginPanel;

/**
 * Created by Mikhail_Churakov on 6/6/2017.
 */
public class LoginFeatureSteps extends TestBase{

    private WebDriver webDriver;
    private MainPage mainPage;
    private LoginPanel loginPanel;

    @Before
    public void setup(){
        webDriver = initWebDriver();
        mainPage = MainPage.get(webDriver);
        loginPanel = LoginPanel.get(webDriver);
    }

    @After
    public void closeTests() {
        closeBrowser();
    }

    @Given("^I am on Home page$")
    public void openHomePage() {
        openBrowser();
        assertTrue(mainPage.expandLoginPanel.isDisplayed());
    }

    @When("I type credentials as ([^\\\"]*)/([^\\\"]*)")
    public void typeCreds(String login, String password) {
        mainPage.expandLoginPanel.click();
        assertTrue(mainPage.loginPanel.loginField.isDisplayed());
        assertTrue(mainPage.loginPanel.passwordField.isDisplayed());
        assertTrue(mainPage.loginPanel.loginButton.isDisplayed());
        type(login,mainPage.loginPanel.loginField);
        type(password,mainPage.loginPanel.passwordField);
        mainPage.loginPanel.loginButton.click();
    }

    @Then("Profile name is ([^\\\"]*)")
    public void getProfileName(String username) {
        assertTrue(mainPage.profileName.isDisplayed());
        assertsTrue(mainPage.profileName.getText(),username);
    }

    @Then("I get validation error message")
    public void getError() {
        assertFalse(mainPage.profileName.isDisplayed());
        assertTrue(mainPage.loginPanel.failedLoginLabel.isDisplayed());
    }

}

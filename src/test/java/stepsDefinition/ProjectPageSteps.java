package stepsDefinition;

import appHooks.Hooks;
import common.PageGenerator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.ProjectPageObject;

public class ProjectPageSteps {
    WebDriver driver;
    ProjectPageObject projectPage;

    public ProjectPageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
        projectPage = PageGenerator.getProjectPage(driver);
    }

    @Given("Click Add project button")
    public void clickAddProjectButton() {
    }

    @And("Verify Add project button is disabled")
    public void verifyAddProjectButtonIsDisabled() {
    }

    @When("Enter valid data into Project Name")
    public void enterValidDataIntoProjectName() {
    }

    @And("Enter valid data into Project Description")
    public void enterValidDataIntoProjectDescription() {
    }

    @And("Enter valid data into Project Purpose")
    public void enterValidDataIntoProjectPurpose() {
    }

    @And("Verify Add project button is enabled")
    public void verifyAddProjectButtonIsEnabled() {
    }

    @Then("Verify success message is display")
    public void verifySuccessMessageIsDisplay() {
    }

    @And("New project is added successfully")
    public void newProjectIsAddedSuccessfully() {
    }

    @Then("Login success and Project page is displayed")
    public void loginSuccessAndProjectPageIsDisplayed() {
        Assert.assertTrue(projectPage.isProjectPageDisplayed());
    }
}

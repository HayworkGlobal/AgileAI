package stepsDefinition;

import appHooks.Hooks;
import common.BaseTest;
import common.PageGenerator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.ProjectPageObject;


public class ProjectPageSteps extends BaseTest {
    WebDriver driver;
    ProjectPageObject projectPage;
    String projectName = "Project Name" + " " + generateFakeNumber();
    String dupProjName = projectName;
    String projectDescription = "This is test project";
    String projectPurpose = "Project Purpose";

    public ProjectPageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
        projectPage = PageGenerator.getProjectPage(driver);
    }

    @Given("Click Add project button")
    public void clickAddProjectButton() {
        projectPage.clickAddProjectBtn();
    }

    @And("Verify Add project button is disabled")
    public void verifyAddProjectButtonIsDisabled() {
        Assert.assertFalse(projectPage.isAddProjectBtnEnabled());
    }

    @And("Enter valid data to all fields")
    public void enterValidDataToAllFields() {
        projectPage.enterDataToFields(projectName, projectDescription, projectPurpose);
    }

    @And("Verify Add project button is enabled")
    public void verifyAddProjectButtonIsEnabled() {
        Assert.assertTrue(projectPage.isAddProjectBtnEnabled());
    }

    @Then("Verify success message is display")
    public void verifySuccessMessageIsDisplay() {
        Assert.assertEquals(projectPage.getSuccessMsg(), "Project" + " " + projectName + " " + "created successfully!");
    }

    @And("New project is added successfully")
    public void newProjectIsAddedSuccessfully() {
        Assert.assertTrue(projectPage.isProjectAddedSuccess(projectName));
    }

    @Then("Login success and Project page is displayed")
    public void loginSuccessAndProjectPageIsDisplayed() {
        Assert.assertTrue(projectPage.isProjectPageDisplayed());
    }

    @And("Enter Project Name more than {int} characters")
    public void enterProjectNameMoreThanCharacters(Integer characterCount) {
        String longProjectName = "A".repeat(characterCount);
        projectPage.enterDataToFields(longProjectName, projectDescription, projectPurpose);
    }

    @Then("Verify error message is display")
    public void verifyErrorMessageIsDisplay() {
        Assert.assertEquals(projectPage.getErrorMsg(), "Project name should inlcude min 1 character and max 60 characters");
    }

    @And("Enter Project Name is duplicate")
    public void enterProjectNameIsDuplicate() {
        projectPage.enterDataToFields(dupProjName, projectDescription, projectPurpose);
    }

    @Then("Verify duplicate error message is display")
    public void verifyDuplicateErrorMessageIsDisplay() {
        Assert.assertEquals(projectPage.getErrorMsg(), "Project name" + "'" + projectName + "'" + "already exists.");
    }
}

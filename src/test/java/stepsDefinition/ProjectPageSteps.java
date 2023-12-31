package stepsDefinition;

import appHooks.Hooks;
import common.BaseTest;
import common.PageGenerator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.ProjectPageObject;


public class ProjectPageSteps extends BaseTest {
    WebDriver driver;
    ProjectPageObject projectPage;
    String projectName = "Project Name" + " " + generateFakeNumber();
    String projectDescription = "This is test project";
    String projectPurpose = "Project Purpose";
    private String existProjTitle;

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

    @Then("Verify a successful message is displayed")
    public void verifyASuccessMessageIsDisplayed() {
        Assert.assertEquals(projectPage.getSuccessMsg(), "Project" + " " + projectName + " " + "created successfully!");
    }

    @And("New project is added successfully")
    public void newProjectIsAddedSuccessfully() {
        Assert.assertTrue(projectPage.isProjectAddedSuccess(projectName));
    }

    @Then("Login is successful and Project page is displayed")
    public void loginSuccessAndProjectPageIsDisplayed() {
        Assert.assertTrue(projectPage.isProjectPageDisplayed());
    }

    @And("Enter Project Name more than {int} characters")
    public void enterProjectNameMoreThanCharacters(Integer characterCount) {
        String longProjectName = "A".repeat(characterCount);
        projectPage.enterDataToFields(longProjectName, projectDescription, projectPurpose);
    }

    @Then("Verify error message is displayed")
    public void verifyErrorMessageIsDisplay() {
        Assert.assertEquals(projectPage.getErrorMsg(), "Project name should include min 1 character and max 60 characters");
    }

    @And("Enter Project Name is duplicated")
    public void enterProjectNameIsDuplicate() {
        projectPage.enterDataToFields(existProjTitle, projectDescription, projectPurpose);
    }

    @Then("Verify duplicated error message is displayed")
    public void verifyDuplicateErrorMessageIsDisplay() {
        Assert.assertEquals("Project name" + " " + "'" + existProjTitle + "'" + " " + "already exists.", projectPage.getDuplicateProjectErrMsg());
    }

    @When("Retrieves exist project titles")
    public void retrievesExistProjectTitles() {
        existProjTitle = projectPage.getExistProjectTitles();
    }

    @Then("Verify project is edited successfully")
    public void verifyProjectIsEditedSuccessfully() {

    }

    @When("Click Edit button")
    public void clickEditButton() {

    }

    @And("Click Save Project button")
    public void clickSaveProjectButton() {

    }

    @When("Click Delete icon")
    public void clickDeleteIcon() {
    }

    @And("Click Confirm button in confirm popup")
    public void clickConfirmButtonInConfirmPopup() {
    }

    @Then("Verify successful message is displayed")
    public void verifySuccessfulMessageIsDisplayed() {
    }

    @And("Project is deleted successful")
    public void projectIsDeletedSuccessful() {
    }

    @When("Click View button")
    public void clickViewButton() {
    }

    @And("Click Add Requirement button")
    public void clickAddRequirementButton() {
    }
}
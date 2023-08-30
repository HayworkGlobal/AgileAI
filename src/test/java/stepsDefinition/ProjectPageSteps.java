package stepsDefinition;

import appHooks.Hooks;
import common.PageGenerator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.ProjectPageObject;
import utils.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ProjectPageSteps {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    ProjectPageObject projectPage;

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

    @When("Enter valid data from from {string} and rowNumber {int} to fields")
    public void enterValidDataFromFromAndRowNumberToFields(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testData =
                reader.getData(projectPath + "/src/test/resources/testData/Login.xlsx", sheetName);
        String projectName = testData.get(rowNumber).get("project name");
        String projectDescription = testData.get(rowNumber).get("project description");
        String projectPurpose = testData.get(rowNumber).get("project purpose");
        projectPage.enterDataToFields(projectName, projectDescription,projectPurpose);
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

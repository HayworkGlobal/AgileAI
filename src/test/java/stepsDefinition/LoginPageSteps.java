package stepsDefinition;

import appHooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import pageObjects.LoginPageObject;
import common.BaseTest;
import common.PageGenerator;
import org.openqa.selenium.WebDriver;
import utils.ExcelReader;
import utils.PropertiesUtil;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class LoginPageSteps extends BaseTest {

    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    LoginPageObject loginPage;

    public LoginPageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
        loginPage = PageGenerator.getHomePage(driver);
    }

    @Given("Input data into Email and Password from sheetName {string} and rowNumber {int}")
    public void inputDataIntoEmailAndPasswordFromSheetNameAndRowNumber(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testData =
                reader.getData(projectPath + "/src/test/resources/testData/Login.xlsx", sheetName);
        String emailAddress = testData.get(rowNumber).get("email");
        String password = testData.get(rowNumber).get("password");
        loginPage.fillLoginForm(emailAddress, password);
    }

    @When("Click Login button")
    public void clickLoginButton() {
        loginPage.clickToLoginBtn();
    }

    @Then("Verify validation message from sheetName {string} and rowNumber {int}")
    public void verifyValidationMessageFromSheetNameAndRowNumber(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testData =
                reader.getData(projectPath + "/src/test/resources/testData/Login.xlsx", sheetName);
        String expectedErrorMsg = testData.get(rowNumber).get("error message");
        Assert.assertEquals(loginPage.getErrMsg(), expectedErrorMsg);
        ;
    }

    @Given("Input valid data into Email and Password")
    public void input_valid_data_into_email_and_password() {
        loginPage.fillLoginForm(PropertiesUtil.getEmail(), PropertiesUtil.getPassword());
    }

    @Given("User is at login screen")
    public void userIsAtLoginScreen() {
        Assert.assertTrue(loginPage.isLoginPageDisplayed());
    }
}

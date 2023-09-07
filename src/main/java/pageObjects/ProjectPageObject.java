package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;
import pageUIs.ProjectPageUI;

public class ProjectPageObject extends BasePage {
    WebDriver driver;

    public ProjectPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProjectPageDisplayed() {
        waitForElementVisible(driver, ProjectPageUI.projectText);
        return isElementDisplayed(driver, ProjectPageUI.projectText);
    }

    public void clickAddProjectBtn() {
        try {
            waitForElementClickable(driver, ProjectPageUI.addProjectBtn);
            clickToElement(driver, ProjectPageUI.addProjectBtn);
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            waitForElementClickable(driver, ProjectPageUI.addProjectInPopupBtn);
            clickToElement(driver, ProjectPageUI.addProjectInPopupBtn);
        }
    }

    public boolean isAddProjectBtnEnabled() {
        waitForElementVisible(driver, ProjectPageUI.addProjectInPopupBtn);
        return isElementEnabled(driver, ProjectPageUI.addProjectInPopupBtn);
    }

    public void enterDataToFields(String projectName, String projectDescription, String projectPurpose) {
        waitForElementVisible(driver, ProjectPageUI.projectNameTxt);
        sendKeyToElement(driver, ProjectPageUI.projectNameTxt, projectName);

        waitForElementVisible(driver, ProjectPageUI.projectDescriptionTxt);
        sendKeyToElement(driver, ProjectPageUI.projectDescriptionTxt, projectDescription);

        waitForElementVisible(driver, ProjectPageUI.projectPurposeTxt);
        sendKeyToElement(driver, ProjectPageUI.projectPurposeTxt, projectPurpose);
    }

    public String getSuccessMsg() {
        waitForElementVisible(driver, ProjectPageUI.successMsg);
        return getElementText(driver, ProjectPageUI.successMsg);
    }

    public String getErrorMsg() {
        waitForElementVisible(driver, ProjectPageUI.projNameErrMsg);
        return getElementText(driver, ProjectPageUI.projNameErrMsg);
    }

    public String getDuplicateProjectErrMsg() {
        waitForElementVisible(driver, ProjectPageUI.dupProjNameMsg);
        return getElementText(driver, ProjectPageUI.dupProjNameMsg);
    }

    public boolean isProjectAddedSuccess(String projectName) {
        waitForElementVisible(driver, ProjectPageUI.projectTitle, projectName);
        return isElementDisplayed(driver, ProjectPageUI.projectTitle, projectName);
    }

    public String getExistProjectTitles() {
        waitForElementVisible(driver, ProjectPageUI.existProjectTitle);
        return getElementText(driver, ProjectPageUI.existProjectTitle);
    }
}


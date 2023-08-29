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

}


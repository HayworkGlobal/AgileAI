package common;

import pageObjects.LoginPageObject;
import org.openqa.selenium.WebDriver;
import pageObjects.ProjectPageObject;

public class PageGenerator {
    public static LoginPageObject getHomePage(WebDriver driver) {
        return new LoginPageObject(driver);
    }

    public static ProjectPageObject getProjectPage(WebDriver driver) {
        return new ProjectPageObject(driver);
    }

}

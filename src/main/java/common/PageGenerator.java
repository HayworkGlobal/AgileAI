package common;

import pageObjects.LoginPageObject;
import org.openqa.selenium.WebDriver;

public class PageGenerator {
    public static LoginPageObject getHomePage(WebDriver driver) {
        return new LoginPageObject(driver);
    }

}

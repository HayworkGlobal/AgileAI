package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void fillLoginForm(String email, String password) {
        waitForElementVisible(driver, LoginPageUI.emailTxt);
        sendKeyToElement(driver, LoginPageUI.emailTxt, email);

        waitForElementVisible(driver, LoginPageUI.passwordTxt);
        sendKeyToElement(driver, LoginPageUI.passwordTxt, password);
    }

    public void clickToLoginBtn() {
        waitForElementClickable(driver, LoginPageUI.loginBtn);
        clickToElement(driver, LoginPageUI.loginBtn);
    }

    public String getErrMsg() {
        waitForElementVisible(driver, LoginPageUI.errMsg);
        return getElementText(driver, LoginPageUI.errMsg);
    }
}


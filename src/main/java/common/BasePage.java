package common;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class BasePage {
    static Actions actions;

    public static BasePage getBasePageObject() {
        return new BasePage();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public WebElement getWebElement(WebDriver driver, String element) {
        return driver.findElement(By.xpath(element));
    }

    public List<WebElement> getListWebElement(WebDriver driver, String element) {
        return driver.findElements(By.xpath(element));
    }

    public String getDynamicXpath(String element, String... dynamicValue) {
        element = String.format(element, (Object[]) dynamicValue);
        return element;
    }

    public void clickToElement(WebDriver driver, String element) {
        highlightElement(driver, element);
        getWebElement(driver, element).click();
    }

    public void sendKeyToElement(WebDriver driver, String element, String value) {
        highlightElement(driver, element);
        WebElement ele = getWebElement(driver, element);
        ele.clear();
        ele.sendKeys(value);
    }

    public void scrollToBottomPage(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void moveToElement(WebDriver driver, String element) {
        actions = new Actions(driver);
        actions.moveToElement(getWebElement(driver, element));
        actions.perform();
    }

    public void moveToElement(WebDriver driver, String element, String... dynamicValue) {
        actions = new Actions(driver);
        actions.moveToElement(getWebElement(driver, getDynamicXpath(element, dynamicValue)));
        actions.perform();
    }


    public String getElementText(WebDriver driver, String element) {
        highlightElement(driver, element);
        return getWebElement(driver, element).getText().trim();
    }

    public String getElementText(WebDriver driver, String element, String... dynamicValue) {
        return getWebElement(driver, getDynamicXpath(element, dynamicValue)).getText().trim();
    }

    public boolean isElementDisplayed(WebDriver driver, String element) {
        try {
            return getWebElement(driver, element).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementDisplayed(WebDriver driver, String element, String... dynamicValue) {
        try {
            return getWebElement(driver, getDynamicXpath(element, dynamicValue)).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementEnabled(WebDriver driver, String element) {
        try {
            return getWebElement(driver, element).isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void waitForElementClickable(WebDriver driver, String element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
    }

    public void waitForElementClickable(WebDriver driver, String element, String... dynamicValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(getDynamicXpath(element, dynamicValue))));
    }

    public void waitForElementVisible(WebDriver driver, String element) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
    }

    public void waitForElementVisible(WebDriver driver, String element, String... dynamicValue) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getDynamicXpath(element, dynamicValue))));
    }

    public void waitForAllElementVisible(WebDriver driver, String element) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(getListWebElement(driver, element)));
    }

    public void waitForElementInvisible(WebDriver driver, String element) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(element)));
    }

    public void waitForElementInvisible(WebDriver driver, String element, String... dynamicValue) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(getDynamicXpath(element, dynamicValue))));
    }

    public void highlightElement(WebDriver driver, String element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement ele = getWebElement(driver, element);
        String originalStyle = ele.getAttribute("style");
        String highlightStyle = "border: 2px solid red; border-style: dashed;";
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", ele, "style", highlightStyle);
        sleepInSecond(200);
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", ele, "style", originalStyle);
    }

    public void highlightElement(WebDriver driver, String element, String... dynamicValue) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement ele = getWebElement(driver, element);
        String originalStyle = ele.getAttribute("style");
        String highlightStyle = "border: 2px solid red; border-style: dashed;";
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", ele, "style", highlightStyle);
        sleepInSecond(200);
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", ele, "style", originalStyle);
    }

    public void scrollToElement(WebDriver driver, String element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, element));
    }

    public void clickToElementByJS(WebDriver driver, String element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, element));
    }

    public void sleepInSecond(long millisecond) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }
}
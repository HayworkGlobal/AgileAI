package common;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.assertj.core.api.SoftAssertions;

import java.util.Random;

public class BaseTest {
    private WebDriver driver;
    private final SoftAssertions softAssertions = new SoftAssertions();

    public void verifyEquals(String actual, String expected) {
        softAssertions.assertThat(actual).isEqualTo(expected);
    }

    public void verifyTrue(boolean condition) {
        softAssertions.assertThat(condition).isTrue();
    }

    public void verifyFalse(boolean condition) {
        softAssertions.assertThat(condition).isFalse();
    }

    public void assertAll() {
        softAssertions.assertAll();
    }

    protected int generateFakeNumber() {
        Random rand = new Random();
        return rand.nextInt(9999);
    }
}

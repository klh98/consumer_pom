package Base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;
import java.time.Duration;

public class BaseTest {

    private static AndroidDriver driver;
    protected WebDriverWait wait;

    public static AndroidDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void setUp() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setAutomationName("UiAutomator2");
        options.setPlatformName("Android");
        options.setUdid("falrijtck78xrkhe");

        options.setAppPackage("com.jits.mbanking.abank.consumer.uat3");
        options.setAppActivity("com.jits.mbanking.abank.consumer.MainActivity");

        options.setNoReset(true);
        options.setFullReset(false);

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options
        );

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}
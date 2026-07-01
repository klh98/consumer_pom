package Pages;

import Base.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ViberPlusPage {

    AndroidDriver driver;

    public ViberPlusPage(AndroidDriver driver)
    {
        this.driver = driver;
    }

    // Locators
    private final By billsAndPayments = AppiumBy.accessibilityId("Bills & Payments");
    private final By searchBox = AppiumBy.xpath("//android.widget.EditText");
    private final By viberPlus = AppiumBy.accessibilityId("biller");
    private final By selectBtn = AppiumBy.accessibilityId("Select");
    private final By buyNowBtn = AppiumBy.xpath("//*[@text='Buy Now']");
    private final By closeBtn = AppiumBy.xpath("(//android.widget.ImageView)[2]");

    // Actions
    public void openBills() {
        BaseTest.getDriver().findElement(billsAndPayments).click();
    }

    public void enterSearchText(String text) {
        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(10));

        // wait + click
        wait.until(ExpectedConditions.elementToBeClickable(searchBox)).click();

        // wait + send keys
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox)).sendKeys(text);
    }

    public void clickViberPlus() {
        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(viberPlus)).click();
    }

    public void selectProduct() {

        By product = AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().textContains(\"18,900\"))"
        );

        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(20));

        for (int i = 0; i < 3; i++) {
            try {
                WebElement el = wait.until(driver -> driver.findElement(product));
                if (el.isDisplayed() && el.isEnabled()) {
                    el.click();
                    return;
                }
            } catch (Exception e) {
                // retry scroll + click
            }
        }

        throw new RuntimeException("Product not found or not clickable");
    }


    public void clickNext() {
        BaseTest.getDriver().findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".scrollIntoView(new UiSelector().text(\"Next\"))"
                )
        ).click();
    }

    public void clickSelect() {

        new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(selectBtn))
                .click();
    }

    public void clickBuyNow() {
        BaseTest.getDriver().findElement(buyNowBtn).click();
    }

    public void enterPin(String pin) {

        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(10));

        for (char c : pin.toCharArray()) {

            By digit = AppiumBy.accessibilityId(String.valueOf(c));

            wait.until(ExpectedConditions.elementToBeClickable(digit)).click();
        }
    }

    public void clickCloseBtn() {

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(closeBtn))
                .click();
    }

}

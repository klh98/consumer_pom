package Pages;

import Base.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MobileLegendPage {

    AndroidDriver driver;

    public MobileLegendPage(AndroidDriver driver)
    {
        this.driver = driver;
    }

    // Locators
    private final By billsAndPayments = AppiumBy.accessibilityId("Bills & Payments");
    private final By title = AppiumBy.xpath("//*[@text='Mobile Legends : Bang Bang']");
    private final By userId = AppiumBy.xpath("//android.view.View[@resource-id='root']/android.view.View/android.view.View/android.widget.EditText[1]");
    private final By zoneId = AppiumBy.xpath("//android.view.View[@resource-id='root']/android.view.View/android.view.View/android.widget.EditText[2]");
    private final By selectBtn = AppiumBy.accessibilityId("Select");
    private final By buyNowBtn = AppiumBy.xpath("//*[@text='Buy Now']");
    private final By closeBtn = AppiumBy.xpath("(//android.widget.ImageView)[2]");

    // Actions

    public void openBills() {
        BaseTest.getDriver().findElement(billsAndPayments).click();
    }

    public void selectGame() {
        new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(title))
                .click();
    }

    public String getTitleText() {
        return BaseTest.getDriver().findElement(title).getText();
    }

    public void enterUserId(String value) {
        BaseTest.getDriver().findElement(userId).sendKeys(value);
    }

    public void enterZoneId(String value) {
        BaseTest.getDriver().findElement(zoneId).sendKeys(value);
    }

    public void selectProduct() {
        BaseTest.getDriver().findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".scrollIntoView(new UiSelector().text(\"5 Diamonds (5 + 0 Bonus)\"))"
                )
        ).click();
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

    public void closePopup() {

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(closeBtn))
                .click();
    }
}
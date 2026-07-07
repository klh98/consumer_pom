package Pages;

import Base.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShweBillPage {

    AndroidDriver driver;

    public ShweBillPage(AndroidDriver driver)
    {
        this.driver = driver;
    }

    // Locators
    private final By billsAndPayments = AppiumBy.accessibilityId("Bills & Payments");
    private final By searchBox = AppiumBy.xpath("//android.widget.EditText");
    private final By shweBill = AppiumBy.accessibilityId("biller");
    private final By name = AppiumBy.xpath("//android.view.View[@resource-id=\"root\"]/android.view.View/android.view.View/android.widget.EditText[1]");
    private final By phone = AppiumBy.xpath("//android.view.View[@resource-id=\"root\"]/android.view.View/android.view.View/android.widget.EditText[2]");
    private final By amount = AppiumBy.xpath("//android.view.View[@resource-id=\"root\"]/android.view.View/android.view.View/android.widget.EditText[3]");
    private final By memo = AppiumBy.xpath("//android.view.View[@resource-id=\"root\"]/android.view.View/android.view.View/android.widget.EditText[4]");
    private final By nextBtn = AppiumBy.xpath("//android.widget.Button[@text=\"Next\"]");
    private final By selectBtn = AppiumBy.accessibilityId("Select");
    private final By payNowBtn = AppiumBy.xpath("//android.widget.Button[@text=\"Pay Now\"]");
    private final By backBtn = AppiumBy.xpath("//android.widget.Button[@text=\"Back\"]");

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

    public void clickShweBill() {
        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(shweBill)).click();
    }

    public void enterName(String value) {
        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(name))
                .sendKeys(value);
    }

    public void enterPhone(String value) {
        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(phone))
                .sendKeys(value);
    }

    public void enterAmount(String value) {
        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(amount))
                .sendKeys(value);
    }

    public void enterMemo(String value) {
        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(memo))
                .sendKeys(value);
    }

    public void clickNextBtn() {
        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn)).click();
    }

    public void clickSelect() {

        new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(selectBtn))
                .click();
    }

    public void clickPayNow()
    {
        By payNowBtn = AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().textContains(\"Pay Now\"))"
        );

        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(20));

        for (int i = 0; i < 3; i++) {
            try {
                WebElement el = wait.until(driver -> driver.findElement(payNowBtn));
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

    public void enterPin(String pin) {

        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(10));

        for (char c : pin.toCharArray()) {

            By digit = AppiumBy.accessibilityId(String.valueOf(c));

            wait.until(ExpectedConditions.elementToBeClickable(digit)).click();
        }
    }



    public void clickBackBtn() {

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(backBtn))
                .click();
    }

}

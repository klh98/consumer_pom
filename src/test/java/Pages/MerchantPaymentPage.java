package Pages;

import Base.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MerchantPaymentPage {

    AndroidDriver driver;

    public MerchantPaymentPage(AndroidDriver driver)
    {
        this.driver = driver;
    }

    // Locators
    private final By scanQr = AppiumBy.accessibilityId("Scan QR");
    private final By manual = AppiumBy.accessibilityId("Manual");
    private final By merchantID = AppiumBy.xpath("//android.view.View[@content-desc='Merchant ID or Phone No']/following-sibling::android.view.View/android.widget.EditText");
    private final By amount = AppiumBy.xpath("//android.widget.ScrollView/android.view.View/android.widget.EditText[1]");
    private final By amt = AppiumBy.accessibilityId("Amount");
    private final By continueBtn = AppiumBy.accessibilityId("Continue");
    private final By transferBtn = AppiumBy.accessibilityId("Transfer");
    private final By backBtn = AppiumBy.accessibilityId("Back to home");


    //Methods

    public void clickScanQR() {
        BaseTest.getDriver().findElement(scanQr).click();
    }

    public void clickManual() {
        BaseTest.getDriver().findElement(manual).click();
    }

    public void enterMerchantID(String merchantId) {

        WebElement input = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(merchantID));

        input.click();
        input.clear();          // Optional
        input.sendKeys(merchantId);
    }

    public void clickAmt() {
        BaseTest.getDriver().findElement(amt).click();
    }

    public void enterAmount(String value) {

        WebElement input = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(amount));

        input.click();
        input.sendKeys(value);
        try {
            BaseTest.getDriver().hideKeyboard();
        } catch (Exception e) {
            BaseTest.getDriver().pressKey(new KeyEvent(AndroidKey.BACK));
        }
    }

    public void clickContinue() {
        BaseTest.getDriver().findElement(continueBtn).click();
    }

    public void clickTransfer() {
        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(transferBtn)).click();
    }

    public void enterPin(String pin) {

        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(10));

        for (char c : pin.toCharArray()) {

            By digit = AppiumBy.accessibilityId(String.valueOf(c));

            wait.until(ExpectedConditions.elementToBeClickable(digit)).click();
        }
    }

    public void clickBackBtn() {
        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(backBtn)).click();
    }

}

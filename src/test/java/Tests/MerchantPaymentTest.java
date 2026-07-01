package Tests;

import Base.BaseTest;
import Pages.MerchantPaymentPage;
import Pages.MobileLegendPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MerchantPaymentTest extends BaseTest {

    @Test(invocationCount = 45)
    public void ManualPay()
    {
        MerchantPaymentPage merchantPay = new MerchantPaymentPage(getDriver());
        merchantPay.clickScanQR();
        merchantPay.clickManual();
        merchantPay.enterMerchantID("SA0002543");
        merchantPay.clickAmt();
        merchantPay.enterAmount("300");
        merchantPay.clickContinue();
        merchantPay.clickTransfer();
        merchantPay.enterPin("107198");
        merchantPay.clickBackBtn();

    }

}

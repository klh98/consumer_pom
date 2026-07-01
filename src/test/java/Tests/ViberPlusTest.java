package Tests;

import Base.BaseTest;
import Pages.MobileLegendPage;
import Pages.ViberPlusPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ViberPlusTest extends BaseTest {

    @Test(priority = 1)
    public void viberPlus()
    {
        ViberPlusPage viberPlus = new ViberPlusPage(getDriver());
        viberPlus.openBills();
        viberPlus.enterSearchText("viber plus");
        viberPlus.clickViberPlus();
        viberPlus.selectProduct();
        viberPlus.clickNext();
        viberPlus.clickSelect();
        viberPlus.clickBuyNow();
        viberPlus.enterPin("107198");
        viberPlus.clickCloseBtn();

    }

}

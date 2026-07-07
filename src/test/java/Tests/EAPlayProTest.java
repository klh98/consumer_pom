package Tests;


import Base.BaseTest;
import Pages.EAPlayProPage;
import Pages.MobileLegendPage;
import Pages.ViberPlusPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EAPlayProTest extends BaseTest {

    @Test(priority = 1)
    public void EAPlayPro()
    {
        EAPlayProPage EAPlayPro = new EAPlayProPage(getDriver());
        EAPlayPro.openBills();
        EAPlayPro.enterSearchText("EA Play Pro");
        EAPlayPro.clickEAPlayPro();
        EAPlayPro.selectProduct();
        EAPlayPro.clickNext();
        EAPlayPro.clickSelect();
        EAPlayPro.clickBuyNow();
        EAPlayPro.enterPin("107198");
        EAPlayPro.clickBackBtn();
    }

}

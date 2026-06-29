package Tests;

import Base.BaseTest;
import Pages.MobileLegendPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileLegendTest extends BaseTest {

    @Test(priority = 1)
    public void InvalidCredential()
    {
        MobileLegendPage mobileLegend = new MobileLegendPage(getDriver());
        mobileLegend.openBills();

        mobileLegend.selectGame();

        Assert.assertEquals(
                mobileLegend.getTitleText(),
                "Mobile Legends : Bang Bang"
        );

        mobileLegend.enterUserId("testing");

        mobileLegend.enterZoneId("testing");

        mobileLegend.selectProduct();

        mobileLegend.clickNext();

        mobileLegend.closePopup();

    }

    @Test(priority = 2)
    public void EmptyFields()
    {
        MobileLegendPage mobileLegend = new MobileLegendPage(getDriver());
        mobileLegend.openBills();

        mobileLegend.selectGame();

        Assert.assertEquals(
                mobileLegend.getTitleText(),
                "Mobile Legends : Bang Bang"
        );

        mobileLegend.enterUserId("");

        mobileLegend.enterZoneId("");

        mobileLegend.selectProduct();

        mobileLegend.clickNext();

        mobileLegend.closePopup();

    }

    @Test(priority = 3)
    public void checkMobileLegend()
    {
        MobileLegendPage mobileLegend = new MobileLegendPage(getDriver());
        mobileLegend.openBills();

        mobileLegend.selectGame();

        Assert.assertEquals(
                mobileLegend.getTitleText(),
                "Mobile Legends : Bang Bang"
        );

        mobileLegend.enterUserId("39353234");

        mobileLegend.enterZoneId("2059");

        mobileLegend.selectProduct();

        mobileLegend.clickNext();

        mobileLegend.clickSelect();

        mobileLegend.clickBuyNow();

        mobileLegend.enterPin("107198");

        mobileLegend.closePopup();

    }


}

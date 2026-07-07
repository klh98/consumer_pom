package Tests;


import Base.BaseTest;
import Pages.EAPlayProPage;
import Pages.MobileLegendPage;
import Pages.ViberPlusPage;
import Pages.iTunesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class iTunesTest extends BaseTest {

    @Test(priority = 1)
    public void iTunes()
    {
        iTunesPage iTunes = new iTunesPage(getDriver());
        iTunes.openBills();
        iTunes.enterSearchText("iTunes");
        iTunes.click_iTunes();
        iTunes.selectProduct();
        iTunes.clickNext();
        iTunes.clickSelect();
        iTunes.clickBuyNow();
        iTunes.enterPin("107198");
        iTunes.clickBackBtn();

    }

}

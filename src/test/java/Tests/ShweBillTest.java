package Tests;


import Base.BaseTest;
import Pages.EAPlayProPage;
import Pages.MobileLegendPage;
import Pages.ShweBillPage;
import Pages.ViberPlusPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShweBillTest extends BaseTest {

    @Test(priority = 1)
    public void shweBill()
    {
        ShweBillPage shweBill = new ShweBillPage(getDriver());
        shweBill.openBills();
        shweBill.enterSearchText("shwe bill");
        shweBill.clickShweBill();
        shweBill.enterName("mgmg");
        shweBill.enterPhone("09898204330");
        shweBill.enterAmount("10000");
        shweBill.enterMemo("testing");
        shweBill.clickNextBtn();
        shweBill.clickSelect();
        shweBill.clickPayNow();
        shweBill.enterPin("107198");
        shweBill.clickBackBtn();


    }

}

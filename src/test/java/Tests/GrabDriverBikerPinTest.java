package Tests;


import Base.BaseTest;
import Pages.EAPlayProPage;
import Pages.GrabDriverBikerPinPage;
import Pages.MobileLegendPage;
import Pages.ViberPlusPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GrabDriverBikerPinTest extends BaseTest {

    @Test(priority = 1)
    public void GrabDriverBikerPin()
    {
        GrabDriverBikerPinPage GrabDriverBikerPin = new GrabDriverBikerPinPage(getDriver());
        GrabDriverBikerPin.openBills();
        GrabDriverBikerPin.enterSearchText("Grab Driver Biker");
        GrabDriverBikerPin.click_GrabDriverBikerPin();
        GrabDriverBikerPin.selectProduct();
        GrabDriverBikerPin.clickNext();
        GrabDriverBikerPin.clickSelect();
        GrabDriverBikerPin.clickBuyNow();
        GrabDriverBikerPin.enterPin("107198");   //put your password
        GrabDriverBikerPin.clickBackBtn();
    }

}

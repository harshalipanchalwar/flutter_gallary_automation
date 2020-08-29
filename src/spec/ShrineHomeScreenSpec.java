package spec;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ShrineHomeScreen;
import pages.ShrineLoginScreen;

public class ShrineHomeScreenSpec extends BaseClass {
    ShrineHomeScreen shrineHomeScreen = new ShrineHomeScreen();

    @Test
    public void verifyShrineLoginScreen() {
        Assert.assertTrue(shrineHomeScreen.verifyShrineHomeScreen());
        takeScreenShot();
    }

    @Test(dependsOnMethods = "verifyShrineLoginScreen")
    public void verifyClothingFilterIsSelected() throws InterruptedException {
        shrineHomeScreen.clickOnHamburgerMenu();
        Assert.assertTrue(shrineHomeScreen.verifyMenuScreenDisplayed());
        takeScreenShot();

    }

    @Test(dependsOnMethods = "verifyClothingFilterIsSelected")
    public void addFirstShirt() throws InterruptedException {
        shrineHomeScreen.selectClothing();
        takeScreenShot();
        shrineHomeScreen.addFirstShirt();
        takeScreenShot();
    }

    @Test(dependsOnMethods = "addFirstShirt")
    public void addWalterHenryShirt() throws InterruptedException {
        shrineHomeScreen.swipeRightTillWalterHenryShirt();
        takeScreenShot();
    }
}

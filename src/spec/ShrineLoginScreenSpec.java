package spec;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GallaryHomeScreen;
import pages.ShrineLoginScreen;
import util.Constant;

import java.net.MalformedURLException;

public class ShrineLoginScreenSpec extends BaseClass {
    ShrineLoginScreen shrineLoginScreen = new ShrineLoginScreen();

    @Test
    public void verifyShrineLoginScreen() {
        shrineLoginScreen.openShrine();
        Assert.assertTrue(shrineLoginScreen.verifyShrineLoginScreenDisplayed());
    }

    @Test(dependsOnMethods = "verifyShrineLoginScreen")
    public void verifyLoginDetails() throws InterruptedException {
        //Enter Username
        String actualUsername = shrineLoginScreen.enterUsername();
        //Verify the entered username is as per the expected username
        Assert.assertEquals(actualUsername,Constant.expectedUserName);
        //Enter Password
       shrineLoginScreen.enterPassword();
        //Verify  password is masked
        Assert.assertEquals(shrineLoginScreen.verifyPasswordIsMasked(),Constant.expectedPassword);
        takeScreenShot();
        //click Next
        shrineLoginScreen.clickNext();
        takeScreenShot();

    }
}
package spec;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GallaryHomeScreen;
import pages.ShrineLoginScreen;

import java.net.MalformedURLException;

public class GallaryHomeScreenSpec extends BaseClass {

    GallaryHomeScreen gallaryHomeScreen = new GallaryHomeScreen();

    public GallaryHomeScreenSpec() throws MalformedURLException {
    }

    @Test
    public void verifyHomePageDisplayed() {
        Assert.assertTrue(gallaryHomeScreen.verifyHomeScreenDisplayed());
        takeScreenShot();
    }
}
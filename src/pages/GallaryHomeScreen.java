package pages;

import base.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import locators.GallaryHomeScreenLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class GallaryHomeScreen extends BaseClass {
    GallaryHomeScreenLocators gallaryHomeScreenLocators = new GallaryHomeScreenLocators();

    public boolean verifyHomeScreenDisplayed() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver.findElement(By.xpath(gallaryHomeScreenLocators.homeScreenLogo)).isDisplayed();
    }
}

package pages;

import base.BaseClass;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import locators.LoginScreenLocators;
import locators.ShrineHomeScreenLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

public class ShrineHomeScreen extends BaseClass {
    ShrineHomeScreenLocators shrineHomeScreenLocators = new ShrineHomeScreenLocators();

    public boolean verifyShrineHomeScreen() {
        return driver.findElement(By.xpath(shrineHomeScreenLocators.shrineLogo)).isDisplayed();
    }

    public void clickOnHamburgerMenu() {
        driver.findElement(By.xpath(shrineHomeScreenLocators.menu)).click();

    }

    public boolean verifyMenuScreenDisplayed() {
        return driver.findElement(By.xpath(shrineHomeScreenLocators.menuIcon)).isDisplayed();
    }

    public void selectClothing() {
        driver.findElement(By.xpath(shrineHomeScreenLocators.clothing)).click();

    }

    public void addFirstShirt() throws InterruptedException {
        System.out.println(driver.getPageSource());
       List<MobileElement> listElement = (List<MobileElement>) driver.findElements(By.className("android.widget.Button"));
        for (int i = 0; i < listElement.size(); i++) {
            if (listElement.get(i).getAttribute("contentDescription").contains("Sea Tunic")) {
                listElement.get(i).click();

            }
          Thread.sleep(5000);
        }
    }


        public void swipeRightTillWalterHenryShirt () {
            TouchAction touchAction = new TouchAction(driver);
            touchAction.press(PointOption.point(972, 600)).waitAction(waitOptions(ofMillis(800))).
                    moveTo(PointOption.point(108, 600)).release().perform();
            System.out.println("Swipe successfull");
            touchAction.press(PointOption.point(972, 600)).waitAction(waitOptions(ofMillis(800))).
                    moveTo(PointOption.point(108, 600)).release().perform();
            System.out.println("Swipe successfull");

        }

    }

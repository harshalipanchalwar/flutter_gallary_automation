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
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        System.out.println(driver.getPageSource());
        List<MobileElement> listElement = (List<MobileElement>) driver.findElements(By.className("android.widget.Button"));
        for (int i = 0; i < listElement.size(); i++) {
            if (listElement.get(i).getAttribute("contentDescription").contains("Sea Tunic")) {
                listElement.get(i).click();

            }
//            Thread.sleep(5000);
//        }
            //driver.findElement(By.xpath(shrineHomeScreenLocators.shirt)).click();
//        driver.findElement(By.xpath(shrineHomeScreenLocators.shirt)).click();
            //driver.findElementByAndroidUIAutomator("UiSelector().description(Plaster tunic\\n$38, Add to cart)").click();

        }
    }


        public void swipeRight () {
            List<MobileElement> e=driver.findElements(By.className("android.widget.Button"));
            MobileElement firdelement=e.get(0);
            MobileElement secondElement=e.get(1);
            MobileElement thirdElement=e.get(2);

            int midOfY =thirdElement.getLocation().y +(thirdElement.getSize().height/2);
            int fromXLocation=thirdElement.getLocation().x;
            int toXLocation=firdelement.getLocation().x;

            TouchAction  action =new TouchAction(driver);
            action.press(PointOption.point(fromXLocation, midOfY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                    .moveTo(PointOption.point(toXLocation, midOfY))
                    .release()
                    .perform();

        }

    }

package pages;

import base.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import locators.LoginScreenLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ShrineLoginScreen extends BaseClass {
    LoginScreenLocators loginScreenLocators = new LoginScreenLocators();

    public void openShrine() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath(loginScreenLocators.shrineIcon)).click();
    }

    public boolean verifyShrineLoginScreenDisplayed() {
        return driver.findElement(By.xpath(loginScreenLocators.shrineGrid)).isDisplayed();
    }

    public String enterUsername() throws InterruptedException {
        Actions a = new Actions(driver);
        MobileElement username = driver.findElement(By.xpath(loginScreenLocators.username));
        username.click();
        a.sendKeys("abc").perform();
        String user =  username.getAttribute("text");
        String[] actualUser = user.split(",");
        return actualUser[0].trim();
    }

    public void enterPassword() throws InterruptedException {
        Actions a = new Actions(driver);
        MobileElement password = driver.findElement(By.xpath(loginScreenLocators.password));
        password.click();
        a.sendKeys("pass").perform();
    }

    public String verifyPasswordIsMasked() {
        String pass =driver.findElement(By.xpath(loginScreenLocators.password)).getAttribute("text");
        String[] actualPass = pass.split(",");
        return actualPass[0].trim();

    }

    public void clickNext()  {
        //Thread.sleep(5000);
        driver.findElement(By.xpath(loginScreenLocators.nextButton)).click();
    }

}

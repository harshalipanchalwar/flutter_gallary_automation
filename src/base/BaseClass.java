package base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static URL url;
    public static DesiredCapabilities capabilities;
    public static AndroidDriver<MobileElement> driver;
    String destDir;
    DateFormat dateFormat;

        @BeforeSuite
    public static void startServer() {
        Runtime runtime = Runtime.getRuntime();

        try {
            runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723 --session-override -dc \"{\"\"noReset\"\": \"\"false\"\"}\"\"");
            Thread.sleep(10000L);
            driver=setupAppium();
        } catch (InterruptedException | IOException var3) {
            var3.printStackTrace();
        }

    }

    public static AndroidDriver<MobileElement> setupAppium() throws MalformedURLException {
        final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
        url = new URL(URL_STRING);
        //Set the app path name
//        File f = new File("src");
//        File fs = new File(f, "flutter_gallery_android.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities = new DesiredCapabilities();
        //capabilities.setCapability("automationName", "UIAutomator2");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("appActivity", "io.flutter.demo.gallery.MainActivity");
        capabilities.setCapability("appPackage", "io.flutter.demo.gallery");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("fullReset", "false");
        driver = new AndroidDriver<MobileElement>(url, capabilities);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return driver;
       }

    public void takeScreenShot() {
        // Set folder name to store screenshots.
        destDir = "screenshots";
        // Capture screenshot.
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Set date format to set It as screenshot file name.
        dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        // Create folder under project with name "screenshots" provided to destDir.
        new File(destDir).mkdirs();
        // Set file name using current date time.
        String destFile = dateFormat.format(new Date()) + ".png";

        try {
            // Copy paste file at destination folder location
            FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    @AfterSuite
//    public void uninstallApp() throws InterruptedException {
//        driver.removeApp("com.example.android.contactmanager");
//    }
}

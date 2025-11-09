package resource;

import java.net.URI;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Driver {

    static AppiumDriver<MobileElement> driver;

    public static AppiumDriver<MobileElement> openApp() throws Exception{

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Android SDK built for x86_64");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "12");
        cap.setCapability("appPackage", "com.vingroup.oneseal.UAT");
        cap.setCapability("unicodeKeyboard", "true");
        cap.setCapability("appActivity", "com.example.saler.MainActivity");
        cap.setCapability("fullReset", "false");
        cap.setCapability("noReset", "true");
        cap.setCapability("automationName", "uiautomator2");
        URI uri = URI.create("http://127.0.0.1:4723/wd/hub");
        URL url = uri.toURL();
        
        //URL url = new URL ("http://127.0.0.1:4723/wd/hub");
        //driver = new AppiumDriver<>(url,cap);
        driver = new AndroidDriver<>(url, cap);
       
        System.out.println("App open");
        return driver;
    }

    public static void clearDrive() {
        driver.quit();
    }
}

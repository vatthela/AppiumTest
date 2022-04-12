package resource;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Driver {

    static AppiumDriver<MobileElement> driver;
    
    public Driver (AppiumDriver<MobileElement> driver){
        this.driver = driver;
    }

    public static AppiumDriver<MobileElement> openApp() throws Exception{

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Android SDK built for x86_64");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "10");
        cap.setCapability("appPackage", "com.vingroup.oneseal.QC");
        cap.setCapability("unicodeKeyboard", "true");
        cap.setCapability("appActivity", "com.example.saler.MainActivity");
        cap.setCapability("fullReset", "false");
        cap.setCapability("noReset", "true");

        URL url = new URL ("http://127.0.0.1:4723/wd/hub");
        AppiumDriver<MobileElement> driver = new AppiumDriver<MobileElement>(url,cap);
        System.out.println("App open");
        return driver;
    }
}

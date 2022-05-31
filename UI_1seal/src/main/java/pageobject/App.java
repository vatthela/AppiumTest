package pageobject;

import pageobject.LoginPage;
import java.net.URL;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;

/**
 * Hello world!
 *
 */
public class App 
{
    static AppiumDriver<MobileElement> driver ;
   // static Login login = new Login(driver);

    public static void main(String[] args)
    {   
       // AppiumDriver<MobileElement> driver;
        try{
            driver = openApp();
         }catch(Exception exp){
             exp.printStackTrace();
 
        };
        //System.out.println(driver);
        // Login login = new Login(driver);
        // login.loginByAccount();
        LoginPage login = new LoginPage(driver);
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

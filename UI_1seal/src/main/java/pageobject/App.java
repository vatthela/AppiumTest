package pageobject;

import pageobject.Login;
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
    static AppiumDriver<MobileElement> driver;
    private static Login login = new Login();

    public static void main(String[] args)
    {
        try{
            openApp();
         }catch(Exception exp){
             System.out.println(exp.getCause());
             System.out.println(exp.getMessage());  
        };
        login.loginByAccount();
    }
    
    
    public static void openApp() throws Exception{
        
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "sdk_gphone64_x86_64");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "12");
        cap.setCapability("appPackage", "com.vingroup.oneseal.QC");
        cap.setCapability("unicodeKeyboard", "true");
        cap.setCapability("appActivity", "com.example.saler.MainActivity");
        cap.setCapability("fullReset", "false");
        cap.setCapability("noReset", "true");

        URL url = new URL ("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<MobileElement>(url,cap);
        System.out.println("App open");       
    }


}

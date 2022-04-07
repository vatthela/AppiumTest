package pageobject1;


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
    public static void main( String[] args )
    {
        try{
            openApp();
         }catch(Exception exp){
             System.out.println(exp.getCause());
             System.out.println(exp.getMessage());  
         };
         login();

    }

    private static void login() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.findElementByXPath("//android.view.View[@content-desc=\"Đăng nhập bằng tài khoản\"]").click();
        driver.findElementByAccessibilityId("Đăng nhập bằng tài khoản").click();

       // driver.findElementByXPath("//android.view.View[contains(@content-desc,'Đăng nhập bằng tài khoản')]").click();
       // driver.findElement(MobileBy.AccessibilityId("Số điện thoại của bạn")).sendKeys("0123456");
       // driver.findElement(MobileBy.AccessibilityId("Đăng nhập bằng tài khoản"));
        
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

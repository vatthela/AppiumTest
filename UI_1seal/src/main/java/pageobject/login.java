package pageobject;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class Login {
    
    static AppiumDriver<MobileElement> driver;
    Login (String driver) {

    }

    public void loginByAccount() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.findElementByXPath("//android.view.View[@content-desc=\"Đăng nhập bằng tài khoản\"]").click();
        driver.findElementByAccessibilityId("Đăng nhập bằng tài khoản").click();

       // driver.findElementByXPath("//android.view.View[contains(@content-desc,'Đăng nhập bằng tài khoản')]").click();
       // driver.findElement(MobileBy.AccessibilityId("Số điện thoại của bạn")).sendKeys("0123456");
       // driver.findElement(MobileBy.AccessibilityId("Đăng nhập bằng tài khoản"));
        
    }
}

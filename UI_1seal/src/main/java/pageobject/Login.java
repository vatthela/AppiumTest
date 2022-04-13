package pageobject;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.springframework.util.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import utils.ScreenHandler;


public class Login {
    
    //static AppiumDriver<MobileElement> driver;
    AppiumDriver<MobileElement> driver;
    //private AppiumDriver<MobileElement> driver;

   public Login (AppiumDriver<MobileElement> driver) {
      this.driver = driver;
    }

    public void loginByAccount() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //driver.findElementByXPath("//android.view.View[@content-desc=\"Đăng nhập bằng tài khoản\"]").click();
        driver.findElementByAccessibilityId("Đăng nhập bằng tài khoản").click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("//android.widget.EditText[@resource-id=\"username\"]").sendKeys("salm6qm3");
        driver.findElementByXPath("//android.widget.EditText[@resource-id=\"password\"]").sendKeys("123456");
        driver.findElementByXPath("//android.widget.Button[@text=\"Tiếp tục\"]").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       
        
        MobileElement result = driver.findElementByXPath("//android.widget.TextView[@text=\"Open with 1SEAL QC\"]");
        //String result1 = result.getText();
        //driver.findElementByXPath("//android.widget.Button[@text=\"JUST ONCE\"]").click();
        
        //ScreenHandler.swipeuUp(driver);
       // driver.findElementByXPath("//android.view.View[contains(@content-desc,'Đăng nhập bằng tài khoản')]").click();
       // driver.findElement(MobileBy.AccessibilityId("Số điện thoại của bạn")).sendKeys("0123456");
       // driver.findElement(MobileBy.AccessibilityId("Đăng nhập bằng tài khoản"));
    }
}

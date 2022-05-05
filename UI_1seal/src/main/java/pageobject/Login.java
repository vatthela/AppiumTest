package pageobject;

import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.taskdefs.Sleep;
import org.openqa.selenium.By;
import org.springframework.util.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import utils.ScreenHandler;


public class Login {
    
    AppiumDriver<MobileElement> driver;

    private By login_by_account = MobileBy.AccessibilityId("Đăng nhập bằng tài khoản");
    private By username = MobileBy.xpath("//android.widget.EditText[@resource-id=\"username\"]");
    private By passsword = MobileBy.xpath("//android.widget.EditText[@resource-id=\"password\"]");
    private By countinue = MobileBy.xpath("//android.widget.Button[@text=\"Tiếp tục\"]");

   public Login (AppiumDriver<MobileElement> driver) {
      this.driver = driver;
    }

    public void loginByAccount() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(login_by_account).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(username).sendKeys("linh05");
        driver.findElement(passsword).sendKeys("123456@");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(countinue).click();
        

        //driver.findElementByXPath("//android.view.View[@content-desc=\"Đăng nhập bằng tài khoản\"]").click();
        //driver.findElementByAccessibilityId("Đăng nhập bằng tài khoản").click();
       
        //driver.findElementByXPath("//android.widget.EditText[@resource-id=\"username\"]").sendKeys("linh05");
        //MobileElement result = driver.findElementByXPath("//android.widget.TextView[@text=\"Open with 1SEAL QC\"]");
        //String result1 = result.getText();

        //ScreenHandler.swipeuUp(appiumDriver);
        //String result1 = result.getText();
        //driver.findElementByXPath("//android.widget.Button[@text=\"JUST ONCE\"]").click();
        
        //ScreenHandler.swipeuUp(driver);
       // driver.findElementByXPath("//android.view.View[contains(@content-desc,'Đăng nhập bằng tài khoản')]").click();
       // driver.findElement(MobileBy.AccessibilityId("Số điện thoại của bạn")).sendKeys("0123456");
       // driver.findElement(MobileBy.AccessibilityId("Đăng nhập bằng tài khoản"));
    }
}

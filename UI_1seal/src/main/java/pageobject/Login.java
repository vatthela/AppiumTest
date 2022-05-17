package pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

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
    private By bottom_sheet = MobileBy.id("android:id/title");
    private By just_one = MobileBy.id("android:id/button_once");
    private By dffierent_app = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.ListView/android.widget.LinearLayout");
    
   public Login (AppiumDriver<MobileElement> driver) {
      this.driver = driver;
    }

    public void loginByAccount() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(login_by_account).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(username).sendKeys("0396247761");
        driver.findElement(passsword).sendKeys("123456@");
        driver.findElement(countinue).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement ele_bottom_sheet = driver.findElement(bottom_sheet);
        if (ele_bottom_sheet != null){
            if (ele_bottom_sheet.getText().equals("Open with 1SEAL UAT")){
                driver.findElement(just_one).click();
            } else {
                driver.findElement(dffierent_app).click();
            }         
        }
        
        
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

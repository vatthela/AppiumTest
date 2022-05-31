package pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class GtDetailPage {
    AppiumDriver<MobileElement> driver;
    By closeGtDetail_icon = MobileBy.AccessibilityId("btn_close");
    By statusCheckIn_btn = MobileBy.AccessibilityId("Check-in");
    By statusCheckOut_btn = MobileBy.AccessibilityId("Check-out");
    By checkOut_btn = MobileBy.xpath("//android.widget.Button[@content-desc=\"Check out\"]");
    
    public GtDetailPage(AppiumDriver<MobileElement> driver, String gtName){
        GtListPage gtListPage = new GtListPage(driver);
        this.driver = driver;
        gtListPage.clickSearchGt();
        gtListPage.sendKeySearchGt(gtName);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(MobileBy.xpath("//*[contains(@content-desc,\""+ gtName + "\")]")).click();;
    }
    public void closeGtDetail(){
        driver.findElement(closeGtDetail_icon).click();
    }
    //check-in/check-out
    public void checkIn(){
        driver.findElement(statusCheckIn_btn).click();
    }

    public void checkOut(){
        driver.findElement(statusCheckOut_btn).click();
    }
    
    public void confirmCheckOut(){
        driver.findElement(checkOut_btn).click();
    }

    public String verifyStatusCheckInCheckout(){
        String status = null;
        try {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            if (driver.findElement(statusCheckIn_btn).getAttribute("content-desc").contains("Check-in") == true){
                status= "Check-in";
            }
        } catch(Exception e){
        }
        try {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            if (driver.findElement(statusCheckOut_btn).getAttribute("content-desc").contains("Check-out") == true) {
                status= "Check-out";
            }
        } catch (Exception e) {
        }
        return status;
    }
}

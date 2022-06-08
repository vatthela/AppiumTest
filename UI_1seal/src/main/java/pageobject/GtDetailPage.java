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
    
    public GtDetailPage(AppiumDriver<MobileElement> driver){
        this.driver = driver;
    }

    public void 
    navigateGtDetail(String gtName){
        GtListPage gtListPage = new GtListPage(driver);
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
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            if (driver.findElement(statusCheckIn_btn).isDisplayed() == true){
                status= "Check-in";
            }
        } catch(Exception e){
        }
        try {
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            if (driver.findElement(statusCheckOut_btn).isDisplayed() == true) {
                status= "Check-out";
            }
        } catch (Exception e) {
        }
        return status;
    }

    public void clickCloseTransportInfar() {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        By clickCloseTransportInfar = MobileBy.AccessibilityId("accessibilityId");
        driver.findElement(clickCloseTransportInfar).click();
    }

    public boolean verifyName(String gtName){
        By status = MobileBy.xpath(gtName);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        if (driver.findElement(status).isDisplayed()) {
            return true;
        } else {
            return false;
        }  
    }
}

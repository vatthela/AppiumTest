package pageobject;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class OnboardingPage {
    AppiumDriver<MobileElement> driver;
    By onBoardingGt_btn = MobileBy.AccessibilityId("Tạo mới");
    By ownerName_it = MobileBy.AccessibilityId("accessibilityId");
    By ownerPhone_it = MobileBy.AccessibilityId("accessibilityId");
    By next_btn = MobileBy.AccessibilityId("accessibilityId");


    public OnboardingPage(AppiumDriver<MobileElement> driver){
        GtListPage gtListPage = new GtListPage(driver);
        driver.findElement(onBoardingGt_btn).click();
        this.driver = driver;
    }
    public void setInfoGt(String ownerName, int phone){
        
    }

}

package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class TakePhoto {
    public static void TakePhotoCheckOut(AppiumDriver<MobileElement> driver){
        By close_btn = MobileBy.AccessibilityId("accessibilityId");
        By iUnderstand_btn = MobileBy.AccessibilityId("Tôi đã hiểu");
        By takePhoto_btn = MobileBy.AccessibilityId("btn_take_picture");
        By userPhoto_btn = MobileBy.AccessibilityId("Xác nhận");
        By backHome_btn = MobileBy.AccessibilityId("Về trang chủ");
        driver.findElement(takePhoto_btn).click();
        driver.findElement(userPhoto_btn).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(backHome_btn).click();
    }

    public static void TakePhotoOnboarding(AppiumDriver<MobileElement> driver){
        By userPhoto_btn2 = MobileBy.AccessibilityId("Về trang chủ");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(userPhoto_btn2).click();
    }
}

package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class TakePhoto {
    static By close_btn = MobileBy.AccessibilityId("accessibilityId");
    static By iUnderstand_btn = MobileBy.AccessibilityId("Tôi đã hiểu");
    static By takePhoto_btn = MobileBy.AccessibilityId("btn_take_picture");
    static By confirmPhoto_btn = MobileBy.AccessibilityId("Xác nhận");
    static By usePhoto_btn = MobileBy.AccessibilityId("Sử dụng");
    static By backHome_btn = MobileBy.AccessibilityId("Về trang chủ");

    public static void takePhoto(AppiumDriver<MobileElement> driver) {
        try {
            if (driver.findElement(iUnderstand_btn).isDisplayed() == true) {
                driver.findElement(iUnderstand_btn).click();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        driver.findElement(takePhoto_btn).click();
        try {
            if (driver.findElement(confirmPhoto_btn).isDisplayed() == true) {
                driver.findElement(confirmPhoto_btn).click();
            }
            if (driver.findElement(usePhoto_btn).isDisplayed() == true) {
                driver.findElement(usePhoto_btn).click();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void backHome(AppiumDriver<MobileElement> driver) {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(backHome_btn).click();
    }
}

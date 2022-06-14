package pageobject;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import utils.TakePhoto;

public class HomePageSa {
    AppiumDriver<MobileElement> driver;
    By customerMenu_tab = MobileBy.xpath("//android.widget.ImageView[contains(@content-desc,\"Khách hàng\")]");
    By all_tab = MobileBy.xpath("//android.view.View[contains(@content-desc,\"Tất cả\")]");
    By support_tab = MobileBy.xpath("//android.view.View[contains(@content-desc,\"Chăm sóc\")]");
    By potential_tab = MobileBy.xpath("//android.view.View[contains(@content-desc,\"Tiềm năng\")]");
    By checkOut_btn = MobileBy.AccessibilityId("Check-out");
    By checkIn_btn = MobileBy.AccessibilityId("Check-in");
    By findGt_btn = MobileBy.AccessibilityId("Tìm cửa hàng khác");
    By editSearch_it = MobileBy.xpath(
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText");

    public HomePageSa(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    // Cụm check-in, check-out
    // Click icon check-in
    public void clickCheckIn() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(checkIn_btn).click();
    }

    // Check-in trong List GT
    public void checkInList(String gtName) throws Exception {
        String xpathList = "//android.widget.ImageView[contains(@content-desc,\"" + gtName
                + "\")]//android.view.View[contains(@content-desc,\"Check-in\")]";
        By checkInList_btn = MobileBy.xpath(xpathList);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(checkInList_btn).click();
    }

    // Check-in bằng cách search GT
    public void checkInSearch(String gtName) {
        String xpathSearch = "//android.view.View[contains(@content-desc,\"" + gtName
                + "\")]//android.view.View[contains(@content-desc,\"Check-in\")]";
        By checkInSearch_btn = MobileBy.xpath(xpathSearch);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(checkInSearch_btn).click();
    }
    
    public void findGtCheckIn(String keyworkSearch) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(findGt_btn).click();
        driver.findElement(editSearch_it).sendKeys(keyworkSearch);
    }

    // Return current status check-in check-out
    public String verifyStatusCheckInCheckout() {
        String status = null;
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            if (driver.findElement(checkIn_btn).isDisplayed() == true) {
                status = "Check-in";
            }
        } catch (Exception e) {
        }
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            if (driver.findElement(checkOut_btn).isDisplayed() == true) {
                status = "Check-out";
            }
        } catch (Exception e) {
        }
        return status;
    }

    public void checkOut() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(checkOut_btn).click();
    }

    // Create a call valid (waiting 70s)
    public void checkInValid(String gtName) throws Exception{
        clickCheckIn();
        checkInList(gtName);
        Thread.sleep(70000);
        checkOut();
        TakePhoto.takePhoto(driver);
        TakePhoto.clickBackHome(driver);
    }
}

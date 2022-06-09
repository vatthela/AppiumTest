package testcase_uat;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pageobject.GtDetailPage;
import pageobject.GtListPage;
import resource.Driver;
import utils.TakePhoto;

public class TC_CheckInCheckOutGtDetail {
    AppiumDriver<MobileElement> driver;
    GtDetailPage gtDetailPage;
    By backHome_btn = MobileBy.AccessibilityId("Về trang chủ");

    @BeforeClass
    public void init() throws Exception {
        driver = Driver.openApp();
    }

    @Test(priority = 1)
    public void verifyCheckInCheckOut() {
        try {
            gtDetailPage = new GtDetailPage(driver);
            gtDetailPage.navigateGtDetailBySearch("0111770011");
            gtDetailPage.checkIn();
            Assert.assertEquals(gtDetailPage.verifyStatusCheckInCheckout(), "Check-out");
            gtDetailPage.checkOut();
            TakePhoto.takePhoto(driver);
            Assert.assertTrue(TakePhoto.verifyBackHome(driver));
            TakePhoto.clickBackHome(driver);
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    @Test(priority = 2)
    public void verifyCheckInOtherGt() {
        try {
            gtDetailPage = new GtDetailPage(driver);
            gtDetailPage.navigateGtDetailBySearch("0111770011");
            gtDetailPage.checkIn();
            Thread.sleep(3000);
            Assert.assertEquals(gtDetailPage.verifyStatusCheckInCheckout(), "Check-out");
            gtDetailPage.closeGtDetail();
            By cancelSearch_icon = MobileBy.xpath("//android.view.View[@content-desc=\"Huỷ\"]");
            driver.findElement(cancelSearch_icon).click();
            gtDetailPage = new GtDetailPage(driver);
            gtDetailPage.navigateGtDetailBySearch("0111770012");
            gtDetailPage.checkIn();
            gtDetailPage.confirmCheckOut();
            TakePhoto.takePhoto(driver);
            Assert.assertTrue(TakePhoto.verifyBackHome(driver));
            TakePhoto.clickBackHome(driver);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}

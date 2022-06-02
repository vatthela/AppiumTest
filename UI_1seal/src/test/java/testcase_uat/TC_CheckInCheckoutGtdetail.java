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

public class TC_CheckInCheckoutGtdetail {
    AppiumDriver<MobileElement> driver;
    GtDetailPage gtDetailPage;

    @BeforeClass
    public AppiumDriver<MobileElement> navigateGtdetail() throws Exception {
        driver = Driver.openApp();
        gtDetailPage = new GtDetailPage(driver, "0111770011");
        return driver;
    }

    @Test(priority = 1)
    public void verifyCheckInCheckOut() {
        try {
            if (gtDetailPage.verifyStatusCheckInCheckout().equals("Check-in")) {
                gtDetailPage.checkIn();
            }
            Assert.assertEquals(gtDetailPage.verifyStatusCheckInCheckout(), "Check-out");
            gtDetailPage.verifyStatusCheckInCheckout().equals("Check-out");
            gtDetailPage.checkOut();
            TakePhoto.takePhoto(driver);
            
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    @Test(priority = 2)
    public void verifyCheckInOtherGt() throws Exception {
        try {
            gtDetailPage = new GtDetailPage(driver, "0111770011");
            if (gtDetailPage.verifyStatusCheckInCheckout().equals("Check-in")) {
                gtDetailPage.checkIn();
                Thread.sleep(3000);
            }
            Assert.assertEquals(gtDetailPage.verifyStatusCheckInCheckout(), "Check-out");
            gtDetailPage.closeGtDetail();
            By cancelSearch_icon = MobileBy.xpath("//android.view.View[@content-desc=\"Huỷ\"]");
            driver.findElement(cancelSearch_icon).click();
            gtDetailPage = new GtDetailPage(driver, "0111770012");
            gtDetailPage.checkIn();
            gtDetailPage.confirmCheckOut();
            TakePhoto.takePhoto(driver);
            By backHome_btn = MobileBy.xpath("Về trang chủ");
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            Assert.assertTrue(driver.findElement(backHome_btn).isDisplayed());
            driver.findElement(backHome_btn).click();
            driver.quit();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}

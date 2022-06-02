package testcase_uat;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pageobject.GtDetailPage;
import resource.Driver;
import utils.TakePhoto;

public class TC_CheckInCheckoutHome {
    AppiumDriver<MobileElement> driver;
    GtDetailPage gtDetailPage;
    @BeforeClass
    public AppiumDriver<MobileElement> navigateGtdetail() throws Exception {
        driver = Driver.openApp();
        return driver;
    }
    @Test(priority = 1)
    public void verifyCheckInCheckOutNearBy() {
        if (gtDetailPage.verifyStatusCheckInCheckout().equals("Check-in")) {
            gtDetailPage.checkIn();
        }
        if (gtDetailPage.verifyStatusCheckInCheckout().equals("Check-out")) {
            gtDetailPage.checkOut();
            TakePhoto.takePhoto(driver);
        }
    }

    @Test(priority = 2)
    public void verifyCheckInCheckoutSearch() throws Exception {

    }
}

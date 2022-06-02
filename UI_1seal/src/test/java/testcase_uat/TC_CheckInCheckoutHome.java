package testcase_uat;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pageobject.GtDetailPage;
import pageobject.HomePageSa;
import resource.Driver;
import utils.TakePhoto;

public class TC_CheckInCheckoutHome {
    AppiumDriver<MobileElement> driver;
    HomePageSa homePageSa;
    @BeforeClass
    public AppiumDriver<MobileElement> navigateHomePage() throws Exception {
        driver = Driver.openApp();
        homePageSa = new HomePageSa(driver);
        return driver;
    }
    @Test(priority = 1)
    public void verifyCheckInCheckOutNearBy() {
        try {
            homePageSa.checkInList("0111770001");
            Assert.assertEquals(homePageSa.verifyStatusCheckInCheckout(), "Check-out");
            homePageSa.checkOut();
            TakePhoto.takePhoto(driver);
            Assert.assertTrue(TakePhoto.verifyBackHome(driver));
            TakePhoto.clickBackHome(driver);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Test(priority = 2)
    public void verifyCheckInCheckOutSearch() throws Exception {
        try {
            homePageSa.clickCheckIn();
            homePageSa.findGtCheckIn("011177");
            homePageSa.checkInSearch("0111770002");
            Assert.assertEquals(homePageSa.verifyStatusCheckInCheckout(), "Check-out");
            homePageSa.checkOut();
            TakePhoto.takePhoto(driver);
            Assert.assertTrue(TakePhoto.verifyBackHome(driver));
            TakePhoto.clickBackHome(driver);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

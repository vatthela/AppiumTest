package testcase_uat;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pageobject.HomePageSa;
import resource.Driver;
import utils.TakePhoto;

public class TC_CheckInCheckOutHome {
    AppiumDriver<MobileElement> driver;
    HomePageSa homePageSa;

    @BeforeClass
    public void init() throws Exception {
        driver = Driver.openApp();
        homePageSa = new HomePageSa(driver);
    }

    @Test(priority = 1)
    public void verifyCheckInCheckOutNearBy() throws Exception {
        try {
            homePageSa.clickCheckIn();
            homePageSa.checkInList("0111770001");
            Assert.assertEquals(homePageSa.verifyStatusCheckInCheckout(), "Check-out");
            homePageSa.checkOut();
            TakePhoto.takePhoto(driver);
            Assert.assertTrue(TakePhoto.verifyBackHome(driver));
            TakePhoto.clickBackHome(driver);
        } catch (Exception e) {
            // TODO Auto-generated catch block
        }

    }

    @Test(priority = 2)
    public void verifyCheckInCheckOutSearch() throws Exception {
        homePageSa = new HomePageSa(driver);
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
        }
    }
}

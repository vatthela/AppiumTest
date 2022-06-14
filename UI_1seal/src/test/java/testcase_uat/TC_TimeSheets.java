package testcase_uat;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pageobject.HomeMenuPage;
import pageobject.HomePageSa;
import resource.Driver;


public class TC_TimeSheets {
    AppiumDriver<MobileElement> driver;
    HomeMenuPage homeMenuPage;
    HomePageSa homePageSa;

    @BeforeClass
    public AppiumDriver<MobileElement> init() throws Exception {
        driver = Driver.openApp();
        homeMenuPage = new HomeMenuPage(driver);
        return driver;
    }

    // Verify số công, số check-in, tính công
    @Test(priority = 1)
    public void verifyTimeSheets() throws Exception {
        homeMenuPage.moveTimeSheet();
        int oldTimeSheets = homeMenuPage.getTimeSheets();
        int oldtNumberCheckIn = homeMenuPage.getNumberCheckIn();
        String oldStatusWorkDays = homeMenuPage.getStatusWorkDays();
        homeMenuPage.clickBack();
        homeMenuPage.clickBack();
        homePageSa.clickCheckIn();
        homePageSa.checkInValid("0111770001");
        homeMenuPage = new HomeMenuPage(driver);
        homeMenuPage.moveTimeSheet();
        int newTimeSheets = homeMenuPage.getTimeSheets();
        int newtNumberCheckIn = homeMenuPage.getNumberCheckIn();
        String newStatusWorkDays = homeMenuPage.getStatusWorkDays();
        try {
            Assert.assertEquals(oldTimeSheets + 1, newTimeSheets);
            Assert.assertEquals(oldtNumberCheckIn + 1, newtNumberCheckIn);
            Assert.assertEquals(newStatusWorkDays, 1);
        } catch (Exception e) {
            // TODO Auto-generated catch block
        }
    }

}

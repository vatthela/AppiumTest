package testcase_uat;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pageobject.HomeMenuPage;
import pageobject.HomePageSa;
import resource.Driver;


public class TC_Policy {
    AppiumDriver<MobileElement> driver;
    HomeMenuPage homeMenuPage;
    HomePageSa homePageSa;

    @BeforeClass
    public AppiumDriver<MobileElement> navigateHomePage() throws Exception {
        driver = Driver.openApp();
        homeMenuPage = new HomeMenuPage(driver);
        return driver;
    }

    @Test
    public void verifyTimeSheets() throws Exception {
        homeMenuPage.movePolicy();
        Thread.sleep(3000);
        String name_of_policy = homeMenuPage.getTextPolicy();
        try {
            Assert.assertEquals(name_of_policy, "Chính sách bán hàng tháng 4");
        } catch (Exception e) {
            // TODO Auto-generated catch block
        }
        driver.quit();
    }
}
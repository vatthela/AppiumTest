package testcase_uat;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pageobject.GtDetailPage;
import pageobject.GtListPage;
import pageobject.PDPPage;
import pageobject.PLPPage;
import resource.Driver;
import utils.ScreenHandler;

/**
 * TC_OderProduct
 */
public class TC_OderProduct {
    AppiumDriver<MobileElement> driver;
    GtListPage gtListPage;
    GtDetailPage gtDetailPage;
    PLPPage plpPage;
    PDPPage pdpPage;
    @BeforeClass
    public void init() throws Exception {
        driver = Driver.openApp();
    }

    @Test
    public void name() {
        gtListPage = new GtListPage(driver);
        gtDetailPage = new GtDetailPage(driver);
        gtDetailPage.navigateGtDetailBySearch("0111770014");
        ScreenHandler.swipeuUp(driver, 50, 20);
        gtDetailPage.clickSearchProduct();
        String product = "PHVU Sữa nước tiệt trùng Nestle hương dâu trắng hộp";
        plpPage.sendKeySearchProduct(product);
        plpPage.clickPDP(product);
    }
}
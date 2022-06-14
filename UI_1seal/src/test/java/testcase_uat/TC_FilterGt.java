package testcase_uat;

import org.aspectj.lang.annotation.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pageobject.GtListPage;
import resource.Driver;
import utils.ScreenHandler;

public class TC_FilterGt {

    GtListPage gtListPage;
    AppiumDriver<MobileElement> driver;
    

    
    @BeforeClass
    public AppiumDriver<MobileElement> init() throws Exception{ 
        driver = Driver.openApp();
        gtListPage = new GtListPage(driver);
        return driver;
    }
    @Test(priority = 1)
    public void verifyFilterRoute() throws Exception{
        gtListPage.navigateFilter();
        gtListPage.clearAllFilter();
        gtListPage.selectFilterByRoute("X. Dị Nậu");
        gtListPage.applyFilter();
        String route = "X. Dị Nậu";
        String actual ="";
        if (gtListPage.getTextRoute(route).contains(route) == true) {
            actual = route;
        }
        try {
            Assert.assertEquals(actual , "X. Dị Nậu");
        } finally {
            System.out.println(actual);
        }
        
        String routeNotShow = "X. Lại Thượng";
        if (gtListPage.getTextRoute(routeNotShow) == null) {
            actual = null;
        } else{
            actual = "X. Lại Thượng";
        }
        try {
            Assert.assertNotEquals(actual , "X. Lại Thượng");
        } finally {
            System.out.println(actual);
        }
    }

    @Test(priority = 2)
    public void verifyFilterGtReported() throws Exception{
        gtListPage.navigateFilter();        
        gtListPage.clearAllFilter();
        gtListPage.applyFilter();
        if (gtListPage.getGtIsReported() == true){
            gtListPage.navigateFilter();        
            ScreenHandler.swipeuUp(driver, 20, 50);
            gtListPage.selectFilterGtReported();
            gtListPage.applyFilter();
            Assert.assertEquals(gtListPage.getGtIsReported() , false);
        }
    }
        /*
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Ẩn cửa hàng bạn đã báo cáo và đang chờ xét duyệt")));
        */
    @Test(priority = 3)
    public void verifyFilerManyCondition()throws Exception{
        gtListPage.navigateFilter();        
        gtListPage.clearAllFilter();
        gtListPage.selectFilterByRoute("X. Lại Thượng");
        ScreenHandler.swipeuUp(driver, 20 , 50);
        gtListPage.selectFilterVipStore();
        gtListPage.selectFilterGtReported();
        gtListPage.applyFilter();
        String route = "X. Lại Thượng";
        String actual_route ="";
        if (gtListPage.getTextRoute(route).contains(route) == true) {
            actual_route = route;
        }
        try {
            Assert.assertEquals(actual_route , "X. Lại Thượng");
            Assert.assertFalse(gtListPage.getGtIsReported());
            Assert.assertTrue(gtListPage.getGtIsVipStore());
        } finally {
            System.out.println(actual_route);
        }
    }
    @AfterTest
    public void closeTest() {
        gtListPage.navigateFilter();
        gtListPage.clearAllFilter();
        gtListPage.applyFilter();
        driver.quit();
    }    
    
}

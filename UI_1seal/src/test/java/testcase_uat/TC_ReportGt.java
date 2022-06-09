package testcase_uat;

import java.io.IOException;

import org.apache.commons.codec.language.bm.Rule.Phoneme;
import org.aspectj.lang.annotation.After;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pageobject.GtDetailPage;
import pageobject.GtListPage;
import pageobject.OnboardingPage;
import pageobject.ReportGtPage;
import resource.Driver;
import utils.ApiReportGtOPS;
import utils.ScreenHandler;
import utils.TakePhoto;

public class TC_ReportGt {
    AppiumDriver<MobileElement> driver;
    GtListPage gtListPage;
    GtDetailPage gtDetailPage;
    ReportGtPage reportGtPage;

    @BeforeClass
    public AppiumDriver<MobileElement> init() throws Exception {
        driver = Driver.openApp();
        gtListPage = new GtListPage(driver);
        return driver;
    }

    // Report GT
    @Test(priority = 1)
    public void verifyOnboardGt() throws InterruptedException {
        gtDetailPage = new GtDetailPage(driver);
        gtDetailPage.navigateGtDetailBySearch("0111770013");
        reportGtPage = new ReportGtPage(driver);
        reportGtPage.selectReportGt("Sai ngành nghề kinh doanh");
        reportGtPage.clickSendReportGt();
        Thread.sleep(20000);
        ScreenHandler.swipeuDown(driver, 50, 20);
        try {
            Assert.assertTrue(gtListPage.getGtIsVipStore());
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    @AfterTest
    public void reportGt() throws IOException {
        String reportId = ApiReportGtOPS.apiGetGtIsReported("0111770013");
        ApiReportGtOPS.apiRejectedReportGt(reportId);
    }
}
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
import utils.TakePhoto;

public class TC_ReportGt {
    AppiumDriver<MobileElement> driver;
    GtDetailPage gtDetailPage;
    ReportGtPage reportGtPage;
    @BeforeClass
    public AppiumDriver<MobileElement> navigateCustomerMenu() throws Exception {
        driver = Driver.openApp();
        GtListPage gtListPage = new GtListPage(driver);
        return driver;
    }

    // Report GT
    @Test(priority = 1)
    public void verifyOnboardGt() {
        gtDetailPage = new GtDetailPage(driver);
        gtDetailPage.navigateGtDetail("0111770013");
        reportGtPage = new ReportGtPage(driver);
        reportGtPage.selectReportGt("Sai ngành nghề kinh doanh");
        reportGtPage.clickSendReportGt();
    }

    @AfterTest
    public void reportGt() throws IOException {
        reportGtPage = new ReportGtPage(driver);
        reportGtPage.selectReportGt("Sai ngành nghề kinh doanh");
        reportGtPage.clickSendReportGt();
        int reportId = ApiReportGtOPS.apiGetGtIsReported("gt_id",12411);
        ApiReportGtOPS.apiApprovedReportGt(reportId);
    }
}
package testcase_uat;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;

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
import utils.GenarateRandomData;
import utils.TakePhoto;

public class TC_OnboardingGT {
    AppiumDriver<MobileElement> driver;
    GtDetailPage gtDetailPage;
    ReportGtPage reportGtPage;
    
    @BeforeClass
    public AppiumDriver<MobileElement> init() throws Exception {
        driver = Driver.openApp();
        GtListPage gtListPage = new GtListPage(driver);
        return driver;
    }

    // Onboarding GT
    @Test(priority = 1)
    public String verifyOnboardGt() {
        OnboardingPage onboardingPage = new OnboardingPage(driver);
        String phone = GenarateRandomData.randomPhone();
        String gtname = "Auto " + phone + " btl";
        onboardingPage.setInfoGt("Bui Tung Lam", phone, gtname, "Khu công nghệ cao", "Tạp hóa truyền thống");
        onboardingPage.takePhotoPanoramicGt();
        TakePhoto.takePhoto(driver);
        onboardingPage.takePhotoBannerOfGt();
        TakePhoto.takePhoto(driver);
        onboardingPage.clickConfirm();
        gtDetailPage.clickCloseTransportInfar();
        try {
            Assert.assertTrue(gtDetailPage.verifyName(gtname));
        } catch (Exception e) {
            // TODO: handle exception
        }
        return phone;
    }

    @Test(priority = 2)
    public void verifyInfoOnboardingGt() {

    }

    @AfterTest
    public void reportGt(String phone) throws IOException {
        reportGtPage = new ReportGtPage(driver);
        reportGtPage.selectReportGt("Sai ngành nghề kinh doanh");
        reportGtPage.clickSendReportGt();
        String reportId = ApiReportGtOPS.apiGetGtIsReported(phone);
        ApiReportGtOPS.apiApprovedReportGt(reportId);
    }

    public static void main(String[] args) throws IOException {
        String reportId = ApiReportGtOPS.apiGetGtIsReported("0115458874");
        ApiReportGtOPS.apiApprovedReportGt(reportId);
    }
}

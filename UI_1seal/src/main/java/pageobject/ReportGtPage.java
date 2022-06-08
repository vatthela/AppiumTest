package pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import utils.TakePhoto;

public class ReportGtPage {
    AppiumDriver<MobileElement> driver;
    By report_btn = MobileBy.AccessibilityId("Báo cáo");
    By gtDetailMenu_btn = MobileBy.AccessibilityId("Họ và tên chủ cửa hàng");
    By reasonReport_tf = MobileBy.AccessibilityId("Sai ngành nghề kinh doanh");
    By sendReport_btn = MobileBy.AccessibilityId("Gửi báo cáo");
    By send_btn = MobileBy.AccessibilityId("Gửi");

    public ReportGtPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    /*
     * Sai ngành nghề kinh doanh
     * Cửa hàng kinh doanh khác
     * Trùng với tài khoản GT khác
     * GT ảo/Địa chỉ không tồn tại
     * GT ngừng kinh doanh
     * Sai thông tin
     */
    public void selectReportGt(String reasonReport) {
        try {
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            if (driver.findElement(gtDetailMenu_btn).isDisplayed()) {
                driver.findElement(gtDetailMenu_btn).click();
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            driver.findElement(report_btn).click();
        }
        By reasonReport_tf = MobileBy.AccessibilityId(reasonReport);
        driver.findElement(reasonReport_tf).click();
        switch (reasonReport) {
            case "Sai ngành nghề kinh doanh":
                By takePhotoPanoramicGt = MobileBy.AccessibilityId("accessibilityId");
                driver.findElement(takePhotoPanoramicGt).click();
                TakePhoto.takePhoto(driver);
                By actualFormatGt = MobileBy.AccessibilityId("Cửa hàng kinh doanh khác");
                driver.findElement(actualFormatGt).click();
                break;
            case "Trùng với tài khoản GT khác":
                // Khối lệnh 2
                break;
            case "GT ảo/Địa chỉ không tồn tại":
                // Khối lệnh 2
                break;
            case "GT ngừng kinh doanh":
                break;
            case "Sai thông tin":
                // Khối lệnh n
                break;
            default:
                // Khối lệnh này được thực thi
                // nếu tất cả các điều kiện trên không thỏa mãn
        }
    }

    public void clickSendReportGt() {
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            if (driver.findElement(sendReport_btn).isDisplayed()) {
                driver.findElement(sendReport_btn).click();
            }
        } catch (Exception e) {
        }
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            if (driver.findElement(send_btn).isDisplayed()) {
                driver.findElement(send_btn).click();
            }
        } catch (Exception e) {
        }
        By confirmSendReportGt = MobileBy.AccessibilityId("Xác nhận");
        driver.findElement(confirmSendReportGt);
    }
}

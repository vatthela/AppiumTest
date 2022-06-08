package pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import utils.ScreenHandler;

public class OnboardingPage {
    AppiumDriver<MobileElement> driver;
    By onBoardingGt_btn = MobileBy.AccessibilityId("Tạo mới");
    By ownerName_it = MobileBy.AccessibilityId("Họ và tên chủ cửa hàng");
    By ownerPhone_it = MobileBy.AccessibilityId("Số điện thoại chủ cửa hàng");
    By next_btn = MobileBy.AccessibilityId("Tiếp tục");
    By gtName_it = MobileBy.AccessibilityId("Tên cửa hàng");
    By gtAndress_sl = MobileBy.AccessibilityId("Địa chỉ cửa hàng");
    By gtFormat_sl = MobileBy.AccessibilityId("Ngành nghề kinh doanh");
    By confirm = MobileBy.AccessibilityId("Xác nhận");
    By takePhotoPanoramicGt = MobileBy.AccessibilityId("//android.view.View[contains(@content-desc=\"Chụp\")]/android.widget.ImageView[1]");
    By takePhotoBannerOfGt = MobileBy.AccessibilityId("//android.view.View[contains(@content-desc=\"Chụp\")]/android.widget.ImageView[2]");

    public OnboardingPage(AppiumDriver<MobileElement> driver) {
        GtListPage gtListPage = new GtListPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(onBoardingGt_btn).click();
        this.driver = driver;
    }

    // Default select Route X. Lại Thượng

    public void setInfoGt(String ownerName, String owerPhone, String gtName, String gtAndress, String gtFormat) {
        driver.findElement(ownerName_it).sendKeys(ownerName);
        driver.findElement(ownerName_it).sendKeys(owerPhone);
        driver.findElement(next_btn).click();
        driver.findElement(gtName_it).sendKeys(gtName);
        driver.findElement(gtAndress_sl).click();
        By gtProvince = MobileBy.AccessibilityId("TP. Hà Nội") ;
        driver.findElement(gtProvince).click();
        By gtDistrict = MobileBy.AccessibilityId("H. Thạch Thất");
        driver.findElement(gtDistrict).click();
        ScreenHandler.swipeuUp(driver);
        By gtWard = MobileBy.AccessibilityId("X. Lại Thượng");
        driver.findElement(gtWard).click();
        By gtStreetName = MobileBy.AccessibilityId("Số nhà và tên đường");
        driver.findElement(gtStreetName).sendKeys(gtName);
        By confirmAndress = MobileBy.AccessibilityId("Xác nhận địa chỉ");
        driver.findElement(confirmAndress).click();
        driver.findElement(gtFormat_sl).click();
        By gtFormat_sl = MobileBy.xpath("//android.view.View[contains(@content-desc,\""+ gtFormat +"\")]");
        driver.findElement(gtFormat_sl).click();
    }

    public void clickConfirm(){
        driver.findElement(confirm).click();
    }

    public void takePhotoPanoramicGt(){
        driver.findElement(takePhotoPanoramicGt).click();
    }

    public void takePhotoBannerOfGt(){
        driver.findElement(takePhotoBannerOfGt).click();
    }
}

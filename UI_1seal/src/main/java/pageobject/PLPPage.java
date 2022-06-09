package pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class PLPPage {
    AppiumDriver<MobileElement> driver;
    By editSearchProduct_it = MobileBy.xpath("xpathExpression");
    By gtDetailMenu_btn = MobileBy.AccessibilityId("Họ và tên chủ cửa hàng");
    By reasonReport_tf = MobileBy.AccessibilityId("Sai ngành nghề kinh doanh");
    By sendReport_btn = MobileBy.AccessibilityId("Gửi báo cáo");
    By send_btn = MobileBy.AccessibilityId("Gửi");

    public void PLPPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    //Data "PHVU Sữa nước tiệt trùng Nestle hương dâu trắng hộp"
    public void sendKeySearchProduct(String text){
        driver.findElement(editSearchProduct_it).sendKeys(text);
    }

    //Data "PHVU Sữa nước tiệt trùng Nestle hương dâu trắng hộp"
    public void clickPDP(String text){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        By product = MobileBy.xpath("//android.widget.ImageView[contains(@content-desc,\""+ text +"\")]");
        driver.findElement(product).click();    
    }
}

package pageobject;

import java.util.concurrent.TimeUnit;

import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.springframework.util.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class GtList {
    
    AppiumDriver<MobileElement> driver;
    
    By customer_menu = MobileBy.xpath("//android.widget.ImageView[contains(@content-desc,\"Khách hàng\")]");
    By all_tab = MobileBy.xpath("//android.view.View[contains(@content-desc,\"Tất cả\")]");
    By support_tab = MobileBy.xpath("//android.view.View[contains(@content-desc,\"Chăm sóc\")]");
    By potential_taB = MobileBy.xpath("//android.view.View[contains(@content-desc,\"Tiềm năng\")]");
    By search = MobileBy.xpath("//android.widget.ImageView[@content-desc=\"Tìm kiếm tên GT, SĐT, địa chỉ\"]");
    By edit_search = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.widget.EditText");
    By cancel_search = MobileBy.xpath("//android.view.View[@content-desc=\"Huỷ\"]");
    By result_txt = MobileBy.xpath("//*[contains(@content-desc,\"Auto\")]");
    By confirm_btn = MobileBy.xpath("(//android.widget.Button[@content-desc=\"Xác minh\"])[1]");

    public GtList(AppiumDriver<MobileElement> driver){
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driver.findElement(customer_menu).click();
        this.driver = driver;
    }

    public GtList navigateCustomerMenu(){
        driver.findElement(customer_menu).click();
        return this;
    }

    public void clickSearchGt() {
        driver.findElement(search).click();
    }
    public void sendKeySearchGt(String text) {
        driver.findElement(edit_search).sendKeys(text);
    }

    public void clickCanCelSearchGt() {
        driver.findElement(cancel_search).click();
    }

    public String getTextSearchGt() {
        String result = driver.findElement(result_txt).getAttribute("content-desc");
        return result;
    }
    public String verifyL0(){
        String result = driver.findElement(confirm_btn).getAttribute("content-desc");
        return result;
    }  
}

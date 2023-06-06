package pageobject;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class PDPPage {
    AppiumDriver<MobileElement> driver;
    By decreaseProduct_btn = MobileBy.AccessibilityId("");
    By increaseProduct_btn = MobileBy.AccessibilityId("");  
    By numberProduct_it = MobileBy.xpath("//android.view.View[@content-desc=\"Số lượng: \"]/android.widget.EditText");
    By addProductToCart_btn = MobileBy.AccessibilityId("Thêm vào giỏ hàng");

    public void PDPPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public String getPrice(){
        By price_tf = MobileBy.xpath("//android.view.View[contains(@content-desc,\"đ\")]");
        String price  = driver.findElement(price_tf).getAttribute("content-desc");

        return null;

    }
}




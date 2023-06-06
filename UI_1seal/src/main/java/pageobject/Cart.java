package pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class Cart {
    AppiumDriver<MobileElement> driver;
    By closeCart_btn = MobileBy.AccessibilityId("btn_close");
    By oderProduct_tab = MobileBy.xpath("//*[contains(@content-desc,\"Đặt hộ\")]");
    By proposedProduct_tab = MobileBy.xpath("//*[contains(@content-desc,\"Chào hàng\")]");
    By clearAllProduct_btn = MobileBy.AccessibilityId("Xoá hết");
    By oderProduct_btn = MobileBy.xpath("//*[contains(content-desc,\"Tiến hành đặt hộ\")]");
    By proposedProduct_btn = MobileBy.xpath("//*[contains(content-desc,\"Gửi cho cửa hàng\")]");
    By promotion_tf = MobileBy.xpath("//android.view.View[@content-desc=\"Ưu đãi\"]");
    

    

    public Cart(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void clickDecreaseProduct_btn(String productName) {
        By decreaseProduct_btn = MobileBy.xpath("//*[contains(@content-desc,\""+ productName +"\")]/android.widget.ImageView[2]");
        driver.findElement(decreaseProduct_btn).click();
    }

    public void clickIncreaseProduct_btn(String productName) {
        By increaseProduct_btn = MobileBy.xpath("//*[contains(@content-desc,\""+ productName +"\")]/android.widget.ImageView[3]");
        driver.findElement(increaseProduct_btn).click();
    }

    public void clickSubmitOderPruduct(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(oderProduct_btn).click();
    }

    public void clickSubmitProposedProductt(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(proposedProduct_btn).click();
    }

    public void clickSupplier(String supplierName){
        By nameSupplier_tf = MobileBy.xpath("//android.view.View[contains(@content-desc,\""+ supplierName +"\")]");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(nameSupplier_tf).click();
    }

    public void clickPromotion(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(promotion_tf).click();
    }

    public String getTotalNumberAmount() {
        By totalNumberAmount_tf =  MobileBy.xpath("//*[contains(content-desc,\"Tổng tiền\")]");
        String totalNumberAmount = driver.findElement(totalNumberAmount_tf).getAttribute("content-desc");
        String [] array = totalNumberAmount.split(" ");
        String totalAmount = "";
        for (String n : array) {   
            if (n.contains("00đ")){
                totalAmount = n;
            }
        }
        return totalAmount;
    }


    public void selectPromotion(String promotionMessage) {
        
    }
    
    public static void main(String[] args) {

        
        
    }


}
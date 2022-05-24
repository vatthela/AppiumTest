package pageobject;

import java.util.concurrent.TimeUnit;

import javax.swing.text.AbstractDocument.Content;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class HomeMenuPage {
    AppiumDriver<MobileElement> driver;
    private By homeMenu = MobileBy.xpath("//android.widget.ImageView[@content-desc=\"im_avatar\"]");
    private By info_tf = MobileBy.xpath("//android.view.View[@content-desc=\"Thông tin tài khoản\"]");
    private By kpi_tf = MobileBy.AccessibilityId("Dự tính KPI và thưởng Mới");
    private By timeSheets_tf = MobileBy.xpath("//android.view.View[contains(@content-desc=\"Công hưởng lương\")]");
    private By incentive_tf = MobileBy.xpath("//android.view.View[@content-desc=\"Lương thưởng\"]");
    private By userGuide_tf = MobileBy.xpath("//android.view.View[@content-desc=\"Hướng dẫn sử dụng Mới\"]");
    private By ticket_tf = MobileBy.xpath("//android.view.View[@content-desc=\"Gửi yêu cầu hỗ trợ\"]");
    private By techSupport_tf = MobileBy.xpath("//android.view.View[@content-desc=\"Báo lỗi ứng dụng\"]");
    private By policy_tf = MobileBy.xpath("//android.view.View[@content-desc=\"Chính sách\"]");
    private By logout_tf = MobileBy.xpath("//android.view.View[@content-desc=\"Đăng xuất\"]");
    private By logout_btn = MobileBy.xpath("//android.widget.Button[@content-desc=\"ĐĂNG XUẤT\"]");
    private By back_btn = MobileBy.AccessibilityId("btn_back");


    private By login_by_account1 = MobileBy.AccessibilityId("Đăng nhập bằng tài khoản");
    //driver.findElementByXPath("//android.view.View[contains(@content-desc,'Đăng nhập bằng tài khoản')]").click();
    //android.view.View[@content-desc="Thông tin tài khoản"]


    public HomeMenuPage(AppiumDriver<MobileElement> driver) {
        driver.findElement(homeMenu).click();
        this.driver = driver;
    }
    public void moveInfo(){
        driver.findElement(info_tf).click();
    }

    public void moveTimeSheet(){
        driver.findElement(timeSheets_tf).click();
    }
    public void moveKpi(){
        driver.findElement(kpi_tf).click();
    }
    public void moveIncentive(){
        driver.findElement(incentive_tf).click();
    }
    public void moveUserGuide(){
        driver.findElement(userGuide_tf).click();
    }
    public void moveTickete(){
        driver.findElement(ticket_tf).click();
    }
    public void moveTechSupporte(){
        driver.findElement(techSupport_tf).click();
    }
    public void movePolicy(){
        driver.findElement(policy_tf).click();
    }
    public void moveLogout(){
        driver.findElement(logout_tf).click();
    }
    public void clickLogout(){
        driver.findElement(logout_btn).click();
    }
    public void clickBack(){
        driver.findElement(back_btn).click();
    }

    public String getTextPolicy(){
        By name_policy = MobileBy.xpath("//android.view.View[@content-desc=\"Chính sách bán hàng tháng 4\"]");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String text_name_policy = driver.findElement(name_policy).getAttribute("content-desc");
        System.out.print(text_name_policy);
        return text_name_policy;
        /*
        try{
            driver.findElement(name_policy);
            System.out.print("Có element");
        } catch (NoSuchElementException e){
            System.out.print("Không có element");
        }
        */
    }
    public String getNameSa(){
        By name_sa_txt = MobileBy.xpath("//android.view.View[contains(@content-desc,\"Auto\")]");
        String text_name_sa = driver.findElement(name_sa_txt).getAttribute("content-desc");
        return text_name_sa;
    }


}

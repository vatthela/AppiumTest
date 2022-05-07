package pageobject;

import java.util.concurrent.TimeUnit;

import javax.swing.text.AbstractDocument.Content;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class HomeMenu {
    AppiumDriver<MobileElement> driver;
    private By home_menu = MobileBy.xpath("//android.widget.ImageView[@content-desc=\"im_avatar\"]");
    private By info = MobileBy.xpath("//android.view.View[@content-desc=\"Thông tin tài khoản\"]");
    private By kpi = MobileBy.AccessibilityId("Dự tính KPI và thưởng Mới");
    private By time_sheets = MobileBy.xpath("//android.view.View[contains(@content-desc=\"Công hưởng lương\")]");
    private By incentive = MobileBy.xpath("//android.view.View[@content-desc=\"Lương thưởng\"]");
    private By user_guide = MobileBy.xpath("//android.view.View[@content-desc=\"Hướng dẫn sử dụng Mới\"]");
    private By ticket = MobileBy.xpath("//android.view.View[@content-desc=\"Gửi yêu cầu hỗ trợ\"]");
    private By techsupport = MobileBy.xpath("//android.view.View[@content-desc=\"Báo lỗi ứng dụng\"]");
    private By policy = MobileBy.xpath("//android.view.View[@content-desc=\"Chính sách\"]");
    private By logout = MobileBy.xpath("//android.view.View[@content-desc=\"Đăng xuất\"]");
    private By btn_logout = MobileBy.xpath("//android.widget.Button[@content-desc=\"ĐĂNG XUẤT\"]");


    private By login_by_account1 = MobileBy.AccessibilityId("Đăng nhập bằng tài khoản");
    //driver.findElementByXPath("//android.view.View[contains(@content-desc,'Đăng nhập bằng tài khoản')]").click();
    //android.view.View[@content-desc="Thông tin tài khoản"]


    public HomeMenu(AppiumDriver<MobileElement> driver) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(home_menu).click();
        this.driver = driver;
    }
    public void moveInfo(){
        driver.findElement(info).click();
    }

    public void moveTimeSheet(){
        driver.findElement(time_sheets).click();
    }
    public void moveKpi(){
        driver.findElement(kpi).click();
    }
    public void moveIncentive(){
        driver.findElement(incentive).click();
    }
    public void moveUserGuide(){
        driver.findElement(user_guide).click();
    }
    public void moveTickete(){
        driver.findElement(ticket).click();
    }
    public void moveTechSupporte(){
        driver.findElement(techsupport).click();
    }
    public void movePolicy(){
        driver.findElement(policy).click();
    }
    public void moveLogout(){
        driver.findElement(logout).click();
    }
    public void clickLogout(){
        driver.findElement(btn_logout).click();
    }

    public String getTextPolicy(){
        By name_policy = MobileBy.xpath("//android.view.View[@content-desc=\"Chính sách bán hàng tháng 4\"]");
        String text_name_policy;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        text_name_policy = driver.findElement(name_policy).getAttribute("content-desc");
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


}
